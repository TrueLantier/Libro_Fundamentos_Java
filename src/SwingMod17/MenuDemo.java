package SwingMod17;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import com.formdev.flatlaf.*;
import com.formdev.flatlaf.themes.*;

/*
Quiero hacer una clase que mezcle distintas cosas de Swing. Menús, temas, fondos, labels de imágenes, iconos.
 */

public class MenuDemo implements ActionListener{
    JMenuBar menuBar;
    JMenu menuArchivo, menuTema, menuFondo, menuTamaño;
    JMenuItem abierto, cerrado, temaNimbus, temaLocal, temaMetal, temaMotif, temaFMacLight, temaFMacDark,
            temaFDark, temaFLight, temaFIntelliJ, temaFDarcula;
    JMenuItem[] temas = { temaNimbus, temaLocal, temaMetal, temaMotif, temaFMacLight, temaFMacDark,
            temaFDark, temaFLight, temaFIntelliJ, temaFDarcula};
    String[] nombresTemas = { "Nimbus", "Local", "Metal", "Motif", "MacLight", "MacDark",
            "Dark", "Light", "IntelliJ", "Darcula" };
    JLabel labelUno, labelDos, labelTextoUno, labelTextoDos;
    JButton btnUno, btnDos;

    MenuDemo() throws Exception{
        UIManager.setLookAndFeel(new FlatMacDarkLaf());
        JFrame jFrame = new JFrame("JMenú Demo");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(600, 600);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        menuBar = new JMenuBar();
        jFrame.setJMenuBar(menuBar);

        ImageIcon imagen = new ImageIcon("src/SwingMod17/Images/coca-cola.png");
        Image imagenEscalada = imagen.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon imagenUno = new ImageIcon(imagenEscalada);
        btnUno = new JButton(imagenUno);
        labelUno = new JLabel(imagenUno);
        labelTextoUno = new JLabel("Coca-Cola", imagenUno, SwingConstants.CENTER);
        /*
        Hay que agregarlo al JFrame. Y mejorarlo.
         */

        ImageIcon imagen2 = new ImageIcon("src/SwingMod17/Images/icono1.jpeg");
        Image imagenEscaladaDos = imagen2.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon imagenDos = new ImageIcon(imagenEscaladaDos);
        btnDos = new JButton(imagenDos);
        labelDos = new JLabel(imagenDos);



        menuArchivo = new JMenu("Archivo");
        Image imagenEscaladaIcono = imagen2.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon icono = new ImageIcon(imagenEscaladaIcono);
        menuArchivo.setIcon(icono);
        abierto = new JMenuItem("Abrir");
        cerrado = new JMenuItem("Cerrar");
        menuArchivo.add(abierto);
        menuArchivo.addSeparator();
        menuArchivo.add(cerrado);

        menuTema = new JMenu("Temas");
        for (int i = 0; i < nombresTemas.length; i++) {
            temas[i] = new JMenuItem(nombresTemas[i]);
            menuTema.add(temas[i]);
        }


        menuFondo = new JMenu("Fondos");
        menuTamaño = new JMenu("Tamaño");



        menuBar.add(menuArchivo);
        menuBar.add(menuTema);
        menuBar.add(menuFondo);
        menuBar.add(menuTamaño);

        jFrame.add(btnUno);
        jFrame.add(labelUno);
        jFrame.add(btnDos);
        jFrame.add(labelDos);
        jFrame.setIconImage(imagenEscaladaIcono);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

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
