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
		// int a = stoneClusters.
		// if(stoneClusters.get(index))
	}

	public int takeAll(StoneCluster a) {
		int holdNum=0;
		int numberInLast=0;
		if(a.numberOfStones ==1) {
			StoneCluster opp = stoneClusters.get(12-a.getIndexInArray());
			holdNum = opp.getNumberOfStones();
			opp.zeroStones();
			numberInLast = a.getNumberOfStones();
			a.zeroStones();
			
			System.out.println("Opp stones: " + stoneClusters.get(12-a.getIndexInArray()).getNumberOfStones());
		}
		return holdNum+numberInLast;
	}

	// true =A
	// false =B
	// if currently playerATurn is A, it change to B and otherwise
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
		if(stonesPickedUp ==0) {
			System.out.println("Pick a Pit with STONES");
			return;
		}

		// System.out.println("--Player " + currentTurn + ".");
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
			

			sc.zeroStones();
			int currentIndex = sc.getIndexInArray() + 1; // starting point

			while (currentIndex < sc.getIndexInArray() + 1 + stonesPickedUp) {

				stoneClusters.get(currentIndex % stoneClusters.size()).addOneStone();

				currentIndex++; // increment the index
			}
			
			
			/*takeALL()
			 * */
			currentIndex-=1;
			StoneCluster lastCluster = stoneClusters.get(currentIndex % 14);
			// System.out.println("\nCurrentInt:" + currentIndex%stoneClusters.size() +
			// "PlayerATurn" + playerATurn);
			if(currentIndex%stoneClusters.size()< 6 && playerATurn ==true) {
				stoneClusters.get(6).addNumberOfStones(takeAll(lastCluster));
//				System.out.println("mancala A: " + stoneClusters.get(6).getNumberOfStones());
//				System.out.println("mancala B: " + stoneClusters.get(13).getNumberOfStones());
//				System.out.println("CurrentInt1: " + currentIndex%stoneClusters.size());
			}
			
			if((currentIndex%stoneClusters.size()<13&& currentIndex%stoneClusters.size()>6)&& playerATurn ==false) {
				stoneClusters.get(13).addNumberOfStones(takeAll(lastCluster));
//				System.out.println("mancala A: " + stoneClusters.get(6).getNumberOfStones());
//				System.out.println("mancala B: " + stoneClusters.get(13).getNumberOfStones());
//				System.out.println("CurrentInt2: " + currentIndex%stoneClusters.size());
			}
			
			if ((controlNum % stoneClusters.size()) != 6 && (controlNum % stoneClusters.size()) != 13) {
				switchTurn();
				System.out.println("Turn has been changed");
			}
			
			for (ChangeListener l : listeners) {
				l.stateChanged(new ChangeEvent(this));
			}
		} else {
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