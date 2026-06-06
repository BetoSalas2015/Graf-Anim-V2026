
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Ventana extends Frame {

    private Dibujo dibujo;
    private Panel panelDatos, panelPunto1;
    private TextField txtPunto1x, txtPunto1y;
    private Label lblPunto1;
    private Button btnGraficar, btnAgregar, btnCargar;
    private Vector<Point> vectorPuntos;
    private BufferedReader entrada;

    // Constructor
    public Ventana() {
        super("Dibujo");
        setSize(400, 400);
        setVisible( true );

        vectorPuntos = new Vector<Point>();

        // Interfaz de Usuario
        dibujo = new Dibujo();
        
        panelDatos = new Panel();
        panelDatos.setLayout(new GridLayout(1, 10));
        panelPunto1 = new Panel();
        panelPunto1.setLayout(new GridLayout(1, 2));


        lblPunto1 = new Label("Punto: ");

        txtPunto1x = new TextField("0");
        txtPunto1y = new TextField("0");

        //btnGraficar = new Button("Graficar");
        //btnAgregar = new Button("Agregar Punto");
        btnCargar = new Button("Cargar Puntos");
        btnCargar.addActionListener(new BotonCargar());

        panelPunto1.add(txtPunto1x);
        panelPunto1.add(txtPunto1y);

        //panelDatos.add(lblPunto1);
        //panelDatos.add(panelPunto1);
        //panelDatos.add(btnAgregar);


        //add(panelDatos, "North");
        add(dibujo, "Center");
        //add(btnGraficar, "South");
        add(btnCargar, "South");

        // Asignacvion de Listeners
        addWindowListener( new CloseWindow());
        //btnGraficar.addActionListener(new BotónGraficar());
        //btnAgregar.addActionListener(new BotonAgregar());
        btnCargar.addActionListener(new BotonCargar());
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
            dibujo.asignaPuntos(vectorPuntos);
            dibujo.repaint();
        }
    }

    private class BotonAgregar implements ActionListener {
    
        @Override
        public void actionPerformed(ActionEvent e) {
            vectorPuntos.add( new Point(Integer.parseInt(txtPunto1x.getText()), 
                                         Integer.parseInt(txtPunto1y.getText())));
        }
    }

    private class BotonCargar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String c, cad1, cad2;
            StringTokenizer token;

            try {
               entrada = new BufferedReader(new FileReader("coordenadas.txt"));
               while ((c = entrada.readLine()) != null ) {
                    token = new StringTokenizer(c, ",");
                    cad1 = token.nextToken();
                    cad2 = token.nextToken();
                    vectorPuntos.add(new Point(Integer.parseInt(cad1), Integer.parseInt(cad2)));
               }
               entrada.close();
               dibujo.asignaPuntos(vectorPuntos);
               dibujo.repaint();
            } catch (IOException ex) {
                System.out.println("No se pudo abrir el archivo.");
            }
            
        }
        
    }
    

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
    }
}