
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
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
		//reference to the model
		final GameModel model = new GameModel();
		
		//creating the JFrame for everything to be put on
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.setPreferredSize(new Dimension(950, 500));
		
		//the JPanel in the center that holds the middle pits in GridLayout
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(2,6));
		
//----------------Setting up the BSide Pits and its StoneClusters--------------------------------
		//BSide goes in indexes starting 7 to 12
		for(int i = 12; i >= 7; i--)
		{
			Pit pit = new Pit();
			final ShapePanel jPit = new ShapePanel(pit);
			jPit.setLayout(new BorderLayout());
			StoneCluster stones = new StoneCluster(4, i); //starting number of stones and index in array
			GameIcon iconStones = new GameIcon(stones);
			final GameLabel jStones = new GameLabel(iconStones, stones);
			jPit.add(BorderLayout.CENTER, jStones);
			//Add Mouse Listener
			jStones.addMouseListener(new MouseAdapter() 
			{
				public void mouseClicked(MouseEvent e)
				{
					System.out.println("pitB" + (stones.getIndexInArray()%7 + 1) + " @index: " + stones.getIndexInArray());
					System.out.println(stones.getNumberOfStones());
					model.pickUpStones(stones);
					System.out.println(stones.getNumberOfStones());

				}
			});
			//add to model ArrayList
			model.addStoneCluster(stones, stones.getIndexInArray());
			//add JPanel Pit to the grid
			center.add(jPit);
			
		}
//---------------------------------------------------------------------------------------------
//-----------Setting up Mancala B and its StoneClusters--------------------------------------
		
		//Mancala B goes after BSide
		Mancala mancalaB = new Mancala(10,20);
		final ShapePanel jMancalaB = new ShapePanel(mancalaB);
		jMancalaB.setPreferredSize(new Dimension(120,100));
		jMancalaB.setLayout(new BorderLayout());
		StoneCluster stonesManB = new StoneCluster(0, 13);		//Mancala starts empty
		GameIcon iconStonesManB = new GameIcon(stonesManB);
		final GameLabel jStonesManB = new GameLabel(iconStonesManB, stonesManB);
		jMancalaB.add(BorderLayout.CENTER, jStonesManB);
		//Add Mouse Listener
		jMancalaB.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e)
			{
				System.out.println("Mancala B @index " + stonesManB.getIndexInArray());
	
			}
		});
		//add to model ArrayList
		model.addStoneCluster(stonesManB, stonesManB.getIndexInArray());
		
//-------------------------------------------------------------------------------------------------		
//----------------Setting up the ASide Pits and its StoneClusters------------------------------		
		//ASide goes in first starting from 0 to 5
		for(int i = 0; i <= 5; i++)
		{
			Pit pit = new Pit();
			final ShapePanel jPit = new ShapePanel(pit);
			jPit.setLayout(new BorderLayout());
			StoneCluster stones = new StoneCluster(4, i); //starting number of stones and index in array
			GameIcon iconStones = new GameIcon(stones);
			final GameLabel jStones = new GameLabel(iconStones, stones);
			jPit.add(BorderLayout.CENTER, jStones);
			//Add mouse Listener
			jStones.addMouseListener(new MouseAdapter() 
			{
				public void mouseClicked(MouseEvent e)
				{
					System.out.println("pitA" + (stones.getIndexInArray() + 1) + " @index: " + stones.getIndexInArray());
					System.out.println(stones.getNumberOfStones());
					model.pickUpStones(stones);
					System.out.println(stones.getNumberOfStones());

				}
			});
			//add to model ArrayList
			model.addStoneCluster(stones, stones.getIndexInArray());
			//add JPanel Pit to the grid
			center.add(jPit);
		}
//------------------------------------------------------------------------------------------------
//-----------Setting up Mancala A and its StoneClusters--------------------------------------
		//Mancala A goes in after ASide
		Mancala mancalaA = new Mancala(0,20);
		final ShapePanel jMancalaA = new ShapePanel(mancalaA);
		jMancalaA.setPreferredSize(new Dimension(120,100));
		jMancalaA.setLayout(new BorderLayout());
		StoneCluster stonesManA = new StoneCluster(0, 6);		//Mancala starts empty
		GameIcon iconStonesManA = new GameIcon(stonesManA);
		final GameLabel jStonesManA = new GameLabel(iconStonesManA, stonesManA);
		jMancalaA.add(BorderLayout.CENTER, jStonesManA);
		//Add mouse listener
		jMancalaA.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e)
			{
				System.out.println("Mancala A @index " + stonesManA.getIndexInArray());
			}
		});
		//add to model ArrayList
		model.addStoneCluster(stonesManA, stonesManA.getIndexInArray());	
	
//------------FINISH SETTING UP-----------------------------------------------
		
		ArrayList<StoneCluster> sc = model.getStoneClusters();
		
//----------ADD CHANGE LISTENERS (UPDATE VIEW)----------------------------------	
		
		ChangeListener cListener = new
				ChangeListener()
				{
					public void stateChanged(ChangeEvent event)
					{
						for(StoneCluster sc: model.getStoneClusters())
						{
							int numOfStones = sc.getNumberOfStones();
							sc.zeroStones();
							sc.addNumberOfStones(numOfStones);
							sc.getLabel().repaint();
						}
					}
				};
				
		model.attach(cListener);
				
//-------------FINISH CHANGE LISTENERS--------------------------------------
					
//----------PUT EVERYTHING ONTO THE FRAME-------------------------------

		//adding GameShapes(Pits,Mancalas) to the frame
		frame.add(BorderLayout.CENTER, center);
		frame.add(BorderLayout.WEST, jMancalaB);
		frame.add(BorderLayout.EAST, jMancalaA);
		
		//Buttons on top
		JPanel buttonPanel = new JPanel();
		JButton exit = new JButton("Exit");
		JButton undo = new JButton("Undo");
		buttonPanel.add(exit);
		buttonPanel.add(undo);
		frame.add(BorderLayout.NORTH, buttonPanel);
		
		
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		
		
	}

}
