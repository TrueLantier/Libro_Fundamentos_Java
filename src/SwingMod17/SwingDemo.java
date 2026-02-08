package SwingMod17;
import javax.swing.*;
import java.awt.*;

public class SwingDemo {
    SwingDemo() {
        // Crear contenedor.
        JFrame jfrm = new JFrame("Una aplicación Swing simple.");

        // Establecer tamaño inicial para el marco.
        jfrm.setSize(275, 100);

        // Terminar el programa cuando el usuario cierre la aplicación.
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Otros: JFrame.DO_NOTHING_ON_CLOSE, JFrame.HIDE_ON_CLOSE, JFrame.DISPOSE_ON_CLOSE

        // Crear una etiqueta basada en texto.
        JLabel jlab = new JLabel(" Programación GUI con Swing.");

        // Agregar la etiqueta al content pane.
        jfrm.add(jlab);
        // Localización: BorderLayout.NORTH o .CENTER, .EAST, .SOUTH, WEST

        // Mostrar el marco.
        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        // Crear el marco en el hilo de despacho de eventos.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingDemo();
            }
        });
    }
}
