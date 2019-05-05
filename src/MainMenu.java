import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * main menu class, allows user to choose board style and starting number of stones
 * 
 * @author hsiao,huerta,pham
 */
public class MainMenu{

    /**
     * constructor for main menu
     * 
     */
    public MainMenu(){

        //init frame and buttons
        JFrame frame = new JFrame();
        frame.setTitle("Mancala Main Menu");
        frame.setLayout(new FlowLayout());

        JButton classic3 = new JButton("Classic Theme : 3 Stones");
        JButton classic4 = new JButton("Classic Theme : 4 Stones");
        JButton color3 = new JButton("Color Theme : 3 Stones");
        JButton color4 = new JButton("Color Theme : 4 Stones");

        // each listener creates a new board instance with selecged style and starting number of stones
        // also closes the main menu frame
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

        //add the buttons to the frame
        frame.add(classic3);
        frame.add(classic4);
        frame.add(color3);
        frame.add(color4);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
		frame.setVisible(true);
    }
}