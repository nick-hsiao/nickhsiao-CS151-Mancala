import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;
import javax.swing.JLabel;

/**
 * Icon mainly for the StoneCluster class, to put on a JLabel
 */
public class GameIcon implements Icon{
	private GameShape gs;
	private JLabel label;
	
	public GameIcon(GameShape gs)
	{
		this.gs = gs;
	}

	@Override
	public int getIconHeight() {
		return 10;
	}

	@Override
	public int getIconWidth() {
		return 10;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D)g;
		gs.draw(g2);
	}
	
	public void addLabel(JLabel label)
	{
		this.label = label;
	}
	
}