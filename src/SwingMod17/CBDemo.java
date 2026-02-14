package SwingMod17;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CBDemo implements ItemListener{
    JLabel jLabelSelected;
    JLabel jLabelChanged;
    JCheckBox jcbAlpha;
    JCheckBox jcbBeta;
    JCheckBox jcbGamma;

    CBDemo() {
        JFrame jFrame = new JFrame("Demostración de CheckBox.");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(280, 120);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jLabelSelected = new JLabel("");
        jLabelChanged = new JLabel("");

        jcbAlpha = new JCheckBox("Alpha");
        jcbBeta = new JCheckBox("Beta");
        jcbGamma = new JCheckBox("Gamma");

        jcbAlpha.addItemListener(this);
        jcbBeta.addItemListener(this);
        jcbGamma.addItemListener(this);

        jFrame.add(jcbAlpha);
        jFrame.add(jcbBeta);
        jFrame.add(jcbGamma);
        jFrame.add(jLabelChanged);
        jFrame.add(jLabelSelected);

        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        String str = "";
        JCheckBox cb = (JCheckBox) ie.getItem();

        if (cb.isSelected()) {
            jLabelChanged.setText(cb.getText() + " ha sido seleccionado.");
        }   else {
            jLabelSelected.setText(cb.getText() + " ha sido limpiado.");
        }

        if (jcbAlpha.isSelected()) {
            str += "Alpha ";
        }
        if (jcbBeta.isSelected()) {
            str += "Beta ";
        }
        if (jcbGamma.isSelected()) {
            str += "Gamma ";
        }

        jLabelSelected.setText("Check Box seleccionado: " + str);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CBDemo();
            }
        });
    }
}
