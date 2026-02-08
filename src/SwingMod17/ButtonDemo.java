package SwingMod17;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonDemo implements ActionListener{
    JLabel jLabel;

    ButtonDemo() {
        JFrame jFrame = new JFrame("Ejemplo Botón");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(220, 90);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jLabel = new JLabel("Press a button.");

        JButton jbUp = new JButton("Up");
        JButton jbDown = new JButton("Down");

        //Add action listeners.
        jbUp.addActionListener(this);
        jbDown.addActionListener(this);
        // jbUp.removeActionListener(this); // Para remover

        jFrame.add(jbUp);
        jFrame.add(jbDown);
        jFrame.add(jLabel);
        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Up")) {
            jLabel.setText("You pressed Up.");
        }   else {
            jLabel.setText("You pressed Down.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ButtonDemo();
            }
        });
    }
}
