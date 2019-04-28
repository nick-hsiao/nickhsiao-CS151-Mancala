
import java.awt.geom.Ellipse2D;

/**
 * Defines the shape of the Pit
 * Can include more in here, like the number of stones in the pit..
 *
 */
public class Pit extends HoleShape{

	public Pit(int x, int y, int width)
	{
		Ellipse2D.Double pit = new Ellipse2D.Double(x, y, width, width*1.5);
		
		add(pit);
	}
	
	public Pit getPitShape()
	{
		return this;
	}
	

}
