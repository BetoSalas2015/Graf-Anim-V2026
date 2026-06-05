import java.awt.*;
import java.awt.geom.*;
import java.util.Vector;

public class Dibujo extends Canvas {

    private Vector<Point> vectorPuntos;

    public Dibujo() {

    }

    public void asignaPuntos(Vector<Point> vector) {
        this.vectorPuntos = vector;
    }

    private void planoCoordenado(Graphics2D g2d) {
        //  Coloreamos el fondo
        setBackground( new Color(0xC1, 0xda, 0xaf));
        // determinamos las dimensiones de la venatana
        int h = getSize().height / 2;
        int w = getSize().width / 2;
        // Centramos el origen
        g2d.translate(w, h);
        // Dibujamos la rejilla de coordenadas
        g2d.setStroke(new BasicStroke(2-0f));
        g2d.setColor(new Color(0xd9, 0xda, 0xdb));

        for (int i = 0; i > -w; i -= 20) {
            g2d.draw(new Line2D.Float(i, -h, i, h));
        }

        for (int i = 0; i > -h; i -= 20) {
            g2d.draw(new Line2D.Float(-w, i, w, i));
        }

        for (int i = 0; i < w; i += 20) {
            g2d.draw(new Line2D.Float(i, -h, i, h));
        }

        for (int i = 0; i < h; i += 20) {
            g2d.draw(new Line2D.Float(-w, i, w, i));
        }

        // Dibujar los ejes x y y
        g2d.setStroke( new BasicStroke(3.0f));
        g2d.setColor(new Color(0x30, 0x30, 0x30) );
        g2d.draw(new Line2D.Float(-w,0, w, 0));
        g2d.draw(new Line2D.Float(0,-h, 0, h));
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        planoCoordenado(g2d);
        int i; 
        g2d.setColor(Color.BLUE);  
        g2d.setStroke(new BasicStroke(2.0f));         
        if (vectorPuntos != null) {
            for (i = 0; i < vectorPuntos.size() - 1; i++) {
                g2d.draw(new Line2D.Float(vectorPuntos.get(i),vectorPuntos.get(i + 1)));
            }
            g2d.draw(new Line2D.Float(vectorPuntos.get(i), vectorPuntos.get(0)));
        }
        
    }
    
}
