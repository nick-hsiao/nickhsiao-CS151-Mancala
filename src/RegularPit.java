import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

public class RegularPit extends Pit{
    

    public RegularPit(int x, int y, int width, int pieces, int pitNum) {
        super(x, y, width);
        super.setPieces(pieces);
        super.setpitNum(pitNum);
    }
}
