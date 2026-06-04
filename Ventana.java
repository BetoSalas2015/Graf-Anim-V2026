/** 
 *      Vrentana.java
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;

public class Ventana extends Frame {

    // Constructor
    public Ventana() {
        super("Dibujo");
        setSize(400, 400);
        setVisible( true );

        addWindowListener( new CloseWindow());
    }

    private class CloseWindow extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            setVisible( false );
            dispose();
        }
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.drawLine(100, 100, 150, 150);
        g2d.draw(new  Line2D.Float(210,210,260,260) );
    }

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
    }
}