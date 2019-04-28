
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

/**
 * Defines the shape of the Mancala
 *
 */
public class Mancala extends HoleShape{
	
	public Mancala(int x, int y, int width)
	{
		RoundRectangle2D.Double mancala = new RoundRectangle2D.Double(x, y, width, width*5, 100, 100);
		add(mancala);
	}

}
