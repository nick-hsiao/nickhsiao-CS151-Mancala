
import java.awt.*;
import java.awt.geom.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Good class to add shapes into the mancala or pits..
 *
 */
public class GameShape{
	private Path2D.Double path;
	private JPanel panel;
	private JLabel label;
	
	public GameShape()
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
	
	public void addPanel(JPanel panel)
	{
		this.panel = panel;
	}
	
	public JPanel getPanel()
	{
		return panel;
	}
	
	public void addLabel(JLabel label)
	{
		this.label = label;
	}
	
	public JLabel getLabel()
	{
		return label;
	}
	
	public void reset()
	{
		path.reset();
	}

}
