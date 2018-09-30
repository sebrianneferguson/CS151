/**
 * Sebrianne Ferguson
 * CS 151 Attar
 * Question 4 Instructions:
 * Write a program that shows a frame with two buttons labeled “Zoom in”, and “Zoom out”, and a
 * label containing a car icon. As the user clicks the buttons, the car should get larger or smaller. As
 * in Question 3, you need to invoke the repaint method on the label to trigger a redisplay of the
 * image.
 */
package q4;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;

public class Question4 {
	
	JFrame frame; //makes a frame for everything
	JLabel label; //a label to store the caricon
	CarIcon car; //the car that will be zoomed in and out
	JButton in; //a zoom in button
	JButton out; //a zoom out button
	int labelx; //dimensions for the label
	int labely;
	int framex;//dimensions for the frame
	int framey;
	
	/**
	 * ctor for the class
	 */
	public Question4() {
		frame = new JFrame();
		framex = 400;
		framey = 400;
		frame.setPreferredSize(new Dimension(framex,framey));
		car = new CarIcon(50);
		label = new JLabel(car);
		labelx = 250;
		labely = 250;
		label.setSize(labelx, labely);
		in = new JButton("ZOOM IN");
		out = new JButton("ZOOM OUT");
	}
	
	/**
	 * addElements()
	 * adds all the buttons and the label to the frame
	 */
	public void addElements() { 
		frame.add(in);
		frame.add(out);
		frame.add(label);
		
	}
	
	
	public static void main(String[] args) {
		Question4 x = new Question4();
		x.addElements();
		
		x.in.addActionListener(event -> { // when in is clicked, the image will become larger and everything will grow in size
			x.frame.setSize(x.framex + 20, x.framey + 20);
			x.label.setSize(x.labelx + 20, x.labely + 20);
			x.car.setNewDimensions(1.2);
			x.label.repaint();
		});
		x.out.addActionListener(event -> { //same as in except everything becomes smaller
			x.frame.setSize((int)(x.framex - 20), (int)(x.framey - 20));
			x.label.setSize((int)(x.labelx - 20), (int)(x.labely - 20));
			x.car.setNewDimensions(0.8);
			x.label.repaint();
		});
		
		x.frame.setLayout(new FlowLayout()); //makes sure that everything is evenly spaced.
		x.frame.pack(); //makes sure that it doesn't take up more room than needed
		x.frame.setVisible(true); //makes the frame visible
		x.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //or else it will end only when the user closes the window
		
	}

}
