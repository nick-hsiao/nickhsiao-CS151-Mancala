
import java.awt.BorderLayout;
import java.awt.Dimension;
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
		
		
		//THINGS ARENT REALLY IN THE RIGHT PLACE RIGHT NOW
		//Mancalas
		Mancala mancalaA = new Mancala(0,20,100);
		final ShapePanel jMancalaA = new ShapePanel(mancalaA);
		jMancalaA.setPreferredSize(new Dimension(120,100));
		
		Mancala mancalaB = new Mancala(10,20,100);
		final ShapePanel jMancalaB = new ShapePanel(mancalaB);
		jMancalaB.setPreferredSize(new Dimension(120,100));
		
		
		//ASide
		Pit pitA1 = new Pit(5, 20,100);							//Create Pit
		final ShapePanel jPitA1 = new ShapePanel(pitA1);		//Make a JPanel of the Pit
		jPitA1.setLayout(new BorderLayout());					//Set the Pits layout to BorderLayout
		StoneCluster stonesA1 = new StoneCluster(-10,0,10,4);	//Create StoneCluster
		final JLabel jStonesA1 = new JLabel("HILOWEJROJ");	//Make a JPanel of the StoneCluster
		jPitA1.add(BorderLayout.CENTER, jStonesA1);
		
		Pit pitA2 = new Pit(5,20,100);
		final ShapePanel jPitA2 = new ShapePanel(pitA2);
		
		Pit pitA3 = new Pit(5,20,100);
		final ShapePanel jPitA3 = new ShapePanel(pitA3);
		
		Pit pitA4 = new Pit(5,20,100);
		final ShapePanel jPitA4 = new ShapePanel(pitA4);
		
		Pit pitA5 = new Pit(5,20,100);
		final ShapePanel jPitA5 = new ShapePanel(pitA5);
		
		Pit pitA6 = new Pit(5,20,100);
		final ShapePanel jPitA6 = new ShapePanel(pitA6);
		
		//BSide
		Pit pitB1 = new Pit(0,0,100);
		final ShapePanel jPitB1 = new ShapePanel(pitB1);
		
		Pit pitB2 = new Pit(0,0,100);
		final ShapePanel jPitB2 = new ShapePanel(pitB2);
		
		Pit pitB3 = new Pit(0,0,100);
		final ShapePanel jPitB3 = new ShapePanel(pitB3);
		
		Pit pitB4 = new Pit(0,0,100);
		final ShapePanel jPitB4 = new ShapePanel(pitB4);
		
		Pit pitB5 = new Pit(0,0,100);
		final ShapePanel jPitB5 = new ShapePanel(pitB5);
		
		Pit pitB6 = new Pit(0,0,100);
		final ShapePanel jPitB6 = new ShapePanel(pitB6);

		
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
		
		
		
		
		jPitA1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				System.out.println("pitA1");
				
				//can do something like this to get the pit
				//to then pass it into a method as a parameter.
				Pit pit = pitA1.getPitShape();
				System.out.println(pit);
				
				
				//example of adding a new shape(stone) to the pit
				//can be implemented differently
				pitA1.add(new Ellipse2D.Double(5,5,5,5));
				jPitA1.repaint();
				

			}
		});
		jPitA2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				System.out.println("pitA2");
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
		
		
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.setPreferredSize(new Dimension(950, 480));
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(2,0));
		center.add(jPitA1);
		center.add(jPitA2);
		center.add(jPitA3);
		center.add(jPitA4);
		center.add(jPitA5);
		center.add(jPitA6);
		center.add(jPitB1);
		center.add(jPitB2);
		center.add(jPitB3);
		center.add(jPitB4);
		center.add(jPitB5);
		center.add(jPitB6);
		
		
		frame.add(BorderLayout.CENTER, center);
		frame.add(BorderLayout.WEST, jMancalaB);
		frame.add(BorderLayout.EAST, jMancalaA);
		
		
		
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		
		
	}

}
