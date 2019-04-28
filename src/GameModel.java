import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class GameModel{
    private int numStones;
    private int gameStyle;
    private Player playerOne;
    private Player playerTwo;
    private ArrayList<Pit> pits = new ArrayList<Pit>();

    public GameModel(){
        this.playerOne = new Player(true);
        this.playerTwo = new Player(false);
        
    }

    public void setnumStones(int n){
        this.numStones = n;
        System.out.println(this.numStones);
    }

    public void setgameStyle(int n){
        this.gameStyle = n;
        System.out.println(this.gameStyle);
    }

    public void addPit(Pit p){
        this.pits.add(p);
    }

    public void addPitIndex(int i, Pit p){
        this.pits.add(i,p);
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


}