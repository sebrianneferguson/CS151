/**
 * Sebrianne Ferguson
 * CS 151 Attar
 * Instructions:
 * Write a program that shows a frame with three buttons labeled “Red”, “Green”, and “Blue”, and
 * a label containing an icon showing a circle that is initially red. As the user clicks the buttons, the
 * fill color of the circle should change. When you change the color, you need to invoke the repaint
 * method on the label. The call to repaint ensures that the paintIcon method is called so that
 * the icon can be repainted with the new color.
 * 
 * Credits: from the class textbook and in order to further understand jlabels and repaint, I looked at the site javaranch.com
 */

package q3;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Question3{
	
	JFrame frame; //frame to keep all of the icons and buttons in
	JButton red; //one button to change the icon color to red
	JButton blue; //one button to change the icon color to blue
	JButton green; //one button to change the icon color to green
	JTextField text; //a textbox to display a message to the user
	final int frameTextWidth; //sets the width of the textbox
	JLabel image; //a jlabel that i am using to store the circle icon i want to display
	MyCircleIcon circle; //an object from my class of circular icons
	
	/**
	 * ctor for the class
	 * makes the frame, sets the size, makes the buttons, sets the width of the text box
	 * and creates the icon initially as red and also the jlabel with the circle so it shows
	 */
	public Question3() {
		frame = new JFrame();
		frame.setSize(200, 200);
		red = new JButton("RED");
		green = new JButton("GREEN");
		blue = new JButton("BLUE");
		frameTextWidth = 50;
		text = new JTextField(frameTextWidth);
		text.setText("Click a button to switch the color of the dot.");
		frame.add(text);
		circle = new MyCircleIcon();
		image = new JLabel(circle);
	}
	
	/**
	 * addButtons()
	 * adds the buttons to the frame we created
	 */
	public void addButtonsAndFrame() {
		frame.add(red);
		frame.add(blue);
		frame.add(green);
		frame.add(image);
	}
	
	/**
	 * addListeners()
	 * creates listeners for each of the buttons so that when clicked,
	 * the icon changes the aprropriate color.
	 */
	public void addListeners() {
		//change the button color to red and repaint the jlabel  when clicked
		red.addActionListener(event -> {
			//ColorIcon bCircle = new ColorIcon(Color.BLUE);
			//a.circle = bCircle;
			//a.image = new JLabel(a.circle);
			circle.setColor(Color.RED);
			image.repaint();
		}
		);
		//change the button color to blue and repaint the jlabel when clicked
		blue.addActionListener(event -> {
			circle.setColor(Color.BLUE);
			image.repaint();
		}
		);
		//change the button color to green and repaint the jlabel when clicked
		green.addActionListener(event -> {
			circle.setColor(Color.GREEN);
			image.repaint();
		}
		);
	}

	public static void main(String[] args) {
		Question3 a = new Question3(); 
		a.addButtonsAndFrame(); //sets up the jframe
		a.addListeners(); //makes it so the circle changes color when clicked

		
		a.frame.setLayout(new FlowLayout()); //makes sure that everything is evenly spaced.
		a.frame.pack(); //makes sure that it doesn't take up more room than needed
		a.frame.setVisible(true); //makes the frame visible
		a.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //or else it will end only when the user closes the window
		//JOptionPane.showMessageDialog(null, "Sebrianne's Message", "Message", JOptionPane.INFORMATION_MESSAGE, new ColorIcon());

	}

}
