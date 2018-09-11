package hw2;

import java.util.Scanner;

/**
Connects a phone to the mail system. The purpose of this
class is to keep track of the state of a connection, since
the phone itself is just a source of individual key presses.
*/
public class Connection
{
	/**
	   Construct a Connection object.
	   @param s a MailSystem object
	   @param p a Telephone object
	*/
	public Connection(MailSystem s, Telephone p)
	{
	   system = s;
	   phone = p;
	   resetConnection();
	   currentMailbox = null;
	}
	
	/**
	   Respond to the user's pressing a key on the phone touchpad
	   @param key the phone key pressed by the user
	*/
	public void dial(String key)
	{
		Scanner s = new Scanner(System.in);
	   if (state == CONNECTED) {
	      connect(key);
	      if (!key.equals("#")) { //added by Sebrianne Ferguson on 9/10/2018
	   	  	currentMailbox = system.findMailbox(accumulatedKeys);
	      }
	   }
	   else if (state == RECORDING) { //added by Sebrianne Ferguson on 9/9/2018
		   if (key.equals("1")) {
			   phone.speak(currentMailbox.getGreeting());
			   System.out.println("Record your message. Enter H to hang up.");
		   }
		   else if (key.equals("2")) {
			   System.out.println("Access your mailbox. Please enter your password followed by #.");
			   String pass = s.next();
			   login(pass);
		   }
		   else if (key.equals("#")) { //added by Sebrianne Ferguson on 9/9/2018 for part D
			   //skip
		   }
		   else { //added by Sebrianne Ferguson for part C
			   phone.speak(CHOICE);
		   }
	   }
	   else if (state == CHANGE_PASSCODE)
	      changePasscode(key);
	   else if (state == CHANGE_GREETING)
	      changeGreeting(key);
	   else if (state == MAILBOX_MENU)
	      mailboxMenu(key);
	   else if (state == MESSAGE_MENU)
	      messageMenu(key);
	}
	
	/**
	   Record voice.
	   @param voice voice spoken by the user
	*/
	public void record(String voice)
	{
	   if (state == RECORDING || state == CHANGE_GREETING)
	      currentRecording += voice;
	}
	
	/**
	   The user hangs up the phone.
	*/
	public void hangup()
	{
	   if (state == RECORDING)
	      currentMailbox.addMessage(new Message(currentRecording));
	   resetConnection();
	}
	
	/**
	   Reset the connection to the initial state and prompt
	   for mailbox number
	*/
	private void resetConnection()
	{
	   currentRecording = "";
	   accumulatedKeys = "";
	   state = CONNECTED;
	   phone.speak(INITIAL_PROMPT);
	}
	
	
	/**
	   Try to connect the user with the specified mailbox.
	   @param key the phone key pressed by the user
	*/
	private void connect(String key)
	{
		//Scanner s = new Scanner(System.in);
	   if (key.equals("#"))
	   {
	      currentMailbox = system.findMailbox(accumulatedKeys);
	      if (currentMailbox != null) {
	    	 state = RECORDING;
	    	//added by Sebrianne Ferguson on 9/9/2018
		    phone.speak(CHOICE);
		     
	         //phone.speak(currentMailbox.getGreeting());
	      }
	      else {
	         phone.speak("Incorrect mailbox number. Try again!" + CHOICE);
	      	 dial("2"); //added by Sebrianne Ferguson on 9/10/2018, added so the user can try again.
	      }
	      accumulatedKeys = "";
	      
	   }
	   else
	      accumulatedKeys += key;
	}
	
	/**
	   Try to log in the user.
	   @param key the phone key pressed by the user
	*/
	private void login(String key) //changed by Sebrianne Ferguson on 9/10/2018
	{
		for (int i = 0; i < key.length(); i++) {
		   if (key.substring(i, i+1).equals("#"))
		   {
		      if (currentMailbox.checkPasscode(accumulatedKeys))
		      {
		         state = MAILBOX_MENU;
		         phone.speak(MAILBOX_MENU_TEXT);
		      }
		      else {
		         phone.speak("Incorrect passcode. Try again!");
		         //added by Sebrianne Ferguson on 9/10/2018
		         accumulatedKeys = ""; //you have to clear the accumulated keys here as well
		      	 dial("2");
		      }
		      accumulatedKeys = "";
		   }
		   else
		      accumulatedKeys += key.substring(i, i+1);
		}
	}
	
	/**
	   Change passcode.
	   @param key the phone key pressed by the user
	*/
	private void changePasscode(String key)
	{
	   if (key.equals("#"))
	   {
	      currentMailbox.setPasscode(accumulatedKeys);
	      state = MAILBOX_MENU;
	      phone.speak(MAILBOX_MENU_TEXT);
	      accumulatedKeys = "";
	   }
	   else
	      accumulatedKeys += key;
	}
	
	/**
	   Change greeting.
	   @param key the phone key pressed by the user
	*/
	private void changeGreeting(String key)
	{
	   if (key.equals("#"))
	   {
	      currentMailbox.setGreeting(currentRecording);
	      currentRecording = "";
	      state = MAILBOX_MENU;
	      phone.speak(MAILBOX_MENU_TEXT);
	   }
	}
	
	/**
	   Respond to the user's selection from mailbox menu.
	   @param key the phone key pressed by the user
	*/
	private void mailboxMenu(String key)
	{
	   if (key.equals("1"))
	   {
	      state = MESSAGE_MENU;
	      phone.speak(MESSAGE_MENU_TEXT);
	   }
	   else if (key.equals("2"))
	   {
	      state = CHANGE_PASSCODE;
	      phone.speak("Enter new passcode followed by the # key");
	   }
	   else if (key.equals("3"))
	   {
	      state = CHANGE_GREETING;
	      phone.speak("Record your greeting, then press the # key");
	   }
	   //added by Sebrianne Ferguson on 9/10/2018	
	   else {
		   phone.speak(MAILBOX_MENU_TEXT);
	   }
	}
	
	/**
	   Respond to the user's selection from message menu.
	   @param key the phone key pressed by the user
	*/
	private void messageMenu(String key)
	{
	   if (key.equals("1"))
	   {
	      String output = "";
	      Message m = currentMailbox.getCurrentMessage();
	      if (m == null) output += "No messages." + "\n";
	      else output += m.getText() + "\n";
	      output += MESSAGE_MENU_TEXT;
	      phone.speak(output);
	   }
	   else if (key.equals("2"))
	   {
	      currentMailbox.saveCurrentMessage();
	      phone.speak(MESSAGE_MENU_TEXT);
	   }
	   else if (key.equals("3"))
	   {
	      currentMailbox.removeCurrentMessage();
	      phone.speak(MESSAGE_MENU_TEXT);
	   }
	   else if (key.equals("4"))
	   {
	      state = MAILBOX_MENU;
	      phone.speak(MAILBOX_MENU_TEXT);
	   }
	   else { //added by Sebrianne Ferguson on 9/10/2018
		   phone.speak(MESSAGE_MENU_TEXT);
	   }
	}
	
	private MailSystem system;
	private Mailbox currentMailbox;
	private String currentRecording;
	private String accumulatedKeys;
	private Telephone phone;
	private int state;
	
	private static final int DISCONNECTED = 0;
	private static final int CONNECTED = 1;
	private static final int RECORDING = 2;
	private static final int MAILBOX_MENU = 3;
	private static final int MESSAGE_MENU = 4;
	private static final int CHANGE_PASSCODE = 5;
	private static final int CHANGE_GREETING = 6;
	
	private static final String INITIAL_PROMPT = 
	      "Enter mailbox number followed by #";      
	private static final String MAILBOX_MENU_TEXT = 
	      "Enter 1 to listen to your messages\n"
	      + "Enter 2 to change your passcode\n"
	      + "Enter 3 to change your greeting";
	private static final String MESSAGE_MENU_TEXT = 
	      "Enter 1 to listen to the current message\n"
	      + "Enter 2 to save the current message\n"
	      + "Enter 3 to delete the current message\n"
	      + "Enter 4 to return to the main menu";
	//added by Sebrianne Ferguson
	private static final String CHOICE = "To leave a message, press (1), to access your mailbox, press (2)";
}
