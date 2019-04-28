import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;



public class ViewController extends JComponent {

	private BoardShape currentBoard;
	private Pit pitt;
	public ViewController(BoardShape b,Pit pit) {
		// TODO Auto-generated constructor stub
		this.currentBoard = b;
		pitt = pit;
	}
	
	//overide
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		currentBoard.drawMancalaBoard(g2,pitt);
		pitt.drawLeftMancala(g2);
		pitt.drawRightMancala(g2);
		
//		int increment =120;
//		pitt.drawpit(g2, 0);
//		pitt.drawpit2(g2, 0);
//		pitt.drawpit(g2, increment);
//		pitt.drawpit2(g2, increment);
//		pitt.drawpit(g2, increment);
//		pitt.drawpit2(g2, increment);
//		pitt.drawpit(g2, increment);
//		pitt.drawpit2(g2, increment);
//		pitt.drawpit(g2, increment);
//		pitt.drawpit2(g2, increment);
//		pitt.drawpit(g2, increment);
//		pitt.drawpit2(g2, increment);
		
		
//		pitt.drawpit2(g2, 0);
//		pitt.drawpit2(g2, 0);
//		pitt.drawpit2(g2, 0);

		
		
		//next we draw Ellipses
		
	}
	

}
