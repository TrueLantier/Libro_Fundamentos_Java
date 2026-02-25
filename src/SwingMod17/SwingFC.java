package SwingMod17;
import com.formdev.flatlaf.FlatDarkLaf;

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
    JLabel jlabDiscrepancia;
    JCheckBox jckb;
    String discrepancia;
    int posición;

    SwingFC() throws Exception{
        UIManager.setLookAndFeel(new FlatDarkLaf());
        //UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // Del sistema operativo
        //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel"); // Por defecto de Java
        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel"); // Feo

        JFrame jFrame = new JFrame("Comparación de archivos");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(260, 280);
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
        jlabDiscrepancia = new JLabel("");

        jckb = new JCheckBox("Mostrar la posición de la discrepancia.");
        //jckb.addItemListener(this);
        /**
         * IMPORTANTE
         */

        jFrame.add(jlabFirst);
        jFrame.add(jtfFirst);
        jFrame.add(jlabSecond);
        jFrame.add(jtfSecond);
        jFrame.add(jbtnComp);
        jFrame.add(jlabResult);
        jFrame.add(jckb);
        jFrame.add(jlabDiscrepancia);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int i=0, j=0;
        posición = 0;

        if (jtfFirst.getText().isEmpty()) {
            jlabResult.setText("Nombre del primer archivo falta.");
            return;
        }
        if (jtfSecond.getText().isEmpty()) {
            jlabResult.setText("Nombre del segundo archivo falta.");
            return;
        }

        try (FileInputStream f1 = new FileInputStream(jtfFirst.getText());
             FileInputStream f2 = new FileInputStream(jtfSecond.getText())){

            do {
                i = f1.read();
                j = f2.read();
                if (i != j) {
                    discrepancia = String.valueOf((char) i);
                    break;
                }
                posición += 1;
            }   while (i != -1);

            if (jckb.isSelected()) {
                if (discrepancia != null) {
                    jlabDiscrepancia.setText("Hay un error: " + discrepancia + " posición: " + posición);
                }
            }   else {
                jlabDiscrepancia.setText("");
            }

            if (i != j)
                jlabResult.setText("Los archivos no son iguales.");
            else
                jlabResult.setText("Los archivos son iguales.");
        }   catch (IOException exc) {
            jlabResult.setText("Error de archivos.");
        }
    }

//    @Override
//    public void itemStateChanged(ItemEvent ie) {
//        if (jckb.isSelected()) {
//            if (discrepancia != null) {
//                jlabDiscrepancia.setText("Hay un error: " + discrepancia + " posición: " + posición);
//            }
//        }   else {
//            jlabDiscrepancia.setText("");
//        }
//    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new SwingFC();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
