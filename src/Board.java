import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**
 * board class serves as view and controller
 * 
 * @author hsiao,huerta,pham
 */
public class Board {

	/**
	 * constructor with two params, theme and number of starting stones
	 * 
	 * @param theme board theme chosen by user at main menu
	 * @param s number of starting stones chosen by user at main menu
	 */
	public Board(BoardStyle theme, int s) {

		//create game model passing in starting number of stones
		final GameModel model = new GameModel(s);

		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.setPreferredSize(new Dimension(960, 500));

		// the JPanel in the center that holds the main pits using GridLayout
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(2, 6));

		// ----------------Setting up the Player B pits and its StoneClusters--------------------------------
		// B pits will be placed in model using indices 12 to 7
		for (int i = 12; i >= 7; i--) {
			Pit pit = new Pit();
			final ShapePanel jPit = new ShapePanel(pit);

			//get color from theme
			jPit.setBackground(theme.getColor());
			jPit.setLayout(new BorderLayout());

			//create stone cluster, passing in number of starting stones, index, boolean indicating which player the pit belongs to
			StoneCluster stones = new StoneCluster(model.getStartingStones(), i, false); 
			GameIcon iconStones = new GameIcon(stones);
			final GameLabel jStones = new GameLabel(iconStones, stones);
		
			//add the stone cluster to the pit component and respective label (ex. "A1")
			jPit.add(BorderLayout.CENTER, jStones);
			jPit.add(BorderLayout.NORTH, new JLabel("B" + (stones.getIndexInArray() % 7 + 1)));
			
			//add mouse listener to each pit for player to "take a turn" 
			jStones.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					System.out.println(
							"pitB" + (stones.getIndexInArray() % 7 + 1) + " @index: " + stones.getIndexInArray());
					System.out.println("Stones before click: " + stones.getNumberOfStones());
					model.pickUpStones(stones);
					System.out.println("Stones after click: " + stones.getNumberOfStones());

				}
			});
			// add to stone cluster to model array
			model.addStoneCluster(stones, stones.getIndexInArray());
			// add pit panel to the grid
			center.add(jPit);

		}
		// -------------Setting up Mancala B and its StoneCluster-------------------------------------
		Mancala mancalaB = new Mancala(10, 20);
		final ShapePanel jMancalaB = new ShapePanel(mancalaB);

		//get background color from theme
		jMancalaB.setBackground(theme.getColor());

		jMancalaB.setPreferredSize(new Dimension(120, 100));
		jMancalaB.setLayout(new BorderLayout());
		//mancala B begins empty and goes into index 13 in the model array, false indicates the mancala belongs to player B
		StoneCluster stonesManB = new StoneCluster(0, 13, false); 
		GameIcon iconStonesManB = new GameIcon(stonesManB);
		final GameLabel jStonesManB = new GameLabel(iconStonesManB, stonesManB);
		jMancalaB.add(BorderLayout.CENTER, jStonesManB);
		jMancalaB.add(BorderLayout.NORTH, new JLabel("Player B Mancala"));
		//testing mancala pit
		jMancalaB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("Mancala B @index " + stonesManB.getIndexInArray());
				System.out.println("Stones: " + stonesManB.getNumberOfStones());

			}
		});
		// add to model ArrayList
		model.addStoneCluster(stonesManB, stonesManB.getIndexInArray());

		// ----------------Setting up the Player A Pits and its StoneClusters------------------------------
		// A pits will be placed into the model array using index 0-5
		for (int i = 0; i <= 5; i++) {
			Pit pit = new Pit();
			final ShapePanel jPit = new ShapePanel(pit);

			jPit.setBackground(theme.getColor());

			jPit.setLayout(new BorderLayout());
			//create stone cluster for A pits using starting stones, index and boolean indicataing these pits belong to player A
			StoneCluster stones = new StoneCluster(model.getStartingStones(), i, true); 
			GameIcon iconStones = new GameIcon(stones);
			final GameLabel jStones = new GameLabel(iconStones, stones);
			jPit.add(BorderLayout.CENTER, jStones);
			jPit.add(BorderLayout.NORTH, new JLabel("A" + (stones.getIndexInArray() + 1)));
			//add mouse listener to each pit for player to "take a turn"
			jStones.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					System.out
							.println("pitA" + (stones.getIndexInArray() + 1) + " @index: " + stones.getIndexInArray());
					System.out.println("Stones before click: " + stones.getNumberOfStones());
					model.pickUpStones(stones);
					System.out.println("Stones after click: " + stones.getNumberOfStones());

				}
			});
			// add to model ArrayList
			model.addStoneCluster(stones, stones.getIndexInArray());
			// add JPanel Pit to the grid
			center.add(jPit);
		}
		
		// -----------Setting up Mancala A and its stone clusters--------------------------------------
		Mancala mancalaA = new Mancala(10, 20);
		final ShapePanel jMancalaA = new ShapePanel(mancalaA);

		//get background color from theme
		jMancalaA.setBackground(theme.getColor());

		jMancalaA.setPreferredSize(new Dimension(120, 100));
		jMancalaA.setLayout(new BorderLayout());
		//mancala A begins empty and goes into index 6 in the model array, true indicates the mancala belongs to player A
		StoneCluster stonesManA = new StoneCluster(0, 6, true);
		GameIcon iconStonesManA = new GameIcon(stonesManA);
		final GameLabel jStonesManA = new GameLabel(iconStonesManA, stonesManA);
		jMancalaA.add(BorderLayout.CENTER, jStonesManA);
		jMancalaA.add(BorderLayout.NORTH, new JLabel("Player A Mancala"));
		// testing mancala pit
		jMancalaA.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("Mancala A @index " + stonesManA.getIndexInArray());
				System.out.println("Stones: " + stonesManA.getNumberOfStones());
			}
		});
		// add to model ArrayList
		model.addStoneCluster(stonesManA, stonesManA.getIndexInArray());

		// ------------FINISH SETTING UP-----------------------------------------------

		ArrayList<StoneCluster> sc = model.getStoneClusters();

		//store state for undo
		model.setBackUp(sc);

		//action listener for undo button
		ActionListener undoListener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				model.undo();
				System.out.println("Undo is pressed!");
			}
		};


		// adding main pits and both mancala pits
		frame.add(BorderLayout.CENTER, center);
		frame.add(BorderLayout.WEST, jMancalaB);
		frame.add(BorderLayout.EAST, jMancalaA);

		// create button bar
		String playerLabel = model.getPlayerTurn() ? "Player A Turn" : "Player B Turn";
		JLabel label = new JLabel(playerLabel);
		JPanel buttonPanel = new JPanel();
		JButton exit = new JButton("Exit");
		JButton undo = new JButton("Undo");
		undo.addActionListener(undoListener);
		//get color from theme
		buttonPanel.setBackground(theme.getColor());

		
		//player scoreboards
		JLabel playerAScore = new JLabel("Player A Score: " + model.getStoneClusters().get(6).getNumberOfStones());
		JLabel playerBScore = new JLabel("Player B Score: " + model.getStoneClusters().get(13).getNumberOfStones());

		//listens for model updates and repaints the view
		ChangeListener cListener = new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				for (StoneCluster sc : model.getStoneClusters()) {
					int numOfStones = sc.getNumberOfStones();
					sc.zeroStones();
					sc.addNumberOfStones(numOfStones);
					sc.getLabel().repaint();
				}
				playerAScore.setText("Player A Score: " + model.getStoneClusters().get(6).getNumberOfStones());
				playerBScore.setText("Player B Score: " + model.getStoneClusters().get(13).getNumberOfStones());
				playerAScore.repaint();
				playerBScore.repaint();
				String player = model.getPlayerTurn() ? "Player A's Turn" : "Player B's Turn";
				label.setText(player);
				label.repaint();
				buttonPanel.repaint();

			}
		};

		model.attach(cListener);
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.exit(-1);
			}
		});

		//add all buttons and labels to button panel
		buttonPanel.add(playerBScore);
		buttonPanel.add(undo);
		buttonPanel.add(label);
		buttonPanel.add(exit);
		buttonPanel.add(playerAScore);
		frame.add(BorderLayout.NORTH, buttonPanel);

		
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}