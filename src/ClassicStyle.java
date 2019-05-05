import java.awt.Color;

/**
 * concrete class implement strategy
 * 
 * @author hsiao,huerta,pham
 */
public class ClassicStyle implements BoardStyle{

    /**
     * color used for background of each panel
     * 
     * @return light gray color
     */
    @Override
    public Color getColor() {
        return Color.LIGHT_GRAY;
    }

    

}