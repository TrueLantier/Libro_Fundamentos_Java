package SwingMod17;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;

public class JListDemo implements ListSelectionListener, ActionListener {
    JList<String> jList;
    JLabel jLabel, jLabel2;
    JButton jbtn;
    JScrollPane jscrlp;
    int idx;

    String[] nombres = {"Angel", "Eduardo", "Talía", "Beatriz", "Kamila", "Patricia", "Alejandra",
    "Yordanska", "Tania"};
    JListDemo() throws Exception {
        UIManager.setLookAndFeel(new FlatMacDarkLaf());
        //UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // Del sistema operativo
        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel"); // Feo
        JFrame jFrame = new JFrame("JList Demo");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(220, 200);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jList = new JList<String>(nombres);
        // Selección por defecto:
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jscrlp = new JScrollPane(jList);
        jscrlp.setPreferredSize(new Dimension(120, 90));

        jLabel = new JLabel("Por favor elija un nombre: ");
        jLabel2 = new JLabel("Índice: ");

        jbtn = new JButton("Deseleccionar");
        jbtn.addActionListener(this);

        jList.addListSelectionListener(this);

        jFrame.add(jscrlp);
        jFrame.add(jLabel);
        jFrame.add(jLabel2);
        jFrame.add(jbtn);

        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    @Override
    public void valueChanged(ListSelectionEvent ls) {
        idx = jList.getSelectedIndex();

        if (idx != -1) {
            jLabel.setText("Selección actual: " + nombres[idx]);
            jLabel2.setText("Índice: " + idx);
        }   else {
            jLabel.setText("Por favor elige un nombre");
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        jList.clearSelection(); // Deseleccionar los elementos.
        jLabel2.setText("Índice: " + idx);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new JListDemo();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
