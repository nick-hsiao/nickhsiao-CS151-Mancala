import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GameModel {
	private ArrayList<StoneCluster> stoneClusters;
	// private ArrayList<ShapePanel> holes;
	private ArrayList<ChangeListener> listeners;
	private boolean playerATurn;

	/**
	 * Constructs a GameModel
	 */
	public GameModel() {
		// true is A turn and false is B turn
		playerATurn = true;
		stoneClusters = new ArrayList<StoneCluster>(14);
		for (int i = 0; i < 14; i++) {
			stoneClusters.add(new StoneCluster(0, 0, true)); // add dummy clusters to start
		}
		// holes = new ArrayList<ShapePanel>();
		listeners = new ArrayList<ChangeListener>();
	}
	
	// if one side has 0 stone, the game end.
	public void isOver() {
		//int a = stoneClusters.
		//if(stoneClusters.get(index))
	}
	
	public void takeAll() {
		
	}
	

	// true =A
	//false =B
	//if currently playerATurn is A, it change to B and otherwise
	public void switchTurn() {
		if (playerATurn == true) {
			playerATurn = false;
		} else {
			playerATurn = true;
		}
	}

	/**
	 * Attach a listener to the model
	 * 
	 * @param cListener
	 *            - the ChangeListener to set
	 */
	public void attach(ChangeListener cListener) {
		listeners.add(cListener);
	}

	public void addStoneCluster(StoneCluster sc, int index) {
		this.stoneClusters.set(index, sc);
	}

	public void pickUpStones(StoneCluster sc) {
		// DO LOGIC OF MANCALA HERE?
		int stonesPickedUp = sc.getNumberOfStones();
		
		//System.out.println("--Player " + currentTurn + ".");
		if ((sc.getIndexInArray() < 6 && playerATurn == true)
				|| ((sc.getIndexInArray() > 6 && sc.getIndexInArray() < 13) && playerATurn == false)) {
			// Starts the loop one pit after the one clicked and moves however many stones
			// were picked up
			/*
			 * adds one stone to each pit visited. for(int i = sc.getIndexInArray() + 1; i
			 * <= stonesPickedUp + sc.getIndexInArray(); i++) {
			 * stoneClusters.get(i%stoneClusters.size()).addOneStone();
			 * 
			 * }
			 */
			int controlNum = sc.getIndexInArray() + stonesPickedUp;
			if((controlNum % stoneClusters.size())!=6 &&(controlNum % stoneClusters.size())!=13) {
				switchTurn();
				System.out.println("Turn has been changed");
			}
				
			sc.zeroStones();
			int currentIndex = sc.getIndexInArray() + 1; // starting point
			while (currentIndex < sc.getIndexInArray() + 1 + stonesPickedUp) {

				stoneClusters.get(currentIndex % stoneClusters.size()).addOneStone();

				currentIndex++; // increment the index
			}
			
			
			
			

			for (ChangeListener l : listeners) {
				l.stateChanged(new ChangeEvent(this));
			}
		}else {
			System.out.println("It's not your turn");
		}

	}

	// --------------------GETTERS AND SETTERS-------------------------------

	/**
	 * @return the stoneClusters
	 */
	public ArrayList<StoneCluster> getStoneClusters() {
		return stoneClusters;
	}

	/**
	 * @param stoneClusters
	 *            the stoneClusters to set
	 */
	public void setStoneClusters(ArrayList<StoneCluster> stoneClusters) {
		this.stoneClusters = stoneClusters;
	}

	/**
	 * @return the holes public ArrayList<ShapePanel> getHoles() { return holes; }
	 *         /**
	 * @param holes
	 *            - the holes to set
	 *
	 *            public void setHoles(ArrayList<ShapePanel> holes) { this.holes =
	 *            holes; } /**
	 * @return the listeners
	 */
	public ArrayList<ChangeListener> getListeners() {
		return listeners;
	}

	/**
	 * @param listeners
	 *            - the listeners to set
	 */
	public void setListeners(ArrayList<ChangeListener> listeners) {
		this.listeners = listeners;
	}

}