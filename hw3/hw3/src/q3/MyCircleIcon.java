/**
 * Sebrianne Ferguson
 * CS 151 Attar 
 * Purpose of class: to create a specific circular icon to be used for question 3.
 */

package q3;
import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.Icon;

public class MyCircleIcon implements Icon{
	
	int size;
	Color circleColor;
	
	public MyCircleIcon() {
		size = 100; //i don't want it to change
		circleColor = Color.RED; //we initially want the circle to be red
	}
	
	public MyCircleIcon(Color c) {
		size = 100;
		circleColor = c;
	}

	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D)g; //convert to the newer version of a graphic
		Ellipse2D.Double circleIcon = new Ellipse2D.Double(x, y, size, size);
		g2.setColor(circleColor);
		g2.fill(circleIcon);
		
	}
	
	public void setColor(Color c) {
		circleColor = c;
	}
	
	/**public void paintRed() {
		Graphics2D g2 = (Graphics2D)g; //convert to the newer version of a graphic
		Ellipse2D.Double circleIcon = new Ellipse2D.Double(x, y, size, size);
		g2.setColor(Color.RED);
		g2.fill(circleIcon);
	}
	
	public void paintGreen() {
		Graphics2D g2 = (Graphics2D)g; //convert to the newer version of a graphic
		Ellipse2D.Double circleIcon = new Ellipse2D.Double(x, y, size, size);
		g2.setColor(Color.GREEN);
		g2.fill(circleIcon);
	}
	
	public void paintBlue() {
		Graphics2D g2 = (Graphics2D)g; //convert to the newer version of a graphic
		Ellipse2D.Double circleIcon = new Ellipse2D.Double(x, y, size, size);
		g2.setColor(Color.BLUE);
		g2.fill(circleIcon);
	}**/
	
}
