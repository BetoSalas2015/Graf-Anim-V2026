import java.awt.*;
import java.awt.geom.*;
import java.util.Vector;

public class Dibujo extends Canvas {

    private Vector<Punto> vectorPuntos;

    public Dibujo() {

    }

    public void asignaPuntos(Vector<Punto> vector) {
        this.vectorPuntos = vector;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int i;            
        if (vectorPuntos != null) {
            for (i = 0; i < vectorPuntos.size() - 1; i++) {
                g2d.draw(new Line2D.Float(vectorPuntos.get(i).getX(),vectorPuntos.get(i).getY(),
                                            vectorPuntos.get(i + 1).getX(),vectorPuntos.get(i + 1).getY()));
            }
            g2d.draw(new Line2D.Float(vectorPuntos.get(i).getX(),vectorPuntos.get(i).getY(),
                                            vectorPuntos.get(0).getX(),vectorPuntos.get(0).getY()));
        }
        
    }
    
}
