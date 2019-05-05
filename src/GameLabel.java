import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;
import javax.swing.JLabel;

/**
 * GameLabel is a JLabel that will hold an Icon, mainly an Icon of a StoneCluster
 * 
 * @author huerta, hsiao, pham
 *
 */
public class GameLabel extends JLabel{

	private GameShape gs;
	private Icon icon;
	
	/**
	 * Constructor for a GameLabel
	 * @param icon - the icon held in the GameIcon(StoneCluster)
	 * @param gs - a reference to the GameShape(Pit)
	 */
	public GameLabel(GameIcon icon, GameShape gs)
	{
		this.gs = gs;
		gs.addLabel(this);
		
		this.icon = icon;
	}
	
	/**
	 * Paints the icon by delegating draw to the GameShape
	 */
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2 = (Graphics2D)g;
		gs.draw(g2);
	}
	
}
