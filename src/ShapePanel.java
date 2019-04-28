import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * The Panel that holds a HoleShape(Pit or Mancala) which can be put onto a Jframe
 *
 */
public class ShapePanel extends JPanel{
	
	private PitShape cs;
	
	public ShapePanel(PitShape cs)
	{
		this.cs = cs;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		cs.draw(g2);
	}

}