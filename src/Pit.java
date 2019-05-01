
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

/**
 * Defines the shape of the Pit
 * Can include more in here, like the number of stones in the pit..
 *
 */
public class Pit extends GameShape{

	

	public Pit()
	{
//		this.pitID = pitID;
//		this.numberOfStones = numberOfStones;
		
		Ellipse2D.Double pit = new Ellipse2D.Double(5, 20, 100, 100*1.5);
		
		add(pit);
	}
	
	public Pit getPitShape()
	{
		return this;
	}
	
	
	

}
