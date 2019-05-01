import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GameModel 
{
	private ArrayList<StoneCluster> stoneClusters;
	private ArrayList<ShapePanel> holes;
	private ArrayList<ChangeListener> listeners;
	
	/**
	 * Constructs a GameModel
	 */
	public GameModel()
	{
		stoneClusters = new ArrayList<StoneCluster>();
		holes = new ArrayList<ShapePanel>();
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
	
	public void addStoneCluster(StoneCluster sc)
	{
		this.stoneClusters.add(sc);
	}

	public void pickUpStones(StoneCluster sc)
	{
		//DO LOGIC OF MANCALA HERE?
		sc.zeroStones();
		
		
		for(ChangeListener l : listeners)
		{
			l.stateChanged(new ChangeEvent(this));
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
	 */
	public ArrayList<ShapePanel> getHoles() {
		return holes;
	}
	
	/**
	 * @param holes - the holes to set
	 */
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

	
	
}
