

public class MancalaPit extends Pit{
    private Player player;

    public MancalaPit(int x, int y, int width, int pieces, int pitNum,Player p) {
        super(x, y, width);
        super.setPieces(pieces);
        super.setpitNum(pitNum);
        this.player = p;
    }

    public Player getPlayer(){
        return this.player;
    }


   
}