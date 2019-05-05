
import java.awt.*;
import java.awt.geom.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * GameShape is a congregate that can hold many shapes
 * 
 * @author huerta, hsiao, pham
 */
public class GameShape{
	private Path2D.Double path;
	private JPanel panel;
	private JLabel label;
	
	/**
	 * Constructor for a GameShape
	 */
	public GameShape()
	{
		path = new Path2D.Double();
	}
	
	/**
	 * Appends a shape to the path
	 * @param s - shape to be added
	 */
	protected void add(Shape s)
	{
		path.append(s, false);
	}
	
	/**
	 * Check if a point is contained in the path
	 * @param aPoint - point to be checked
	 * @return - true if path contains the point.
	 */
	public boolean contains(Point2D aPoint)
	{
		return path.contains(aPoint);
	}
	
	/**
	 * Draws the shapes in the path 
	 * @param g2
	 */
	public void draw(Graphics2D g2)
	{
		g2.draw(path);
	}
	
	/**
	 * Used to add a JPanel reference
	 * @param panel - panel to be added
	 */
	public void addPanel(JPanel panel)
	{
		this.panel = panel;
	}
	
	/**
	 * Gets the JPanel
	 * @return - returns the JPanel
	 */
	public JPanel getPanel()
	{
		return panel;
	}
	
	/**
	 * Adds a JLabel
	 * @param label - the JLabel to add
	 */
	public void addLabel(JLabel label)
	{
		this.label = label;
	}
	
	/**
	 * Gets the JLabel
	 * @return - returns the JLabel
	 */
	public JLabel getLabel()
	{
		return label;
	}
	
	/**
	 * Removes all shapes in the path
	 */
	public void reset()
	{
		path.reset();
	}

}
