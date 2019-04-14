import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 * 
 */

/**
 * @author alehu
 *
 */
public class Pit 
{
	private int numberOfStones;
	
	public Pit(int numOfStones)
	{
		this.numberOfStones = numOfStones;
		
	}
	
	public void changeNumOfStones(int numOfStones) 
	{
		this.numberOfStones = numOfStones;
	}
	
	public void draw(Graphics2D g2)
	{
		Rectangle2D.Double pit = new Rectangle2D.Double(0,0,300,20);
		g2.draw(pit);
	}

}
