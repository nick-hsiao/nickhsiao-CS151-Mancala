import java.awt.*;
import java.util.ArrayList;

public class GameModel{
    private int numStones;
    private int gameStyle;
    private Player playerOne;
    private Player playerTwo;
    private ArrayList<Pit> pits = new ArrayList<Pit>();
    private ArrayList<ShapePanel> panels = new ArrayList<ShapePanel>();
    private Player currentPlayer;

    public GameModel(){
        this.playerOne = new Player(true);
        this.playerTwo = new Player(false);
        this.currentPlayer = playerOne;
        //for(int i=0)
    }

    public ArrayList<Pit> getPits(){
    	return pits;
    }
    
    public void setnumStones(int n){
        this.numStones = n;
        //System.out.println(this.numStones);
    }

    public void setgameStyle(int n){
        this.gameStyle = n;
        //System.out.println(this.gameStyle);
    }

    public void addPanel(ShapePanel s){
        this.panels.add(0,s);
    }
    public void addPit(Pit p){
        this.pits.add(p);
    }

    public void addPitIndex(int i, Pit p){
        this.pits.add(i,p);
//        if(pits.size()==7) {
//        	System.out.println(pits.size()+ " " +pits.get(6).getPieces() );pits.get(4).setPieces(2);
//        	System.out.println(pits.size()+ " " +pits.get(1).getPieces() );
//        	System.out.println(pits.size()+ " " +pits.get(4).getPieces() );
//        }
        
        
//        for(int j=0;j<pits.size();j++) {
//        	pits.get(j).setPieces(numStones);
//        	System.out.println(pits.size()+ " " +pits.get(j).getPieces() );
//        }
        
    }

    public int getnumStones(){
        return this.numStones;
    }

    public int getgameStyle(){
        return this.gameStyle;
    }

    public Player getPlayerOne(){
        return playerOne;
    }

    public Player getPlayerTwo(){
        return playerTwo;
    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    //i is the pit they clicked corresponding
    public void takeTurn(int i){
    	int count=i;
    	System.out.println(i);
    	int holdStones = pits.get(i).getPieces(); // pick up number of stone

    	
        pits.get(i).setPieces(0);// set picked place to 0
        //keep place 1 more stone to the next pits once each
        while(holdStones!=0 && count<pits.size()-1) {
        	count+=1;
        	pits.get(count).setPieces(pits.get(count).getPieces()+1);
        	holdStones-=1;
        }
        
        // if it met the pit 14,skip the loop and start to put stone from 0(Mancala left)
        count =-1;
        while(holdStones!=0) {
        	count+=1;
        	pits.get(count).setPieces(pits.get(count).getPieces()+1);
        	holdStones-=1;
        }
        
        //Printing to check values
        for(int a=0;a<pits.size();a++) {
        	System.out.println(pits.size()+ " Pit "+ a + " "  +pits.get(a).getPieces() );
        }
        //panels.get(i).repaint();


    }


}