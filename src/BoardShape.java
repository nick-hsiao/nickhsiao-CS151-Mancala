import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;


public class BoardShape {
	private Ellipse2D[][] listPits;
	private int width;
	private int height;
	private static final int NUMBERS_OF_PLAYERS = 2;
	private static final int PITS_EACH_SIDE =12;
	
	public BoardShape(int h, int w) {
		setListPits(new Ellipse2D[2][6]);
		width =w;
		height =h;
		// TODO Auto-generated constructor stub
	}

	public Ellipse2D[][] getListPits() {
		return listPits;
	}

	public void setListPits(Ellipse2D[][] listPits) {
		this.listPits = listPits;
	}
	
	//this method set the specific position of ellispe array
	public void setEllipse(Ellipse2D newEllipse, int b, int c) {
		this.listPits[b][c]= newEllipse;
	}
	
	public void drawMancalaBoard(Graphics2D g2) {
		RoundRectangle2D outShape = new RoundRectangle2D.Double();
		
	}

}
