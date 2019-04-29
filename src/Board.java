import java.awt.*;
import javax.swing.*;

import java.awt.event.MouseEvent;

public class Board {
    private GameModel model;
    private int numStones;
    private int gameStyle;

    public Board(GameModel m) {
    	//setting up variable
        this.model = m;

        this.numStones = model.getnumStones();
        this.gameStyle = model.getgameStyle();
        
        //System.out.println(gameStyle + " " + numStones);
        //calling Jfram and Jpanel to make things combinaition and drawing
        JFrame board = new JFrame();
        board.setLayout(new BorderLayout());
        JPanel container = new JPanel();
        container.setLayout(new GridLayout(2, 6));

        for (int i = 0; i < 6; i++) {
        	//this is where the problem come up, numStone keep it drawing the same thing (3 or 4)
            Pit pit = new RegularPit(0, 0, 130, numStones, 12 - i); // numStones will usually change
            ShapePanel panel = new ShapePanel(pit);
            panel.setLayout(new BorderLayout());
            int pitNum = pit.getpitNum();
            model.addPitIndex(0, pit);
            

            int j = i + 1;
            JLabel label = new JLabel("A" + j);
            panel.add(label,BorderLayout.NORTH);

            if (gameStyle == 0) {
                panel.setBackground(Color.WHITE);
            } else {
                panel.setBackground(Color.GRAY);
            }

            JLabel stones = new JLabel(Integer.toString(pit.getPieces()));
            panel.add(stones,BorderLayout.CENTER);
            panel.addMouseListener(new MouseAdapter() {

                public void mousePressed(MouseEvent e) {
                    System.out.println("Pit " + pitNum);
                    if(pitNum<7) {
                    	model.takeTurn(pitNum);
                    }else {
                    	model.takeTurn(pitNum+1);
                    }
                    
                    panel.repaint();
                    container.repaint();
                    board.repaint();
                }
            });
            model.addPanel(panel);
            container.add(panel);
        }

        for (int i = 11; i >= 6; i--) {
            Pit pit = new RegularPit(0, 0, 130, numStones, 12- i);
            ShapePanel panel = new ShapePanel(pit);
            panel.setLayout(new BorderLayout());
            int pitNum = pit.getpitNum();
            model.addPitIndex(0, pit);
            

            int j = 12-i;
            JLabel label = new JLabel("B" + j);
            panel.add(label,BorderLayout.NORTH);

            if (gameStyle == 0) {
                panel.setBackground(Color.WHITE);
            } else {
                panel.setBackground(Color.GRAY);
            }

            JLabel stones = new JLabel(Integer.toString(pit.getPieces()));
            panel.add(stones,BorderLayout.CENTER);
            panel.addMouseListener(new MouseAdapter() {

                public void mousePressed(MouseEvent e) {
                    System.out.println("Pit " + pitNum);
                    
                    model.takeTurn(pitNum);
                    panel.repaint();
                    container.repaint();
                    board.repaint();
                }
            });
            model.addPanel(panel);
            container.add(panel);
        }

        Pit pit1 = new MancalaPit(0, 0, 200, 0, 1, model.getPlayerOne());
        ShapePanel panel1 = new ShapePanel(pit1);
        panel1.setPreferredSize(new Dimension(200, 400));
        panel1.setLayout(new FlowLayout());
        JLabel player1 = new JLabel("Player A");
        panel1.add(player1);

        panel1.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                System.out.println("Player 1 pit");
            }
        });
        model.addPitIndex(0, pit1);

        Pit pit2 = new MancalaPit(0, 0, 200, 0, 1, model.getPlayerTwo());
        ShapePanel panel2 = new ShapePanel(pit2);
        panel2.setPreferredSize(new Dimension(200, 400));
        panel2.setLayout(new FlowLayout());
        JLabel player2 = new JLabel("Player B");
        panel2.add(player2);

        panel2.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                System.out.println("Player 2 pit");
            }
        });
        model.addPitIndex(7, pit2);

        if (gameStyle == 0) {
            panel1.setBackground(Color.WHITE);
            panel2.setBackground(Color.WHITE);
        } else {
            panel1.setBackground(Color.GRAY);
            panel2.setBackground(Color.GRAY);
        }

        container.setPreferredSize(new Dimension(800, 400));
        board.add(panel1, BorderLayout.WEST);
        board.add(panel2, BorderLayout.EAST);
        board.add(container, BorderLayout.CENTER);

        if (gameStyle == 0) {
            board.getContentPane().setBackground(Color.WHITE);

        } else {
            board.getContentPane().setBackground(Color.GRAY);

        }
        board.setPreferredSize(new Dimension(1400, 400));
        board.setTitle("Mancala");
        board.pack();
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board.setLocationRelativeTo(null);
        board.setVisible(true);

    }

    
}