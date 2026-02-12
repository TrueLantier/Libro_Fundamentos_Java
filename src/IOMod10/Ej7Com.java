package IOMod10;
import java.io.*;

public class Ej7Com {
    public static void main(String[] args) {
        String ruta  = "src/IOMod10/Ejercicios.txt";
        String msj = "";
        int i = 0;

        try (FileInputStream fis = new FileInputStream(ruta)){
            while (true) {
                i = fis.read();
                if (i == -1) break;
                String actual = String.valueOf((char) i);
                if (actual.equals(" ")) actual = "-";
                msj += actual;
            }
        }   catch (IOException e) {
            System.out.println("Error de E/S: " + e);
        }

        System.out.println(msj);
    }
}
