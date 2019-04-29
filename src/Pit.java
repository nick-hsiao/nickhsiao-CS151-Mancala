import java.awt.geom.Ellipse2D;
public abstract class Pit extends PitShape{

    public Pit(int x, int y, int width)
	{
        Ellipse2D.Double pit = new Ellipse2D.Double(x, y, width, width*1.3);
        add(pit);
        
    }
    //number of stones at first
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