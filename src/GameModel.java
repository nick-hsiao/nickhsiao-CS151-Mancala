import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GameModel 
{
	private ArrayList<StoneCluster> stoneClusters;
	//private ArrayList<ShapePanel> holes;
	private ArrayList<ChangeListener> listeners;
	private boolean playerATurn;
<<<<<<< HEAD
	private int scoreA;
	private int scoreB;
=======
	private PlayerLetter currentTurn;
>>>>>>> 9ca2479c5422ab032573db02710100f46db2bb77
	
	/**
	 * Constructs a GameModel
	 */
	public GameModel()
	{
		currentTurn = PlayerLetter.A;
		stoneClusters = new ArrayList<StoneCluster>(14);
		for(int i = 0; i < 14; i++)
		{
			stoneClusters.add(new StoneCluster(0,0,PlayerLetter.NONE)); //add dummy clusters to start
		}
		//holes = new ArrayList<ShapePanel>();
		listeners = new ArrayList<ChangeListener>();
	}
	
	/**
	 * Attach a listener to the model
	 * @param cListener - the ChangeListener to set
	 */
	public void attach(ChangeListener cListener)
	{
		listeners.add(cListener);
	}
	
	public void addStoneCluster(StoneCluster sc, int index)
	{
		this.stoneClusters.set(index, sc);
	}

	public void pickUpStones(StoneCluster sc)
	{
		//DO LOGIC OF MANCALA HERE?
		int stonesPickedUp = sc.getNumberOfStones();
		sc.zeroStones();
		
		//Starts the loop one pit after the one clicked and moves however many stones were picked up
		/*adds one stone to each pit visited.
		for(int i = sc.getIndexInArray() + 1; i <= stonesPickedUp + sc.getIndexInArray(); i++)
		{
			stoneClusters.get(i%stoneClusters.size()).addOneStone();
			
		}
		*/
		
		//System.out.println(sc.getIndexInArray() + "--Player " + currentTurn + ".");
		//condition to switch turn
		if(sc.getLetter() == currentTurn)
		{
			
			
			
			
			
			
		}
		
		
		
		int afterClickedIndex = sc.getIndexInArray() + 1; //starting point
		while(afterClickedIndex < sc.getIndexInArray()+1 + stonesPickedUp)
		{
			
			stoneClusters.get(afterClickedIndex%stoneClusters.size()).addOneStone();
			
			afterClickedIndex++; //increment the index
		}
		
		
		for(ChangeListener l : listeners)
		{
			l.stateChanged(new ChangeEvent(this));
		}
		
	}
	
	
	
	
	//switches whos turn in is
	public void switchTurn() {
		if(currentTurn == PlayerLetter.A){
			currentTurn = PlayerLetter.B;
		}
		else {
			currentTurn = PlayerLetter.A;
		}
	}
	
	
	
//--------------------GETTERS AND SETTERS-------------------------------	
	
	
	


	/**
	 * @return the stoneClusters
	 */
	public ArrayList<StoneCluster> getStoneClusters() {
		return stoneClusters;
	}

	/**
	 * @param stoneClusters the stoneClusters to set
	 */
	public void setStoneClusters(ArrayList<StoneCluster> stoneClusters) {
		this.stoneClusters = stoneClusters;
	}
	
	/**
	 * @return the holes
	public ArrayList<ShapePanel> getHoles() {
		return holes;
	}
	/**
	 * @param holes - the holes to set
	 *
	public void setHoles(ArrayList<ShapePanel> holes) {
		this.holes = holes;
	}


	/**
	 * @return the listeners
	 */
	public ArrayList<ChangeListener> getListeners() {
		return listeners;
	}

	/**
	 * @param listeners - the listeners to set
	 */
	public void setListeners(ArrayList<ChangeListener> listeners) {
		this.listeners = listeners;
	}

	public void setScoreA(){
		this.scoreA = stoneClusters.get(6).getNumberOfStones();
	}

	public int getScoreA(){
		return this.scoreA;
	}

	public void setScoreB(){
		this.scoreB = stoneClusters.get(13).getNumberOfStones();
	}

	public int getScoreB(){
		return this.scoreB;
	}



	
	
}
