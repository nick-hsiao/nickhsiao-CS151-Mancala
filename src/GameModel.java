import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
	 * Constructs a GameModel
	 */
	public GameModel(int s) {
		// true is A turn and false is B turn
		startingStones = s;
		aOrB=0;
		isFirstTurn = true;
		backUp = new int[14];
		for (int i = 0; i < 14; i++) {
			backUp[i] = ZERO;
		}
		undoA = NUMBER_OF_UNDO;
		undoB = NUMBER_OF_UNDO;
		playerATurn = true;
		stoneClusters = new ArrayList<StoneCluster>(14);
		for (int i = 0; i < 14; i++) {
			stoneClusters.add(new StoneCluster(0, 0, true)); // add dummy clusters to start
		}
		listeners = new ArrayList<ChangeListener>();
	}

	public void setBackUp(ArrayList<StoneCluster> list) {
		for (int i = 0; i < list.size(); i++) {
			backUp[i] = list.get(i).getNumberOfStones();
		}
	}

	public void undo() {
		if(isFirstTurn!= true && undoA !=0 && undoB!=0) {
			if(playerATurn == false || !playerATurn == true) {
				switchTurn();
			}
			if(aOrB<6 && playerATurn !=true) {
				switchTurn();
			}
			
			if((aOrB>6 && aOrB<13) && playerATurn ==true) {
				switchTurn();
			}
				
			if (playerATurn == true) {
				if (undoA > 0 ) {
					undoA -= 1;
					System.out.println("Player A has " + undoA + " undos left");
					for(int i=0;i<stoneClusters.size();i++) {
						stoneClusters.get(i).setNumberOfStones(backUp[i]);
					}
				}
			} else {
				if (undoB > 0 ) {
					undoB -= 1;
					System.out.println("Player B has " + undoB + " undos left");
					//isUndo = true;
					for(int i=0;i<stoneClusters.size();i++) {
						stoneClusters.get(i).setNumberOfStones(backUp[i]);
					}
				}
			}
		}
		
		for (ChangeListener l : listeners) {
			l.stateChanged(new ChangeEvent(this));
		}
		
		
	}

	// if one side has 0 stone, the game end.
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

			return true; // if A side has 0 stone
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

			return true; // if B side has 0 stone
		}

		return false; // if the game is not over yet
	}

	public int takeAll(StoneCluster a) {
		int holdNum = 0;
		int numberInLast = 0;
		if (a.numberOfStones == 1) {
			StoneCluster opp = stoneClusters.get(12 - a.getIndexInArray());
			holdNum = opp.getNumberOfStones();
			opp.zeroStones();
			// numberInLast = a.getNumberOfStones();
			// a.zeroStones();

			System.out.println("Opp stones: " + stoneClusters.get(12 - a.getIndexInArray()).getNumberOfStones());
		}
		return holdNum + numberInLast;
	}

	// true =A
	// false =B
	// if currently playerATurn is A, it change to B and otherwise
	public void switchTurn() {
		if (playerATurn == true) {
			playerATurn = false;
			//isUndo = false;
		} else {
			playerATurn = true;
			//isUndo = false;
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

	public void createbackUp() {
		for (int i = 0; i < 14; i++) {
			backUp[i] = stoneClusters.get(i).getNumberOfStones();
		}
	}

	public void pickUpStones(StoneCluster sc) {
		// DO LOGIC OF MANCALA HERE?
		isFirstTurn = false;
		createbackUp();
		aOrB = sc.getIndexInArray(); 
		

		int stonesPickedUp = sc.getNumberOfStones();
		if (stonesPickedUp == 0) {
			System.out.println("Pick a Pit with STONES");
			return;
		}

		// System.out.println("--Player " + currentTurn + ".");
		if ((sc.getIndexInArray() < 6 && playerATurn == true)
				|| ((sc.getIndexInArray() > 6 && sc.getIndexInArray() < 13) && playerATurn == false)) {
			int controlNum = sc.getIndexInArray() + stonesPickedUp;

			sc.zeroStones();
			int currentIndex = sc.getIndexInArray() + 1; // starting point

			// this while loop helps adding stones
			while (currentIndex < sc.getIndexInArray() + 1 + stonesPickedUp) {

				stoneClusters.get(currentIndex % stoneClusters.size()).addOneStone();

				currentIndex++; // increment the index
			}

			/*
			 * takeALL()
			 */
			currentIndex -= 1;
			StoneCluster lastCluster = stoneClusters.get(currentIndex % 14);

			if (currentIndex % stoneClusters.size() < 6 && playerATurn == true) {
				stoneClusters.get(6).addNumberOfStones(takeAll(lastCluster));
			}

			if ((currentIndex % stoneClusters.size() < 13 && currentIndex % stoneClusters.size() > 6)
					&& playerATurn == false) {
				stoneClusters.get(13).addNumberOfStones(takeAll(lastCluster));
			}

			if ((controlNum % stoneClusters.size()) != 6 && (controlNum % stoneClusters.size()) != 13) {
				switchTurn();
				System.out.println("Turn has been changed");
			}
			
			//if(undoA==0 && aOrB>6 && aOrB<13  )
			if(aOrB>6 && aOrB<13)
			{
				undoA = 3;
			}
			if(aOrB < 6)
			{
				undoB = 3;
			}

			for (ChangeListener l : listeners) {
				l.stateChanged(new ChangeEvent(this));
			}
			
			/*
			 * if one side has 0 stone the other side receive all the stones in their side
			 * and announcement of winner will be printed
			 */
			if (isOver()) {
				System.out.println("Game Over");
				if (stoneClusters.get(6).getNumberOfStones() > stoneClusters.get(13).getNumberOfStones()) {
					System.out.println("Player A won! ");
					JOptionPane.showMessageDialog(null, "Player A won", "Game Alert: " + "Winner Announcment", JOptionPane.INFORMATION_MESSAGE);
				} else {
					System.out.println("Player B won! ");
					JOptionPane.showMessageDialog(null, "Player B won", "Game Alert: " + "Winner Announcment", JOptionPane.INFORMATION_MESSAGE);
				}
			}

		} else {
			System.out.println("It's not your turn");
			JOptionPane.showMessageDialog(null, "That's not your pit!","Game Alert", JOptionPane.INFORMATION_MESSAGE);
		}


	}

	// --------------------GETTERS AND SETTERS-------------------------------

	public int getStartingStones(){
		return this.startingStones;
	}

	public boolean getPlayerTurn(){
		return this.playerATurn;
	}
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