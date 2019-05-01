import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;
import javax.swing.JLabel;

/**
 * JLabel that will hold an Icon, mainly an Icon of a StoneCluster
 * @author alehu
 *
 */
public class GameLabel extends JLabel{

	private GameShape gs;
	private Icon icon;
	
	public GameLabel(GameIcon icon, GameShape gs)
	{
		this.gs = gs;
		this.icon = icon;
		
		icon.addLabel(this);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2 = (Graphics2D)g;
		gs.draw(g2);
	}
	
}
