import java.awt.*;
import java.awt.geom.*;

/**
 * Good class to add shapes into the mancala or pits..
 *
 */
public class PitShape{
	private Path2D.Double path;
	
	public PitShape()
	{
		path = new Path2D.Double();
	}
	
	protected void add(Shape s)
	{ 
        path.append(s, false);
        
	}
	
	public boolean contains(Point2D aPoint)
	{
		return path.contains(aPoint);
	}
	
	public void draw(Graphics2D g2)
	{
		g2.draw(path);
	}

}