import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

public class ViewController extends JComponent {
	private static final long serialVersionUID = 1L;
	private BoardShape currentBoard;
	private Pit pitt;
	private Point mousePoint;
	private static final int NUMBERS_OF_PLAYERS = 2;
	private static final int PITS_EACH_SIDE = 12;

	public ViewController(BoardShape b, Pit pit) {
		// TODO Auto-generated constructor stub
		this.currentBoard = b;
		pitt = pit;
		// elps = currentBoard.getListPits();
		MouseListeners listeners = new MouseListeners();
		addMouseListener(listeners);
	}

	// overide
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		currentBoard.drawMancalaBoard(g2, pitt);
		pitt.drawLeftMancala(g2);
		pitt.drawRightMancala(g2);

	}

	private class MouseListeners extends MouseAdapter {
		public void mouseClicked(MouseEvent event) {
			mousePoint = event.getPoint();
			System.out.println("X-coordinate: " + mousePoint.getX());
			System.out.println("Y-coordinate: " + mousePoint.getY());
			for (int i = 0; i < NUMBERS_OF_PLAYERS; i++) {
				for (int j = 0; j < PITS_EACH_SIDE / 2; j++) {
					if (currentBoard.getListPits()[i][j].contains(mousePoint.getX(), mousePoint.getY())) {
						System.out.println("Specific ellipse: " + i + " " + j);
					}
				} // end inner Loop
			} // end outter loop
		}
	}// end MouseListener class
}
