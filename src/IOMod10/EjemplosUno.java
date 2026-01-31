package IOMod10;
import EstructurasDatosAlgoritmos.*;
import java.io.IOException;

public class EjemplosUno {

    public static void main(String[] args) throws IOException {
        byte[] datos = new byte[5];
        System.out.println("Escriba algunos caracteres.");
        System.in.read(datos);
        System.out.println("Usted escribió: ");
        for (int i = 0; i < 5; i++) {
            System.out.print((char) datos[i]);
        }
//        System.in.read();
//        System.out.println();
//        int b;
//        b = 'X';
//        System.out.write(b);
//        System.out.write('\n');
    }
}