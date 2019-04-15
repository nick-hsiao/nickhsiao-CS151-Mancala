import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * First requirement is to let the user decide between 3 stones or 4 stones*/
public class MancalaTest {
	public static void main(String[] args) {
		int frameX=600;
		int frameY=400;
		JFrame frame = new JFrame("Mancala game");
		
		//setBackground(Color.RED);
		frame.setSize(frameX,frameY);
		String[] buttons= {"3 Stones:Yellow","4 Stones:Yellow","3 Stones:Red","4 Stones:Red"};
		int click = JOptionPane.showOptionDialog(null, "Choose numberOfStones: table color","Mancala team Kan"
				,JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,buttons,buttons[0]); 
		
		if(click ==0) {
			//do something
		}else if(click==1) {
			//
		}else if(click ==2) {
			
		}else {
			
		}
		//frame.setBounds(400, 400, 600, 300);
//		JPanel panel = new JPanel();
//		JButton b1 = new JButton("3:red");
//		JButton b2 = new JButton("4:red");
//		JButton b3 = new JButton("3:blue");
//		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
//		panel.add(b1);
//		panel.add(Box.createRigidArea(new Dimension(10,0)));
		//panel.setMaximumSize(new Dimension(100,100));
		//panel.add(Box.CENTER_ALIGNMENT);
		//panel.add(Box.CENTER_ALIGNMENT);
//		panel.add(b2);
//		panel.add(Box.createRigidArea(new Dimension(10,0)));
//		panel.add(b3);
//		panel.setBackground(Color.RED);
//		frame.add(panel);
		frame.getContentPane().setBackground(Color.RED);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
}
