import java.awt.Color;
import java.util.Random;

public class ColorStyle implements BoardStyle{

    @Override
    public Color getColor() {
        Random rand = new Random();
        int i = rand.nextInt(6);
        
        return i == 0 ? Color.YELLOW : i == 1 ? Color.CYAN : i == 2 ? Color.PINK : i == 3 ?  Color.ORANGE : i ==4 ? Color.MAGENTA : Color.GREEN;
    }

}