import java.awt.*;
import java.awt.geom.*;

public class Dibujo extends Canvas {

    int x1, y1, x2, y2;

    public Dibujo() {

    }

    public void asignaPuntos(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.draw(new  Line2D.Float(this.x1,this.y1,this.x2,this.y2) );
    }
    
}
