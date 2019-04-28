import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

/**
 * 
 */

/**
 * @author alehu
 *
 */
public class Pit 
{
	private Ellipse2D space;
	private int numberOfStones;
	private static int x=200;
	private static int y=100;
	private int count=0;
	
	public Pit(int numOfStones)
	{
		space = new Ellipse2D.Double();
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
	
	public void drawLeftMancala(Graphics2D g2)
	{
		RoundRectangle2D.Double pit = new RoundRectangle2D.Double(x+20,y+20,100,450,x+20,y+20);
		g2.draw(pit);
	}
	
	public void drawRightMancala(Graphics2D g2)
	{
		RoundRectangle2D.Double pit = new RoundRectangle2D.Double(x+875,y+20,100,450,x+20,y+20);
		g2.draw(pit);
	}
	
	public Ellipse2D drawpit(Graphics2D g2,int increment) {
		count+=increment;
		Ellipse2D.Double ellp = new Ellipse2D.Double(x+30+count, y+40, 90, 210);
		g2.draw(ellp);
		return ellp;
	}
	
	public Ellipse2D drawpit2(Graphics2D g2,int increment) {
		
		Ellipse2D.Double ellp = new Ellipse2D.Double(x+30+count, y+275, 90, 210);
		g2.draw(ellp);
		return ellp;
	}

	public int getNumberOfStones() {
		return numberOfStones;
	}

	public void setNumberOfStones(int numberOfStones) {
		this.numberOfStones = numberOfStones;
	}

}