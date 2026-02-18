package SwingMod17;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MiEscritorioApp extends JFrame{
    private JDesktopPane desktopPane;

    public MiEscritorioApp() {
        // Configuración básica. Hereda del JFrame no del JComponent.
        setTitle("Arquitectura Swing: JComponent y JDesktopPane");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        desktopPane = new JDesktopPane();
        desktopPane.setBackground(new Color(45, 52, 54));
        desktopPane.setBorder(BorderFactory.createTitledBorder("Área de trabajo"));

        JButton btnNuevaVentana = new JButton("Crear Ventana Interna");
        btnNuevaVentana.addActionListener(e -> crearVentanaInterna());

        getContentPane().add(desktopPane, BorderLayout.CENTER);
        getContentPane().add(btnNuevaVentana, BorderLayout.SOUTH);
    }

    private void crearVentanaInterna() {
        // JInternalFrame funciona como un JFrame pero vive dentro del JDesktopPane
        JInternalFrame internalFrame =
                new JInternalFrame("Ventana Documento", true, true, true, true);

        // Configuración del JComponent dentro de la ventana interna.
        JPanel panelContenido = new JPanel();
        panelContenido.setBackground(Color.WHITE);

        JLabel etiqueta = new JLabel("Soy un JComponent dentro de un JDesktopPane.");
        etiqueta.setToolTipText("Este es un ToolTip heredado de JComponent");

        panelContenido.add(etiqueta);
        internalFrame.add(panelContenido);
        internalFrame.setSize(300, 200);
        internalFrame.setVisible(true);

        // Agregamos al contenedor especializado.
        desktopPane.add(internalFrame);

        try {
            internalFrame.setSelected(true);
        }   catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()
        -> {
            new MiEscritorioApp().setVisible(true);
        });
    }
}
