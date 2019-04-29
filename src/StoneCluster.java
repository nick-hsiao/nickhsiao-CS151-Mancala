import java.awt.geom.Ellipse2D;

public class StoneCluster extends GameShape{
	
	public StoneCluster(int x, int y, int width, int numberOfStones)
	{
		//Creates and adds a specified number of new circles to the GameShape - StoneCluster
		for(int i = 0; i < numberOfStones; i++)
		{
			Ellipse2D.Double stone = new Ellipse2D.Double(x + i*5, y + i*5, width, width);
			
			//add stone to the congregate (GameShape - StoneCluster)
			add(stone);
		}
	}

}
