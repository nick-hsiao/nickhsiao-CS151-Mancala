import java.awt.*;

import javax.swing.*;

public class BoardView 
{
	
	
		public static void main(String[] args)
		{
			//frame
			JFrame frame = new JFrame("Mancala");
			//set layout for frame
			frame.setLayout(new BorderLayout());
			
			
			//top panel & buttons
			JPanel options = new JPanel();
			JButton restart = new JButton("Restart");
			JButton exit = new JButton("Exit");
			//add buttons to panel
			options.add(restart);
			options.add(exit);
			
			
			//middle panel & PitComponents
			JPanel board = new JPanel();
			board.setLayout(new GridLayout(2,0, 10, 20));
			//add PitComponents to board(in grid layout)
			for(int i = 0; i < 12; i++)
			{
				board.add(new PitComponent(new Pit(4)));
			}
			
			//left panel
			JPanel leftMancala = new JPanel();
			leftMancala.setLayout(new GridLayout(2,0, 10, 20));
			//add mancala
			leftMancala.add(new PitComponent(new Pit(4)));
			
			//right panel
			JPanel rightMancala = new JPanel();
			//add mancala
			rightMancala.add(new PitComponent(new Pit(4)));
			
			
			
			
			
			
			//bottom panel
			
			
			//add Panels to frame
			frame.add(BorderLayout.NORTH, options);
			frame.add(BorderLayout.CENTER, board);
			frame.add(BorderLayout.WEST, leftMancala);
			frame.add(BorderLayout.EAST, rightMancala);
			
			
			
			
			
			
			
			
			
			//default stuff
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.setVisible(true);
		}

}
