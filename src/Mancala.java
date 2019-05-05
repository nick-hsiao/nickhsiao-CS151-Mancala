
import java.awt.geom.RoundRectangle2D;

/**
 * Defines the shape of the Mancala
 * 
 * @author huerta, hsiao, pham
 */
public class Mancala extends GameShape{
	
	/**
	 * constructor for mancala pit
	 * 
	 * @param x x value
	 * @param y y value
	 */
	public Mancala(int x, int y)
	{
		RoundRectangle2D.Double mancala = new RoundRectangle2D.Double(x, y, 100, 100*4, 600, 50);
		add(mancala);
	}
	
	/**
	 * getter method
	 * 
	 * @return this mancala object
	 */
	public Mancala getMancala()
	{
		return this;
	}

}
