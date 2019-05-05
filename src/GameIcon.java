import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;
import javax.swing.JLabel;

/**
 * @author huerta, hsiao, pham
 * Icon mainly for the StoneCluster class, to put on a JLabel
 */
public class GameIcon implements Icon{
	private GameShape gs;
	
	/**
	 * Constructs an object of a GameIcon
	 * @param gs - the GameShape to be held by the GameIcon
	 */
	public GameIcon(GameShape gs)
	{
		this.gs = gs;
	}

	/**
	 * Returns the height of the Icon
	 * @return 10 - a default value
	 */
	public int getIconHeight() {
		return 10;
	}

	/**
	 * Returns the width of the Icon
	 * @return 10 - a default value
	 */
	public int getIconWidth() {
		return 10;
	}


	/**
	 * Paints the icon by delegating draw to the GameShape
	 */
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D)g;
		gs.draw(g2);
	}
		
}