import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;

/**
 * To Show the stones over the top of the pit
 */
public class GameIcon implements Icon{
	private GameShape gs;
	private int width;
	
	public GameIcon(GameShape gs, int width)
	{
		this.gs = gs;
		this.width = width;
	}

	@Override
	public int getIconHeight() {
		return width;
	}

	@Override
	public int getIconWidth() {
		return width;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D)g;
		gs.draw(g2);
	}
}