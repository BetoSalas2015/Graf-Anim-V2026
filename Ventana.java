/** 
 *      Vrentana.java
 */
import java.awt.*;
import java.awt.event.*;

public class Ventana extends Frame {

    private Dibujo dibujo;
    private Panel panelDatos, panelPunto1, panelPunto2;
    private TextField txtPunto1x, txtPunto1y, txtPunto2x, txtPunto2y;
    private Label lblPunto1, lblPunto2;
    private Button btnGraficar;

    // Constructor
    public Ventana() {
        super("Dibujo");
        setSize(400, 400);
        setVisible( true );

        // Interfaz de Usuario
        dibujo = new Dibujo();
        
        panelDatos = new Panel();
        panelDatos.setLayout(new GridLayout(1, 10));
        panelPunto1 = new Panel();
        panelPunto1.setLayout(new GridLayout(1, 2));
        panelPunto2 = new Panel();
        panelPunto2.setLayout(new GridLayout(1, 2));

        lblPunto1 = new Label("Punto 1");
        lblPunto2 = new Label("Punto 2");

        txtPunto1x = new TextField("0");
        txtPunto1y = new TextField("0");
        txtPunto2x = new TextField("0");
        txtPunto2y = new TextField("0");

        btnGraficar = new Button("Graficar");

        panelPunto1.add(txtPunto1x);
        panelPunto1.add(txtPunto1y);
        panelPunto2.add(txtPunto2x);
        panelPunto2.add(txtPunto2y);

        panelDatos.add(lblPunto1);
        panelDatos.add(panelPunto1);
        panelDatos.add(lblPunto2);
        panelDatos.add(panelPunto2);

        add(panelDatos, "North");
        add(dibujo, "Center");
        add(btnGraficar, "South");

        // Asignacvion de Listeners
        addWindowListener( new CloseWindow());
        btnGraficar.addActionListener(new BotónGraficar());
    }

    private class CloseWindow extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            setVisible( false );
            dispose();
        }
    }

    private class BotónGraficar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Punto punto1 = new Punto(Integer.parseInt(txtPunto1x.getText()),
                                    Integer.parseInt(txtPunto1y.getText()));
            Punto punto2 = new Punto(Integer.parseInt(txtPunto2x.getText()), 
                                     Integer.parseInt(txtPunto2y.getText()));
            
            dibujo.asignaPuntos(punto1, punto2);
            dibujo.repaint();
        }
    }
    

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
    }
}