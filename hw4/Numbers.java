/**
 * Sebrianne Ferguson
 * CS 151 Fall 2018 Dr. Attar
 * JFrame with the editable numbers that correspond to the other frame with the graph
 *
 *
	 * the graph class relies on the numbers class. therefore, when a frame with the 
	 * numbers is edited or changed, then the graph changes at that instant.
	 * the listener will record any changes that happen to the numbers frame and then 
	 * change the graph accordingly.
	 *
 */
package hw4;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Numbers {
	
	JFrame frame; //frame to display everything
	JTextField[] tfs; //10 text fields to enter numbers
	JPanel field; //holds all the text fields
	Graph g;
	
	public Numbers() {
		frame = new JFrame("Numbers"); //make the JFrame
		frame.setPreferredSize(new Dimension(750, 500)); //set the size of the frame
		
		tfs = new JTextField[10]; //init the number of text fields
		field = new JPanel();
		g = new Graph();
		
		//make each of the text fields 
		for (int i = 0; i < tfs.length; i++) {
			tfs[i] = new JTextField();
			tfs[i].setPreferredSize(new Dimension(350,40));
			tfSetUp(tfs[i], i);
			//tfs[i].addActionListener(event -> {
				//tfSetUp(i);
				//g.appear(Integer.parseInt(tfs[i].getText()), i);
			//});
			field.add(tfs[i]);
			field.validate(); //each time you add something  you have to validate
			field.setLayout(new BoxLayout(field, BoxLayout.Y_AXIS));
			field.setVisible(true);
		}
		
		frame.add(field);
		
	}
	
	/**
	 * tfSetUp()
	 * @param x - a text field to set a listener for
	 * @param index - for referencing the specific bar to update
	 */
	public void tfSetUp(JTextField x, int index) {
		x.addActionListener(event -> {
			g.appear(Integer.parseInt(x.getText()), index);
		});
	}
	
	
	public static void main(String[] args) {
		Numbers n = new Numbers();
		n.frame.setLayout(new FlowLayout()); //makes sure that everything is evenly spaced.
		n.frame.pack(); //makes sure that it doesn't take up more room than needed
		n.frame.setVisible(true); //makes the frame visible
		n.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //or else it will end only when the user closes the window
	}
	

}
