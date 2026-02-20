package SwingMod17;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class SwingFC implements ActionListener{
    JTextField jtfFirst;
    JTextField jtfSecond;
    JButton jbtnComp;
    JLabel jlabFirst;
    JLabel jlabSecond;
    JLabel jlabResult;

    SwingFC() {
        JFrame jFrame = new JFrame("Comparación de archivos");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(200, 190);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jtfFirst = new JTextField(14);
        jtfSecond = new JTextField(14);
        jtfFirst.setActionCommand("ArchivoA");
        jtfSecond.setActionCommand("ArchivoB");

        jbtnComp = new JButton("Comparar");
        jbtnComp.addActionListener(this);

        jlabFirst = new JLabel("Primer archivo");
        jlabSecond = new JLabel("Segundo archivo");
        jlabResult = new JLabel("");

        jFrame.add(jlabFirst);
        jFrame.add(jtfFirst);
        jFrame.add(jlabSecond);
        jFrame.add(jtfSecond);
        jFrame.add(jbtnComp);
        jFrame.add(jlabResult);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int i=0, j=0;

        if (jtfFirst.getText().equals("")) {
            jlabResult.setText("Nombre del primer archivo falta.");
            return;
        }
        if (jtfSecond.getText().equals("")) {
            jlabResult.setText("Nombre del segundo archivo falta.");
            return;
        }

        try (FileInputStream f1 = new FileInputStream(jtfFirst.getText());
             FileInputStream f2 = new FileInputStream(jtfSecond.getText())){

            do {
                i = f1.read();
                j = f2.read();
                if (i != j) {
                    jlabResult.setText("Los archivos no son iguales.");
                    break;
                }
            }   while (i != -1 && j != -1);
            jlabResult.setText("Los archivos son iguales.");
        }   catch (IOException exc) {
            jlabResult.setText("Error de archivos.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingFC();
            }
        });
    }
}
