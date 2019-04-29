
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * The Panel that holds a HoleShape(Pit or Mancala) which can be put onto a Jframe
 *
 */
public class ShapePanel extends JPanel{
	
	private GameShape hs;
	
	public ShapePanel(GameShape hs)
	{
		this.hs = hs;
		hs.addPanel(this);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		hs.draw(g2);
	}

}
