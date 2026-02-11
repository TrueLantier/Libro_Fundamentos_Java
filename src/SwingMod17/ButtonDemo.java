package SwingMod17;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonDemo implements ActionListener{
    JLabel jLabel;

    ButtonDemo() {
        JFrame jFrame = new JFrame("Ejemplo Botón");
        jFrame.setLayout(new FlowLayout()); // Coloca los componentes en fila.
        jFrame.setSize(450, 450);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jLabel = new JLabel("Press a button.");

        /*
        ImageIcon imagen = new ImageIcon("src/SwingMod17/icono1.jpeg");
        JLabel jLabel2 = new JLabel(imagen);
        jFrame.add(jLabel2);
         */

        JButton jbUp = new JButton("Up");
        JButton jbDown = new JButton("Down");

        //Add action listeners.
        jbUp.addActionListener(this);
        jbDown.addActionListener(this);
        // jbUp.removeActionListener(this); // Para remover

        jFrame.add(jbUp);
        jFrame.add(jbDown);
        jFrame.add(jLabel);

        jFrame.setLocationRelativeTo(null); // Para que la GUI aparezca en el medio.
        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Up")) { // texto del botón
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
