import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainMenu{

    public MainMenu(){

        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());

        JButton classic3 = new JButton("Classic Theme : 3 Stones");
        JButton classic4 = new JButton("Classic Theme : 4 Stones");
        JButton color3 = new JButton("Color Theme : 3 Stones");
        JButton color4 = new JButton("Color Theme : 4 Stones");

        classic3.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                new Board(new ClassicStyle(),3);
                frame.dispose();
            }
        });

        classic4.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                new Board(new ClassicStyle(),4);
                frame.dispose();
                
            }
        });

        color3.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                new Board(new ColorStyle(),3);
                frame.dispose();
                
            }
        });

        color4.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                new Board(new ColorStyle(),4);
                frame.dispose();
                
            }
        });
        
        frame.add(classic3);
        frame.add(classic4);
        frame.add(color3);
        frame.add(color4);

        //frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);






    }



}