package SwingMod17;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class TFDemo implements ActionListener{
    JTextField jtf;
    JButton jbtnRev;
    JLabel jlabPrompt, jlabContents;

    TFDemo() {
        JFrame jfr = new JFrame("Usar un campo de texto.");
        jfr.setLayout(new FlowLayout());
        jfr.setSize(240, 120);
        jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jtf = new JTextField(10); // 10 columnas de ancho.
        jtf.setActionCommand("myTF"); // Funciona igual sin esto pero mejor ponerlo.

        jbtnRev = new JButton("Reverse");

        jtf.addActionListener(this);
        jbtnRev.addActionListener(this);

        jlabPrompt = new JLabel("Texto de entrada");
        jlabContents = new JLabel("");

        jfr.add(jlabPrompt);
        jfr.add(jtf);
        jfr.add(jbtnRev);
        jfr.add(jlabContents);
        jfr.setLocationRelativeTo(null);
        jfr.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Reverse")) {
            // El ActionCommand por defecto del JTextField es lo que hay en el campo de texto.
            String orgStr = jtf.getText();
            String resStr = "";

            for (int i = orgStr.length()-1; i >= 0; i--) {
                resStr += orgStr.charAt(i);
            }
            jtf.setText(resStr);
        }   else {
            jlabContents.setText("Has presionado ENTER. El text es: " + jtf.getText());
        }
        // ae.getSource(); // Retorna el objeto evento.
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TFDemo();
            }
        });
    }
}
