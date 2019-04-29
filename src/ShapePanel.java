
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * The Panel that holds a HoleShape(Pit or Mancala) which can be put onto a Jframe
 *
 */
public class ShapePanel extends JPanel{
	
	private GameShape gs;
	
	public ShapePanel(GameShape gs)
	{
		this.gs = gs;
		//adds the GameShape to the JPanel, so it doesn't have to be done later
		gs.addPanel(this);
	}
	
	public void paintComponent(Graphics g)
	{
		//Paints the component based on how each GameShape defines itself to look
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		gs.draw(g2);
	}

}
