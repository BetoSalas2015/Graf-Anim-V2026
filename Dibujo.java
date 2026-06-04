import java.awt.*;
import java.awt.geom.*;

public class Dibujo extends Canvas {

    public Dibujo() {

    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.drawLine(100, 100, 150, 150);
        g2d.draw(new  Line2D.Float(210,210,260,260) );
    }
    
}
