
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MancalaBoardTest{
	
	/**
	 * a run through of creating the board...
	 * This should eventually be some kind of method to generate the board so that it isn't in a main method.
	 * @param args
	 */
	public static void main(String[] args)
	{
		//THINGS ARENT REALLY IN THE RIGHT PLACE RIGHT NOW
		
		//ASide
		Pit pitA1 = new Pit(0,0,30);
		final ShapePanel jPitA1 = new ShapePanel(pitA1);
		Pit pitA2 = new Pit(0,0,30);
		final ShapePanel jPitA2 = new ShapePanel(pitA2);
		Pit pitA3 = new Pit(0,0,30);
		final ShapePanel jPitA3 = new ShapePanel(pitA3);
		Pit pitA4 = new Pit(0,0,30);
		final ShapePanel jPitA4 = new ShapePanel(pitA4);
		Pit pitA5 = new Pit(0,0,30);
		final ShapePanel jPitA5 = new ShapePanel(pitA5);
		Pit pitA6 = new Pit(0,0,30);
		final ShapePanel jPitA6 = new ShapePanel(pitA6);
		//BSide
		Pit pitB1 = new Pit(0,0,30);
		final ShapePanel jPitB1 = new ShapePanel(pitB1);
		Pit pitB2 = new Pit(0,0,30);
		final ShapePanel jPitB2 = new ShapePanel(pitB2);
		Pit pitB3 = new Pit(0,0,30);
		final ShapePanel jPitB3 = new ShapePanel(pitB3);
		Pit pitB4 = new Pit(0,0,30);
		final ShapePanel jPitB4 = new ShapePanel(pitB4);
		Pit pitB5 = new Pit(0,0,30);
		final ShapePanel jPitB5 = new ShapePanel(pitB5);
		Pit pitB6 = new Pit(0,0,30);
		final ShapePanel jPitB6 = new ShapePanel(pitB6);

		
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
		frame.setPreferredSize(new Dimension(250, 150));
		frame.setLayout(new GridLayout(2,0));
		frame.add(jPitA1);
		frame.add(jPitA2);
		frame.add(jPitA3);
		frame.add(jPitA4);
		frame.add(jPitA5);
		frame.add(jPitA6);
		frame.add(jPitB1);
		frame.add(jPitB2);
		frame.add(jPitB3);
		frame.add(jPitB4);
		frame.add(jPitB5);
		frame.add(jPitB6);
		
		
		
		
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		
		
	}

}
