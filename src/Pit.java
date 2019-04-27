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
		this.setNumberOfStones(numOfStones);
		
	}
	
	/*
	 * adding 2 methods increment() and deecrement()
	 * to control the pit everytime a turn is perform
	 * */
	public void increment() {
		this.numberOfStones++;
	}
	
	public void decrement() {
		this.numberOfStones--;
	}
	
	public void changeNumOfStones(int numOfStones) 
	{
		this.setNumberOfStones(numOfStones);
	}
	
	public void draw(Graphics2D g2)
	{
		Rectangle2D.Double pit = new Rectangle2D.Double(0,0,300,20);
		g2.draw(pit);
	}

	public int getNumberOfStones() {
		return numberOfStones;
	}

	public void setNumberOfStones(int numberOfStones) {
		this.numberOfStones = numberOfStones;
	}

}