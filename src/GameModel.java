import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * model class holds game data and logic, notifies view when udpated
 * 
 * @author hsiao,huerta,pham
 */
public class GameModel {
	private static final int NUMBER_OF_UNDO = 3;
	private static final int ZERO = 0;
	private ArrayList<StoneCluster> stoneClusters;
	private ArrayList<ChangeListener> listeners;
	private boolean playerATurn;
	private int undoA;
	private int undoB;
	private int[] backUp;
	private boolean isFirstTurn;
	private int aOrB;
	private int startingStones;

	/**
	 * constructor for model, initialize variables
	 * 
	 * @param s starting number of stones
	 */
	public GameModel(int s) {
		startingStones = s;
		aOrB = 0;
		isFirstTurn = true;
		backUp = new int[14];
		for (int i = 0; i < 14; i++) {
			backUp[i] = ZERO;
		}
		undoA = NUMBER_OF_UNDO;
		undoB = NUMBER_OF_UNDO;
		playerATurn = true;
		// array of empty clusters to be replaced when game starts
		stoneClusters = new ArrayList<StoneCluster>(14);
		for (int i = 0; i < 14; i++) {
			stoneClusters.add(new StoneCluster(0, 0, true));
		}
		listeners = new ArrayList<ChangeListener>();
	}

	/**
	 * back up the previous number of stiones into an array, used for the undo
	 * function
	 * 
	 * @param list array list of stone clusters
	 */
	public void setBackUp(ArrayList<StoneCluster> list) {
		for (int i = 0; i < list.size(); i++) {
			backUp[i] = list.get(i).getNumberOfStones();
		}
	}

	/**
	 * logic for the undo function
	 * 
	 */
	public void undo() {
		// determine which player is calling the undo
		if (isFirstTurn != true && undoA != 0 && undoB != 0) {
			if (playerATurn == false || !playerATurn == true) {
				switchTurn();
			}
			if (aOrB < 6 && playerATurn != true) {
				switchTurn();
			}

			if ((aOrB > 6 && aOrB < 13) && playerATurn == true) {
				switchTurn();
			}

			// restores previous state using backup array
			if (playerATurn == true) {
				if (undoA > 0) {
					undoA -= 1;
					System.out.println("Player A has " + undoA + " undos left");
					for (int i = 0; i < stoneClusters.size(); i++) {
						stoneClusters.get(i).setNumberOfStones(backUp[i]);
					}
				}
			} else {
				if (undoB > 0) {
					undoB -= 1;
					System.out.println("Player B has " + undoB + " undos left");
					// isUndo = true;
					for (int i = 0; i < stoneClusters.size(); i++) {
						stoneClusters.get(i).setNumberOfStones(backUp[i]);
					}
				}
			}
		}

		for (ChangeListener l : listeners) {
			l.stateChanged(new ChangeEvent(this));
		}

	}

	/**
	 * called every turn to check if either side is completely empty if either side
	 * is empty, game is over, higher score wins
	 * 
	 */
	public boolean isOver() {

		int totalStone = 0;
		for (int i = 0; i < 6; i++) {
			totalStone += stoneClusters.get(i).getNumberOfStones();
		}
		if (totalStone == 0) {
			int number = 0;
			for (int i = 7; i < 13; i++) {
				number += stoneClusters.get(i).getNumberOfStones();
				stoneClusters.get(i).zeroStones();
			}
			stoneClusters.get(13).addNumberOfStones(number);

			return true; // if A side has 0 stones
		}

		int totalStone2 = 0;
		for (int i = 7; i < 13; i++) {
			totalStone2 += stoneClusters.get(i).getNumberOfStones();
		}
		if (totalStone2 == 0) {
			int number = 0;
			for (int i = 0; i < 6; i++) {
				number += stoneClusters.get(i).getNumberOfStones();
				stoneClusters.get(i).zeroStones();
			}
			stoneClusters.get(6).addNumberOfStones(number);

			return true; // if B side has 0 stones
		}

		return false; // game is not over
	}

	/**
	 * check the last stone cluster, if the number of stones is equal to 1 this was
	 * previously empty and you take all the opponents stones and add it to your
	 * mancala
	 * 
	 * @param a stone cluster where last stone was dropped
	 * @return
	 */
	public int takeAll(StoneCluster a) {
		int holdNum = 0;
		int numberInLast = 0;
		if (a.numberOfStones == 1) {
			StoneCluster opp = stoneClusters.get(12 - a.getIndexInArray());
			holdNum = opp.getNumberOfStones();
			opp.zeroStones();

			System.out.println("Opp stones: " + stoneClusters.get(12 - a.getIndexInArray()).getNumberOfStones());
		}
		return holdNum + numberInLast;
	}

	/**
	 * switch player turns
	 * 
	 */
	public void switchTurn() {
		playerATurn = !playerATurn;
	}

	/**
	 * Attach a listener to the model array
	 * 
	 * @param cListener the change listener to be added
	 */
	public void attach(ChangeListener cListener) {
		listeners.add(cListener);
	}

	/**
	 * add a stone cluster to a specific index
	 * 
	 * @param sc    stone cluster to be added
	 * @param index desired index
	 */
	public void addStoneCluster(StoneCluster sc, int index) {
		this.stoneClusters.set(index, sc);
	}

	/**
	 * store previous state of stone clusters into backup array at initialization
	 * 
	 */
	public void createbackUp() {
		for (int i = 0; i < 14; i++) {
			backUp[i] = stoneClusters.get(i).getNumberOfStones();
		}
	}

	/**
	 * logic for player taking turn, called when a pit is clicked
	 * 
	 * @param sc stone cluster that was clicked
	 */
	public void pickUpStones(StoneCluster sc) {
		isFirstTurn = false;
		createbackUp();
		aOrB = sc.getIndexInArray();

		// test for clicking on an empty pit
		int stonesPickedUp = sc.getNumberOfStones();
		if (stonesPickedUp == 0) {
			System.out.println("Pick a Pit with STONES");
			return;
		}

		// determine if the current player has clicked their own pit (ex. making sure
		// Player A clicked one of his/her pits)
		if ((sc.getIndexInArray() < 6 && playerATurn == true)
				|| ((sc.getIndexInArray() > 6 && sc.getIndexInArray() < 13) && playerATurn == false)) {

			// initialize variables
			int controlNum = sc.getIndexInArray() + stonesPickedUp;
			sc.zeroStones();
			int currentIndex = sc.getIndexInArray() + 1;

			// continue dropping stones while their are stones remaining
			while (currentIndex < sc.getIndexInArray() + 1 + stonesPickedUp) {
				// make sure player doesnt drop stone into opponents mancala
				if (currentIndex % 14 == 6 && !playerATurn || currentIndex % 14 == 13 && playerATurn) {
					currentIndex++;
					stonesPickedUp++;
					continue;
				}

				stoneClusters.get(currentIndex % stoneClusters.size()).addOneStone();
				currentIndex++;
			}

			currentIndex -= 1;
			StoneCluster lastCluster = stoneClusters.get(currentIndex % 14);

			// check conditions for player taking all stones from opposite pit
			if (currentIndex % stoneClusters.size() < 6 && playerATurn == true) {
				stoneClusters.get(6).addNumberOfStones(takeAll(lastCluster));
			}

			if ((currentIndex % stoneClusters.size() < 13 && currentIndex % stoneClusters.size() > 6)
					&& playerATurn == false) {
				stoneClusters.get(13).addNumberOfStones(takeAll(lastCluster));
			}

			// check if player turn changes
			if ((controlNum % stoneClusters.size()) != 6 && (controlNum % stoneClusters.size()) != 13) {
				switchTurn();
				System.out.println("Turn has been changed");
			}

			// set amount of undos
			if (aOrB > 6 && aOrB < 13) {
				undoA = 3;
			}
			if (aOrB < 6) {
				undoB = 3;
			}

			for (ChangeListener l : listeners) {
				l.stateChanged(new ChangeEvent(this));
			}

			// check if game is over
			if (isOver()) {
				System.out.println("Game Over");
				if (stoneClusters.get(6).getNumberOfStones() > stoneClusters.get(13).getNumberOfStones()) {
					System.out.println("Player A won! ");
					JOptionPane.showMessageDialog(null, "Player A won", "Game Alert: " + "Winner Announcment",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					System.out.println("Player B won! ");
					JOptionPane.showMessageDialog(null, "Player B won", "Game Alert: " + "Winner Announcment",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}

		} else {
			//error warning when clicking on a pit thats not yours
			System.out.println("It's not your turn");
			JOptionPane.showMessageDialog(null, "That's not your pit!", "Game Alert", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	/**
	 * getter method for starting number of stones
	 * 
	 * @return int number of starting stones
	 */
	public int getStartingStones() {
		return this.startingStones;
	}

	/**
	 * getter method for current player turn
	 * 
	 * @return boolean true if it is player A's turn, false otherwise
	 */
	public boolean getPlayerTurn() {
		return this.playerATurn;
	}

	/**
	 * get the current state of stone clusters
	 * 
	 * @return array list of stone clusters
	 */
	public ArrayList<StoneCluster> getStoneClusters() {
		return stoneClusters;
	}

	/**
	 * updating the model data for stone clusters
	 * 
	 * @param stoneClusters updated array list of stone clusters
	 */
	public void setStoneClusters(ArrayList<StoneCluster> stoneClusters) {
		this.stoneClusters = stoneClusters;
	}

	/**
	 * getter method for accessing list of change listeners
	 * 
	 */
	public ArrayList<ChangeListener> getListeners() {
		return listeners;
	}

	/**
	 * setting the listeners
	 * 
	 * @param listeners change listeners to be set
	 */
	public void setListeners(ArrayList<ChangeListener> listeners) {
		this.listeners = listeners;
	}

}