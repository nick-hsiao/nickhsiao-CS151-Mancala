import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainMenu{
    GameModel model;

    public MainMenu(){
        this.model = new GameModel();
        JButton threeButtonPlain = new JButton("3 Stones : Plain Style");
        JButton fourButtonPlain = new JButton("4 Stones : Plain Style");
        JButton threeButtonGray = new JButton("3 Stones : Gray Style");
        JButton fourButtonGray = new JButton("4 Stones : Gray Style");
        JPanel buttonBar = new JPanel();
        buttonBar.add(threeButtonPlain);
        buttonBar.add(fourButtonPlain);
        buttonBar.add(threeButtonGray);
        buttonBar.add(fourButtonGray);

        JFrame menu = new JFrame();
        menu.add(buttonBar);
        menu.setTitle("Main Menu");
        menu.pack();
        menu.setLocationRelativeTo(null); 
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setVisible(true);

        threeButtonPlain.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setnumStones(3);
                model.setgameStyle(0);
                new Board(model);
                menu.dispose();
            }
        });
        fourButtonPlain.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setnumStones(4);
                model.setgameStyle(0);
                new Board(model);
                menu.dispose();
                
            }
        });

        threeButtonGray.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setnumStones(3);
                model.setgameStyle(1);
                new Board(model);
                menu.dispose();
            }
        });
        fourButtonGray.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setnumStones(4);
                model.setgameStyle(1);
                new Board(model);
                menu.dispose();
                
            }
        });
        
       
    }

}