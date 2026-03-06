package SwingMod17;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import com.formdev.flatlaf.*;
import com.formdev.flatlaf.themes.*;

/*
Quiero hacer una clase que mezcle distintas cosas de Swing. Menús, temas, fondos, labels de imágenes, iconos.
 */

public class MenuDemo {
    JMenuBar menuBar;
    JMenu menuArchivo, menuTamaño, menuFondo, menuTema;
    JMenuItem abierto, cerrado, temaNimbus, temaLocal, temaMetal, temaMotif, temaFMacLight, temaFMacDark,
            temaFDark, temaFLight, temaFIntelliJ, temaFDarcula;
    JMenuItem[] temas = { temaNimbus, temaLocal, temaMetal, temaMotif, temaFMacLight, temaFMacDark,
            temaFDark, temaFLight, temaFIntelliJ, temaFDarcula};
    String[] nombresTemas = { "Nimbus", "Local", "Metal", "Motif", "MacLight", "MacDark",
            "Dark", "Light", "IntelliJ", "Darcula" };

    MenuDemo() throws Exception{
        UIManager.setLookAndFeel(new FlatDarculaLaf());
        JFrame jFrame = new JFrame("JMenú Demo");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(550, 550);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();
        jFrame.setJMenuBar(menuBar);


        menuArchivo = new JMenu("Archivo");
        abierto = new JMenuItem("Abrir");
        cerrado = new JMenuItem("Cerrar");

        menuTema = new JMenu("Temas");
        menuFondo = new JMenu("Fondos");
        menuTamaño = new JMenu("Tamaño");

        menuArchivo.add(abierto);
        menuArchivo.addSeparator();
        menuArchivo.add(cerrado);

        menuBar.add(menuArchivo);
        menuBar.add(menuTema);
        menuBar.add(menuFondo);
        menuBar.add(menuTamaño);

        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    //UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
    //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // Del sistema operativo
    //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel"); // Por defecto de Java
    //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel"); // Feo


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new MenuDemo();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
