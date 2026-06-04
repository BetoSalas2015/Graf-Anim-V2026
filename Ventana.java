import java.awt.*;
import java.awt.event.*;

public class Ventana extends Frame {

    private Dibujo dibujo;

    // Constructor
    public Ventana() {
        super("Dibujo");
        setSize(400, 400);
        setVisible( true );
        dibujo = new Dibujo();
        add(dibujo, "Center");

        addWindowListener( new CloseWindow());
    }

    private class CloseWindow extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            setVisible( false );
            dispose();
        }
    }

    

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
    }
}