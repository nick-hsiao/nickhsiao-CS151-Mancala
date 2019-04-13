import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author alehu
 *
 */
public class PitComponent extends JPanel
{
	private int numberOfStones;
	private int x;
	private int y;
	private int width;
	
	/**
	 * Constructor for PitComponent
	 * @param numberOfStones - the number of stones in the pit
	 * @param x - the x position of the pit
	 * @param y - the y position of the pit
	 * @param width - the width of the pit
	 */
	public PitComponent(int numberOfStones, int x, int y, int width)
	{
		this.numberOfStones = numberOfStones;
		this.x = x;
		this.y = y;
		this.width = width;
	}
	
	/**
	 * Paints the pit as a rectangle
	 * @param g2 - graphics 2D...
	 */
	public void paintComponent(Graphics2D g2)
	{
		Rectangle2D.Double hole = new Rectangle2D.Double(x,y,width,width*1.5);
		g2.draw(hole);
		
	}

	/**
	 * @return the numberOfStones
	 */
	public int getNumberOfStones() {
		return numberOfStones;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param numberOfStones - the numberOfStones to set
	 */
	public void setNumberOfStones(int numberOfStones) {
		this.numberOfStones = numberOfStones;
	}

	/**
	 * @param x - the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @param y - the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @param width - the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	
}
