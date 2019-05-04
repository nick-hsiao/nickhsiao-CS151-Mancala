import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class Board {

	public Board(BoardStyle theme, int s) {

		final GameModel model = new GameModel(s);

		// creating the JFrame for everything to be put on
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.setPreferredSize(new Dimension(950, 500));

		// the JPanel in the center that holds the middle pits in GridLayout
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(2, 6));

		// ----------------Setting up the BSide Pits and its
		// StoneClusters--------------------------------
		// BSide goes in indexes starting 7 to 12
		for (int i = 12; i >= 7; i--) {
			Pit pit = new Pit();
			final ShapePanel jPit = new ShapePanel(pit);

			jPit.setBackground(theme.getColor());

			jPit.setLayout(new BorderLayout());
			StoneCluster stones = new StoneCluster(model.getStartingStones(), i, false); // starting number of stones
																							// and index in array
			GameIcon iconStones = new GameIcon(stones);
			final GameLabel jStones = new GameLabel(iconStones, stones);
			jPit.add(BorderLayout.CENTER, jStones);
			jPit.add(BorderLayout.NORTH, new JLabel("B" + (stones.getIndexInArray() % 7 + 1)));
			// Add Mouse Listener
			jStones.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					System.out.println(
							"pitB" + (stones.getIndexInArray() % 7 + 1) + " @index: " + stones.getIndexInArray());
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
		// ---------------------------------------------------------------------------------------------
		// -----------Setting up Mancala B and its
		// StoneClusters--------------------------------------

		// Mancala B goes after BSide
		Mancala mancalaB = new Mancala(10, 20);
		final ShapePanel jMancalaB = new ShapePanel(mancalaB);

		jMancalaB.setBackground(theme.getColor());

		jMancalaB.setPreferredSize(new Dimension(120, 100));
		jMancalaB.setLayout(new BorderLayout());
		StoneCluster stonesManB = new StoneCluster(0, 13, false); // Mancala starts empty
		GameIcon iconStonesManB = new GameIcon(stonesManB);
		final GameLabel jStonesManB = new GameLabel(iconStonesManB, stonesManB);
		jMancalaB.add(BorderLayout.CENTER, jStonesManB);
		jMancalaB.add(BorderLayout.NORTH, new JLabel("Player B Mancala"));
		// Add Mouse Listener
		jMancalaB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("Mancala B @index " + stonesManB.getIndexInArray());
				System.out.println("Stones: " + stonesManB.getNumberOfStones());

			}
		});
		// add to model ArrayList
		model.addStoneCluster(stonesManB, stonesManB.getIndexInArray());

		// -------------------------------------------------------------------------------------------------
		// ----------------Setting up the ASide Pits and its
		// StoneClusters------------------------------
		// ASide goes in first starting from 0 to 5
		for (int i = 0; i <= 5; i++) {
			Pit pit = new Pit();
			final ShapePanel jPit = new ShapePanel(pit);

			jPit.setBackground(theme.getColor());

			jPit.setLayout(new BorderLayout());
			StoneCluster stones = new StoneCluster(model.getStartingStones(), i, true); // starting number of stones and
																						// index in array
			GameIcon iconStones = new GameIcon(stones);
			final GameLabel jStones = new GameLabel(iconStones, stones);
			jPit.add(BorderLayout.CENTER, jStones);
			jPit.add(BorderLayout.NORTH, new JLabel("A" + (stones.getIndexInArray() + 1)));
			// Add mouse Listener
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
		// ------------------------------------------------------------------------------------------------
		// -----------Setting up Mancala A and its
		// StoneClusters--------------------------------------
		// Mancala A goes in after ASide
		Mancala mancalaA = new Mancala(0, 20);
		final ShapePanel jMancalaA = new ShapePanel(mancalaA);

		jMancalaA.setBackground(theme.getColor());

		jMancalaA.setPreferredSize(new Dimension(120, 100));
		jMancalaA.setLayout(new BorderLayout());
		StoneCluster stonesManA = new StoneCluster(0, 6, true); // Mancala starts empty
		GameIcon iconStonesManA = new GameIcon(stonesManA);
		final GameLabel jStonesManA = new GameLabel(iconStonesManA, stonesManA);
		jMancalaA.add(BorderLayout.CENTER, jStonesManA);
		jMancalaA.add(BorderLayout.NORTH, new JLabel("Player A Mancala"));
		// Add mouse listener
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

		model.setBackUp(sc);

		// ----------ADD CHANGE LISTENERS (UPDATE
		// VIEW)----------------------------------

		// action listener (move out of this block)
		ActionListener undoListener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				model.undo();
				System.out.println("Undo is pressed!");
			}
		};

		// -------------FINISH CHANGE LISTENERS--------------------------------------

		// ----------PUT EVERYTHING ONTO THE FRAME-------------------------------

		// adding GameShapes(Pits,Mancalas) to the frame
		frame.add(BorderLayout.CENTER, center);
		frame.add(BorderLayout.WEST, jMancalaB);
		frame.add(BorderLayout.EAST, jMancalaA);

		// Buttons on top
		String playerLabel = model.getPlayerTurn() ? "Player A Turn" : "Player B Turn";
		JLabel label = new JLabel(playerLabel);
		JPanel buttonPanel = new JPanel();
		JButton exit = new JButton("Exit");
		JButton undo = new JButton("Undo");

		buttonPanel.setBackground(theme.getColor());

		undo.addActionListener(undoListener);

		JLabel playerAScore = new JLabel("Player A Score: " + model.getStoneClusters().get(6).getNumberOfStones());
		JLabel playerBScore = new JLabel("Player B Score: " + model.getStoneClusters().get(13).getNumberOfStones());

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
		buttonPanel.add(playerBScore);
		buttonPanel.add(undo);
		buttonPanel.add(label);
		buttonPanel.add(exit);
		buttonPanel.add(playerAScore);
		frame.add(BorderLayout.NORTH, buttonPanel);

		//setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}