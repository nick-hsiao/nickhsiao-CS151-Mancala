import java.awt.*;
import javax.swing.*;

import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;


public class Board{
    private GameModel model;
    private int numStones;
    private int gameStyle;
    

    public Board(GameModel m){
        
        this.model = m;

        this.numStones = model.getnumStones();
        this.gameStyle = model.getgameStyle();
        System.out.println(gameStyle + " " + numStones);
        JFrame board = new JFrame();
        board.setLayout(new BorderLayout());
        JPanel container = new JPanel();
        container.setLayout(new GridLayout(2,6));

        for (int i=0; i<12; i++){
            Pit pit = new RegularPit(0,0,130,numStones,i);
            ShapePanel panel= new ShapePanel(pit);
            int pitNum = pit.getpitNum();
            model.addPit(pit);
            if(i<6){
                int j = i+1;
                JLabel label = new JLabel("A"+j);
                panel.add(label);
            }
            else{
                int j = i-5;
                JLabel label = new JLabel("A"+j);
                panel.add(label);

            }
            

            if (gameStyle == 0){
                panel.setBackground(Color.WHITE);
            }
            else{
                panel.setBackground(Color.GRAY);
            }

            for (int j=0; j<numStones; j++){
                pit.add(new Ellipse2D.Double(15,15,15,15));
				
            }
            panel.addMouseListener(new MouseAdapter() {
                
                public void mousePressed(MouseEvent e)
                {
                    System.out.println("Pit " + pitNum);
                }
            });
            container.add(panel);
        }

        Pit pit1 = new MancalaPit(0,0,200,0,1,model.getPlayerOne());
        ShapePanel panel1= new ShapePanel(pit1);
        panel1.setPreferredSize(new Dimension(200, 400));
        panel1.setLayout(new FlowLayout());
        JLabel player1 = new JLabel("Player One");
        panel1.add(player1);
        
        
        panel1.addMouseListener(new MouseAdapter() {
                
            public void mousePressed(MouseEvent e)
            {
                System.out.println("Player 1 Pit");
            }
        });
        model.addPitIndex(0, pit1);

        Pit pit2 = new MancalaPit(0,0,200,0,1,model.getPlayerTwo());
        ShapePanel panel2= new ShapePanel(pit2);
        panel2.setPreferredSize(new Dimension(200, 400));
        panel2.setLayout(new FlowLayout());
        JLabel player2 = new JLabel("Player Two");
        panel2.add(player2);
        
        

        panel2.addMouseListener(new MouseAdapter() {
                
            public void mousePressed(MouseEvent e)
            {
                System.out.println("Player 2 pit");
            }
        });
        model.addPitIndex(7, pit2);

        if (gameStyle == 0){
            panel1.setBackground(Color.WHITE);
            panel2.setBackground(Color.WHITE);
        }
        else{
            panel1.setBackground(Color.GRAY);
            panel2.setBackground(Color.GRAY);
        }

        container.setPreferredSize(new Dimension (800,400));
        board.add(panel1, BorderLayout.WEST);
        board.add(panel2, BorderLayout.EAST);
        board.add(container,BorderLayout.CENTER);

       
        
    
		
      


        if (gameStyle == 0){
            board.getContentPane().setBackground(Color.WHITE);
            
        }
        else{
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