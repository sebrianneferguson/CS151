package hw2;

import java.util.ArrayList;

/**
   A system of voice mail boxes.
*/
public class MailSystem
{
   /**
      Constructs a mail system with a given number of mailboxes
      @param mailboxCount the number of mailboxes
   */
   public MailSystem(int mailboxCount)
   {
      mailboxes = new ArrayList<>();

      // Initialize mail boxes.

      for (int i = 0; i < mailboxCount; i++)
      {
         String passcode = "" + (i + 1);
         String greeting = "You have reached mailbox " + (i + 1)
               + ". \nPlease leave a message now.";
         mailboxes.add(new Mailbox(passcode, greeting));
      }
   }

   /**
      Locate a mailbox.
      @param ext the extension number
      @return the mailbox or null if not found
   */
   public Mailbox findMailbox(String ext)
   {
	  //added by Sebrianne Ferguson on September 8th, 2018
	  //I put the if statement inside of a try block. if the numberformatexception
	  //error comes up, the catch block will handle it.
	  try {
	      int i = Integer.parseInt(ext);
	      if (1 <= i && i <= mailboxes.size())
	         return  mailboxes.get(i - 1);
	  }
	  catch(java.lang.NumberFormatException wrong) { //for null input or a letter instead of a number
		  System.out.println("No such mailbox.");
	  }
	  return null;
   }

   private ArrayList<Mailbox> mailboxes;
}
