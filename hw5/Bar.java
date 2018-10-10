package hw5;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import javax.swing.Icon;

public class Bar implements Icon{
	
	int width;
	int height;
	
	/**
	 * ctor for the class
	 * @param width -- will differ for each bar
	 */
	public Bar(int width) {
		this.width = width;
		this.height = 25;
	}

	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D)g;
		Rectangle2D.Double r = new Rectangle2D.Double(x, y, getIconWidth(), getIconHeight());
		g2.setColor(Color.RED);
		g2.fill(r);
	}


}
