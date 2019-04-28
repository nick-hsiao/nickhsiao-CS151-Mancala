import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * First requirement is to let the user decide between 3 stones or 4 stones*/
public class MancalaTest {
	public static void main(String[] args) {
		int frameX=600;
		int frameY=400;
		
		
		ViewController control;
		JFrame frame = new JFrame("Mancala game");
		
		frame.setSize(frameX,frameY);
		String[] buttons= {"3 Stones:Yellow","4 Stones:Yellow","3 Stones:Red","4 Stones:Red"};
		int click = JOptionPane.showOptionDialog(null, "Choose numberOfStones: table color","Mancala team Kan"
				,JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,buttons,buttons[0]); 
		
		if(click ==0) {
			BoardShape board = new BoardShape(500,1000);
			frame.setSize(1500, 700);
			Pit pitti = new Pit(3);
			control = new ViewController(board,pitti);
			frame.add(control);	

			frame.getContentPane().setBackground(Color.YELLOW);
		}else if(click==1) {
			//
			
			frame.getContentPane().setBackground(Color.YELLOW);
		}else if(click ==2) {
			
			frame.getContentPane().setBackground(Color.RED);
		}else {
			frame.getContentPane().setBackground(Color.RED);
		}
		

		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
}
