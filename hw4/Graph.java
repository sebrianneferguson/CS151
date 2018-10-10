/**
 * Sebrianne Ferguson
 * CS 151 Fall 2018 Dr. Attar
 * Project started October 7th, 2018
 * 
 * Instructions: 
 * In this homework, write a program that contains two frames, one with a column of text fields
 * containing numbers, and another that draws a bar graph showing the values of the numbers.
 * When the user edits one of the numbers, the graph should be redrawn. Use the observer pattern.
 * Store the data in a model. Attach the graph view as a listener. When a number is updated, the
 * number view should update the model, and the model should tell the graph view that a change
 * has occurred. As a result, the graph view should repaint itself.
 */

package hw4;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.Shape;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Graph {
	
	JFrame frame; //holds everything
	JLabel[] bars; //putting the bars in an array so I can access a specific one to change
	JPanel plot; //holds all of the JLabels
	
	/**
	 * ctor
	 * creates a new frame
	 * initializes the JLabel array
	 * creates a new JPanel
	 * adds JLabels with width 0 bars to the JPanel
	 * sets the layout of the frame to a border layout, packs everything
	 * and makes sure that initially the graph frame is not visible
	 */
	public Graph() {
		frame = new JFrame("Your Graph");
		frame.setPreferredSize(new Dimension(800, 800));
		
		bars = new JLabel[10]; //we will have 10 bars
		plot = new JPanel();
		
		//create the bars and add it to the plot
		for (int i = 0; i < bars.length; i++) {
			Bar b = new Bar(0);
			bars[i] = new JLabel(b);
			addToPlot(bars[i]);
		}
		
		frame.setLayout(new BorderLayout());
		frame.add(plot, BorderLayout.CENTER);
		frame.pack(); //makes sure that it doesn't take up more room than needed
		frame.setVisible(false); //makes the frame visible
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	/**
	 * appear(int width, int index)
	 * @param width - the width of the bar we should create
	 * @param index - which one we should change
	 */
	public void appear(int width, int index) {
		bars[index] = new JLabel(new Bar(width)); //replace the old bar with a new one
		plot.removeAll(); //remove all the old bars from the graph
		plot.updateUI(); //refresh the screen
		
		for (JLabel label: bars) {
			addToPlot(label); //add the labels back to the plot
		}
		
		frame.setVisible(true); //show the graph
	}
	
	/**
	 * addToPlot(x)
	 * @param x - a JLabel to add to the JPanel
	 */
	public void addToPlot(JLabel x) {
		plot.add(x); //add the JLabel to the JPanel
		plot.validate(); //each time you add something  you have to validate
		plot.setLayout(new BoxLayout(plot, BoxLayout.Y_AXIS)); 
		plot.setVisible(true);
	}

}
