import java.util.ArrayList;

import javax.swing.event.ChangeListener;

public class GameModel 
{
	private ArrayList<ShapePanel> stoneClusters;
	private ArrayList<ShapePanel> holes;
	private ArrayList<ChangeListener> listeners;
	
	/**
	 * Constructs a GameModel
	 */
	public GameModel()
	{
		stoneClusters = new ArrayList<ShapePanel>();
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

	
	
	
	
	
	
	
//--------------------GETTERS AND SETTERS-------------------------------	
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
