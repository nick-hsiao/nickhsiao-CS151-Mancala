import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.*;
public abstract class Pit extends PitShape{

    public Pit(int x, int y, int width)
	{
        Ellipse2D.Double pit = new Ellipse2D.Double(x, y, width, width*1.3);
        add(pit);
        
    }
    
    public int pieces;
    public int pitNum;
   
    public int getPieces(){
        return pieces;
    }
    public void setPieces(int n){
        pieces = n;
    }

    public int getpitNum(){
        return pitNum;
    }

    public void setpitNum(int n){
        pitNum = n;
    }

}