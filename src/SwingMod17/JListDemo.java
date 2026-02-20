package SwingMod17;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;

public class JListDemo implements ListSelectionListener{
    JList<String> jList;
    JLabel jLabel, jLabel2;
    JScrollPane jscrlp;

    String[] nombres = {"Angel", "Eduardo", "Talía", "Beatriz", "Kamila", "Patricia", "Alejandra",
    "Yordanska", "Tania"};
    JListDemo() {
        JFrame jFrame = new JFrame("JList Demo");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(200, 180);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jList = new JList<String>(nombres);
        // Selección por defecto:
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jscrlp = new JScrollPane(jList);
        jscrlp.setPreferredSize(new Dimension(120, 90));

        jLabel = new JLabel("Por favor elija un nombre: ");
        jLabel2 = new JLabel("Índice: ");

        jList.addListSelectionListener(this);

        jFrame.add(jscrlp);
        jFrame.add(jLabel);
        jFrame.add(jLabel2);

        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    @Override
    public void valueChanged(ListSelectionEvent ls) {
        int idx = jList.getSelectedIndex();

        if (idx != -1) {
            jLabel.setText("Selección actual: " + nombres[idx]);
            jLabel2.setText("Índice: " + idx);
        }   else {
            jLabel.setText("Por favor elige un nombre");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JListDemo();
            }
        });
    }
}
