package SwingMod17;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

public class GestiónArchivosApp extends JFrame {
    GestiónArchivosApp() {
        setTitle("Swing: JDialog y JFileChooser");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton btnAcción = new JButton("Abrir editor de archivos.");
        btnAcción.addActionListener(e -> mostrarDiálogoConfirmación());
        add(btnAcción);
    }

    private void mostrarDiálogoConfirmación() {
        // Creamos un JDialog (this es el parent frame).
        // El true indica que es MODAL.
        JDialog diálogo = new JDialog(this, "Confirmación requerida", true);
        diálogo.setLayout(new FlowLayout());
        diálogo.setSize(300, 150);
        diálogo.setLocationRelativeTo(this);

        JLabel mensaje = new JLabel("¿Deseas buscar un archivo en tu PC?");
        JButton btnSí = new JButton("Sí, buscar");
        JButton btnNo = new JButton("No, cancelar");

        btnSí.addActionListener(e -> {
            diálogo.dispose(); // Cerramos el diálogo.
            abrirSelectorArchivos(); // Llamamos al selector.
        });

        btnNo.addActionListener(e -> diálogo.dispose());

        diálogo.add(mensaje);
        diálogo.add(btnSí);
        diálogo.add(btnNo);
        diálogo.setVisible(true);
    }

    private void abrirSelectorArchivos() {
        // Instanciar JFileChooser
        JFileChooser selector = new JFileChooser();

        // Crear un filtro para que solo acepte .txt
        FileNameExtensionFilter filtro =
                new FileNameExtensionFilter("Archivos de Texto (.txt)", "txt");
        selector.setFileFilter(filtro);

        // Mostrar el diálogo de apertura.
        int resultado = selector.showOpenDialog(this);

        // Evaluar la respuesta del usuario.
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = selector.getSelectedFile();
            JOptionPane.showMessageDialog(this, "Has seleccionado: " +
                    archivoSeleccionado.getAbsolutePath(),
                    "Archivo Elegido", JOptionPane.INFORMATION_MESSAGE);
        }   else {
            System.out.println("El usuario canceló la selección.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()
                -> {
            new GestiónArchivosApp().setVisible(true);
        });
    }
}
