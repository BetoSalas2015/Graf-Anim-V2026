import java.awt.*;
import java.awt.geom.*;

public class Dibujo extends Canvas {

    private Punto punto1, punto2;

    public Dibujo() {

    }

    public void asignaPuntos(int x1, int y1, int x2, int y2) {
        this.punto1 = new Punto(x1, y1);
        this.punto2 = new Punto(x2, y2);
    }

    public void asignaPuntos(Punto punto1, Punto punto2) {
        this.punto1 = punto1;
        this.punto2 = punto2;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.draw(new  Line2D.Float(punto1.getX(),  punto1.getY(), punto2.getX(), punto2.getY()));
    }
    
}
