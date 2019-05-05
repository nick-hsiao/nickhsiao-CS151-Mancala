import java.awt.geom.Ellipse2D;


/**
 * StoneCluster is a the main GameShape class that holds the numberOfStones in a Pit
 * @author alehu
 *
 */
public class StoneCluster extends GameShape{
	int numberOfStones;
	int indexInArray;
	boolean isA;
	
	
	/**
	 * StoneCluster constructor that starts the cluster with specified number of stones
	 * @param numberOfStones
	 * @param indexInArray
	 */
	public StoneCluster(int numberOfStones, int indexInArray, boolean isA)
	{
		this.indexInArray = indexInArray;
		this.isA = isA;
		//Creates and adds a specified number of new circles to the GameShape - StoneCluster
		for(int i = 0; i < numberOfStones; i++)
		{
			this.numberOfStones++;
			add(new Ellipse2D.Double(30 +(this.numberOfStones%5)*10, 20 +(this.numberOfStones%6)*21, 10, 10));
		}
	}

	/**
	 * Add one stone to the cluster
	 */
	public void addOneStone()
	{
		this.numberOfStones++;
		add(new Ellipse2D.Double(30 +(this.numberOfStones%5)*10, 20 +(this.numberOfStones%6)*21, 10, 10));
	//	super.getLabel().repaint();
	}
	
	/**
	 * Add a specified number of stones to the cluster
	 * @param number - the number of stones to add
	 */
	public void addNumberOfStones(int number)
	{
		for(int i = 0; i < number; i++)
		{
			this.numberOfStones++;
			add(new Ellipse2D.Double(30 +(this.numberOfStones%5)*10, 20 +(this.numberOfStones%6)*21, 10, 10));
		}
		
	}
	

	/**
	 * Zero's out the stones in this cluster
	 */
	public void zeroStones()
	{
		this.reset();
		this.numberOfStones = 0;
		
	}
	
	/**
	 * 
	 * @return the StoneCluster object
	 */
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

	/**
	 * @return the indexInArray
	 */
	public int getIndexInArray() {
		return indexInArray;
	}

	/**
	 * @param indexInArray the indexInArray to set
	 */
	public void setIndexInArray(int indexInArray) {
		this.indexInArray = indexInArray;
	}
	
	
	
	


	
}
