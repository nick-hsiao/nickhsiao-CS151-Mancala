import java.awt.*;

import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author alehu
 *
 */
public class PitComponent extends JPanel
{
	private Pit pit;
	
	public PitComponent(Pit pit)
	{
		this.pit = pit;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		pit.draw(g2);
	}
	
}