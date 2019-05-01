import java.awt.geom.Ellipse2D;


/**
 * 
 * @author alehu
 *
 */
public class StoneCluster extends GameShape{
	int numberOfStones;
	final Ellipse2D.Double stoneShape = new Ellipse2D.Double(30 +(this.numberOfStones%5)*10, 40 +(this.numberOfStones%6)*20, 10, 10);
	
	public StoneCluster(int numberOfStones)
	{
		//Creates and adds a specified number of new circles to the GameShape - StoneCluster
		for(int i = 0; i < numberOfStones; i++)
		{
			this.numberOfStones++;
			add(new Ellipse2D.Double(30 +(this.numberOfStones%5)*10, 40 +(this.numberOfStones%6)*21, 10, 10));
		}
	}
	
	public StoneCluster getStoneCluster()
	{
		return this;
	}

	/**
	 * @return the numberOfStones
	 */
	public int getNumberOfStones() {
		return numberOfStones;
	}

	/**
	 * @param numberOfStones the numberOfStones to set
	 */
	public void setNumberOfStones(int numberOfStones) {
		this.numberOfStones = numberOfStones;
	}
	
	public void addOneStone()
	{
		this.numberOfStones++;
		add(new Ellipse2D.Double(30 +(this.numberOfStones%5)*10, 40 +(this.numberOfStones%6)*21, 10, 10));
		
	}
	
	public void addNumberOfStones(int number)
	{
		for(int i = 0; i < number; i++)
		{
			this.numberOfStones++;
			add(new Ellipse2D.Double(30 +(this.numberOfStones%5)*10, 40 +(this.numberOfStones%6)*21, 10, 10));
		}
		
	}
	
	public void subtractOneStone()
	{
		this.numberOfStones--;
	}
	
	
	public void zeroStones()
	{
		this.reset();
		this.numberOfStones = 0;
		
	}


	
}
