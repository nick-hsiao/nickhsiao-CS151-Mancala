import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

public class BoardShape {
	private Ellipse2D[][] listPits;
	private int width;
	private int height;
	// private Pit[][] arrPits;
	private int count;
	private int flag = 0;// to stop the arrayEllipse changing info
	private static final int NUMBERS_OF_PLAYERS = 2;
	private static final int PITS_EACH_SIDE = 12;

	public BoardShape(int h, int w) {
		setListPits(new Ellipse2D[2][6]);
		width = w;
		height = h;
	}

	public Ellipse2D[][] getListPits() {
		return listPits;
	}

	public Ellipse2D getEllipse(int i, int j) {
		return listPits[i][j];
	}

	public void setListPits(Ellipse2D[][] listPits) {
		this.listPits = listPits;
	}

	// this method set the specific position of ellispe array
	public void setEllipse(Ellipse2D newEllipse, int b, int c) {
		this.listPits[b][c] = newEllipse;
	}

	// public Ellipse2D re() {
	// return new Ellipse2D.Double(300, 300, 400 , 300);
	// }

	public void drawMancalaBoard(Graphics2D g2, Pit p) {
		int x = 200;
		int y = 100;
		int increment = 120;
		RoundRectangle2D outShape = new RoundRectangle2D.Double(x, y, width, height, x, y);
		g2.draw(outShape);
		// Ellipse2D ep;

		if (flag == 0) {
			for (int i = 0; i < PITS_EACH_SIDE / 2; i++) {
				for (int k = 0; k < NUMBERS_OF_PLAYERS; k++) {
					if (k == 0) {
						// setEllipse(p.drawpit(g2, increment),k,i);
						// ep=p.drawpit(g2, increment);
						count += increment;
						listPits[k][i] = new Ellipse2D.Double(x + 30 + count, y + 40, 90, 210);
						g2.draw(listPits[k][i]);
					} else {
						// setEllipse(p.drawpit2(g2, increment),k,i);
						// ep=p.drawpit2(g2, increment);
						// ep=new Ellipse2D.Double(x+30+count, y+275, 90, 210);
						listPits[k][i] = new Ellipse2D.Double(x + 30 + count, y + 275, 90, 210);
						g2.draw(listPits[k][i]);
					}
				} // end inner for loop
			} // end outter for loop
			flag = 1;
		}

	}// end drawMancalaBoard

	// public Ellipse2D re() {
	// // TODO Auto-generated method stub
	// return listPits[0][0];
	// }

	// public void draw Stones
	// create an array of pits to hold number of stones then keep redrawing
	// each time useer click
}