import java.awt.*;
import java.util.ArrayList;

public class GameModel {
	private int numStones;
	private int gameStyle;
	private Player playerOne;
	private Player playerTwo;
	private ArrayList<Pit> pits = new ArrayList<Pit>();
	private ArrayList<ShapePanel> panels = new ArrayList<ShapePanel>();
	private Player currentPlayer;
	private boolean flag = false;
	private String currentTurn;

	public GameModel() {
		this.playerOne = new Player(true);
		this.playerTwo = new Player(false);
		this.currentPlayer = playerOne;
		currentTurn = "B";
		// for(int i=0)
	}

	public void switchTurn() {
		if (currentTurn.equals("A")) {
			currentTurn = "B";
		} else {
			currentTurn = "A";
		}
	}

	public ArrayList<Pit> getPits() {
		return pits;
	}

	public void setnumStones(int n) {
		this.numStones = n;
	}

	public void setgameStyle(int n) {
		this.gameStyle = n;
		// System.out.println(this.gameStyle);
	}

	public void addPanel(ShapePanel s) {
		this.panels.add(0, s);
	}

	public void addPit(Pit p) {
		this.pits.add(p);
	}

	public void addPitIndex(int i, Pit p) {
		this.pits.add(i, p);
	}

	public int getnumStones() {
		return this.numStones;
	}

	public int getgameStyle() {
		return this.gameStyle;
	}

	public Player getPlayerOne() {
		return playerOne;
	}

	public Player getPlayerTwo() {
		return playerTwo;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	// i is the pit they clicked corresponding
	public void takeTurn(int i) {
		int count = i;
		boolean boo = false;
		
		System.out.println(i + "--Player " + currentTurn + ".");
		if ((i < 7 && currentTurn.equals("B")) || ((i < 14 && i > 7) && currentTurn.equals("A"))) {
			int holdStones = pits.get(i).getPieces(); // pick up number of stone

			//System.out.println(x);
			if ((i + holdStones) != 7 && (i + holdStones) != 14) {
				switchTurn();
				System.out.println("Turn has been changed");
			}

			pits.get(i).setPieces(0);// set picked place to 0
			// keep place 1 more stone to the next pits once each
			while (holdStones != 0 && count < pits.size() - 1) {
				count += 1;
				pits.get(count).setPieces(pits.get(count).getPieces() + 1);
				holdStones -= 1;
			}

			// if it met the pit 14,skip the loop and start to put stone from 0(Mancala
			// left)
			count = -1;
			while (holdStones != 0) {
				count += 1;
				pits.get(count).setPieces(pits.get(count).getPieces() + 1);
				holdStones -= 1;
			}

			// Printing to check values
			for (int a = 0; a < pits.size(); a++) {
				System.out.println("Pit " + a + " " + pits.get(a).getPieces());
			}
			boo = true;
		}else {
			System.out.println("It's not your turn");
			
		}

		
		// panels.get(i).repaint();
		for (int k = 0; k < panels.size(); k++) {
			panels.get(k).repaint();
		}

		/*
		 * If the final stone place in mancala A, player A can continue to have their
		 * turn
		 */
		// System.out.println("Keep i: "+ i);
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}