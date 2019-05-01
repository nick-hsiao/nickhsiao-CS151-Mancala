
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MancalaBoardTest{
	
	/**
	 * a run through of creating the board...
	 * This should eventually be some kind of method to generate the board so that it isn't in a main method.
	 * @param args
	 */
	public static void main(String[] args)
	{
		final GameModel model = new GameModel();
		
//-------------------SETTING UP THE SHAPES(PITS,MANCALA,CLUSTERS)-------------------------------------------		
		//THINGS ARENT REALLY IN THE RIGHT PLACE RIGHT NOW
		//Mancalas
		Mancala mancalaA = new Mancala(0,20,100);
		final ShapePanel jMancalaA = new ShapePanel(mancalaA);
		jMancalaA.setPreferredSize(new Dimension(120,100));
		
		Mancala mancalaB = new Mancala(10,20,100);
		final ShapePanel jMancalaB = new ShapePanel(mancalaB);
		jMancalaB.setPreferredSize(new Dimension(120,100));
		
		
		//ASide
		Pit pitA1 = new Pit();									//Create Pit
		final ShapePanel jPitA1 = new ShapePanel(pitA1);		//Make a JPanel of the Pit
		jPitA1.setLayout(new BorderLayout());					//Set the Pits layout to BorderLayout
		StoneCluster stonesA1 = new StoneCluster(4);			//Create StoneCluster
		GameIcon iconStonesA1 = new GameIcon(stonesA1);			//Create GameIcon and add the StoneCluster
		final GameLabel jStonesA1 = new GameLabel(iconStonesA1, stonesA1);		//Create JLabel and add the GameIcon
		jPitA1.add(BorderLayout.CENTER, jStonesA1);
		
		Pit pitA2 = new Pit();
		final ShapePanel jPitA2 = new ShapePanel(pitA2);
		jPitA2.setLayout(new BorderLayout());					
		StoneCluster stonesA2 = new StoneCluster(4);			
		GameIcon iconStonesA2 = new GameIcon(stonesA2);	
		final GameLabel jStonesA2 = new GameLabel(iconStonesA2, stonesA2);
		jPitA2.add(BorderLayout.CENTER, jStonesA2);

		Pit pitA3 = new Pit();
		final ShapePanel jPitA3 = new ShapePanel(pitA3);
		jPitA3.setLayout(new BorderLayout());					
		StoneCluster stonesA3 = new StoneCluster(4);			
		GameIcon iconStonesA3 = new GameIcon(stonesA3);	
		final GameLabel jStonesA3 = new GameLabel(iconStonesA3, stonesA3);
		jPitA3.add(BorderLayout.CENTER, jStonesA3);
		
		Pit pitA4 = new Pit();
		final ShapePanel jPitA4 = new ShapePanel(pitA4);
		jPitA4.setLayout(new BorderLayout());					
		StoneCluster stonesA4 = new StoneCluster(4);			
		GameIcon iconStonesA4 = new GameIcon(stonesA4);	
		final GameLabel jStonesA4 = new GameLabel(iconStonesA4, stonesA4);
		jPitA4.add(BorderLayout.CENTER, jStonesA4);
		
		Pit pitA5 = new Pit();
		final ShapePanel jPitA5 = new ShapePanel(pitA5);
		jPitA5.setLayout(new BorderLayout());					
		StoneCluster stonesA5 = new StoneCluster(4);			
		GameIcon iconStonesA5 = new GameIcon(stonesA5);	
		final GameLabel jStonesA5 = new GameLabel(iconStonesA5, stonesA5);
		jPitA5.add(BorderLayout.CENTER, jStonesA5);
		
		Pit pitA6 = new Pit();
		final ShapePanel jPitA6 = new ShapePanel(pitA6);
		jPitA6.setLayout(new BorderLayout());					
		StoneCluster stonesA6 = new StoneCluster(4);			
		GameIcon iconStonesA6 = new GameIcon(stonesA6);	
		final GameLabel jStonesA6 = new GameLabel(iconStonesA6, stonesA6);
		jPitA6.add(BorderLayout.CENTER, jStonesA6);
	
		
		//BSide
		Pit pitB1 = new Pit();									//Create Pit
		final ShapePanel jPitB1 = new ShapePanel(pitB1);		//Make a JPanel of the Pit
		jPitB1.setLayout(new BorderLayout());					//Set the Pits layout to BorderLayout
		StoneCluster stonesB1 = new StoneCluster(4);			//Create StoneCluster
		GameIcon iconStonesB1 = new GameIcon(stonesB1);			//Create GameIcon and add the StoneCluster
		final GameLabel jStonesB1 = new GameLabel(iconStonesB1, stonesB1);		//Create JLabel and add the GameIcon
		jPitB1.add(BorderLayout.CENTER, jStonesB1);
		
		Pit pitB2 = new Pit();
		final ShapePanel jPitB2 = new ShapePanel(pitB2);
		jPitB2.setLayout(new BorderLayout());					
		StoneCluster stonesB2 = new StoneCluster(4);			
		GameIcon iconStonesB2 = new GameIcon(stonesB2);	
		final GameLabel jStonesB2 = new GameLabel(iconStonesB2, stonesB2);
		jPitB2.add(BorderLayout.CENTER, jStonesB2);

		Pit pitB3 = new Pit();
		final ShapePanel jPitB3 = new ShapePanel(pitB3);
		jPitB3.setLayout(new BorderLayout());					
		StoneCluster stonesB3 = new StoneCluster(4);			
		GameIcon iconStonesB3 = new GameIcon(stonesB3);	
		final GameLabel jStonesB3 = new GameLabel(iconStonesB3, stonesB3);
		jPitB3.add(BorderLayout.CENTER, jStonesB3);
		
		Pit pitB4 = new Pit();
		final ShapePanel jPitB4 = new ShapePanel(pitB4);
		jPitB4.setLayout(new BorderLayout());					
		StoneCluster stonesB4 = new StoneCluster(4);			
		GameIcon iconStonesB4 = new GameIcon(stonesB4);	
		final GameLabel jStonesB4 = new GameLabel(iconStonesB4, stonesB4);
		jPitB4.add(BorderLayout.CENTER, jStonesB4);
		
		Pit pitB5 = new Pit();
		final ShapePanel jPitB5 = new ShapePanel(pitB5);
		jPitB5.setLayout(new BorderLayout());					
		StoneCluster stonesB5 = new StoneCluster(4);			
		GameIcon iconStonesB5 = new GameIcon(stonesB5);	
		final GameLabel jStonesB5 = new GameLabel(iconStonesB5, stonesB5);
		jPitB5.add(BorderLayout.CENTER, jStonesB5);
		
		Pit pitB6 = new Pit();
		final ShapePanel jPitB6 = new ShapePanel(pitB6);
		jPitB6.setLayout(new BorderLayout());					
		StoneCluster stonesB6 = new StoneCluster(4);			
		GameIcon iconStonesB6 = new GameIcon(stonesB6);	
		final GameLabel jStonesB6 = new GameLabel(iconStonesB6, stonesB6);
		jPitB6.add(BorderLayout.CENTER, jStonesB6);		
//------------FINISH SETTING UP-----------------------------------------------
		
//----------ADD CHANGE LISTENERS (UPDATE VIEW)---------------------------------------------		
		ChangeListener changeListener = new
				ChangeListener()
				{
					public void stateChanged(ChangeEvent event)
					{
						//update/redraw the number of stones in a pit (Stone Clusters?)
						//clear();
						//redraw stone clusters based on the variable in each StoneCluster
						
					}
			
				};
				
//-------------FINISH CHANGE LISTENERS--------------------------------------
				
//---------------ADD MOUSE LISTENERS (CONTROLLER)------------------------------				
		
		//jstones instead of pit
		jStonesA1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				System.out.println("pitA1");
				
				//can do something like this to get the pit
				//to then pass it into a method as a parameter.
				Pit pit = pitA1.getPitShape();
				//stonesA1.add(new Ellipse2D.Double(10, 10, 20, 20));
				
				System.out.println(stonesA1.getNumberOfStones());
				stonesA1.addNumberOfStones(4);
				System.out.println(stonesA1.getNumberOfStones());
				jStonesA1.repaint();
				//example of adding a new shape(stone) to the pit
				//can be implemented differently

				

			}
		});
		jPitA2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				System.out.println("pitA2");
				stonesA1.zeroStones();
				System.out.println(stonesA1.getNumberOfStones());
				jStonesA1.repaint();
			}
		});
		jPitA3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				System.out.println("pitA3");
			}
		});
		jPitA4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				System.out.println("pitA4");
			}
		});
		jPitA5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				System.out.println("pitA5");
			}
		});
		jPitA6.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				System.out.println("pitA6");
			}
		});
		jPitB1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				System.out.println("pitB1");

			}
		});
		jPitB2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				System.out.println("pitB2");
			}
		});
		jPitB3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				System.out.println("pitB3");
			}
		});
		jPitB4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				System.out.println("pitB4");
			}
		});
		jPitB5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				System.out.println("pitB5");
			}
		});
		jPitB6.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				System.out.println("pitB6");
			}
		});
//-------------FINISH ADDING MOUSE LISTENERS---------------------------		

//----------PUT EVERYTHING ONTO THE FRAME-------------------------------
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.setPreferredSize(new Dimension(950, 480));
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(2,6));

		
		
		center.add(jPitB6);
		center.add(jPitB5);
		center.add(jPitB4);
		center.add(jPitB3);
		center.add(jPitB2);
		center.add(jPitB1);
		
		center.add(jPitA1);
		center.add(jPitA2);
		center.add(jPitA3);
		center.add(jPitA4);
		center.add(jPitA5);
		center.add(jPitA6);
		
		
		frame.add(BorderLayout.CENTER, center);
		frame.add(BorderLayout.WEST, jMancalaB);
		frame.add(BorderLayout.EAST, jMancalaA);
		
		
		
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		
		
	}

}
