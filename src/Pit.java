
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

/**
 * Defines the shape of the Pit
 * 
 * @author huerta, hsiao, pham
 *
 */
public class Pit extends GameShape{

	/**
	 * Constructor for Pit - adds the pit to the path
	 * 
	 */
	public Pit()
	{

		Ellipse2D.Double pit = new Ellipse2D.Double(5, 20, 100, 100*1.5);
		
		add(pit);
	}
	
	/**
	 * A method that can be called to return this Pit
	 * @return
	 */
	public Pit getPitShape()
	{
		return this;
	}
	
	
	

}
