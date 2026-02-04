package IOMod10.ByteStreams;
import java.io.*;

//Utilidad: Comparación de archivos.
public class ComparaciónArchivos {
    public static void main(String[] args) {
        int i = 0, j = 0;

        if (args.length != 2) {
            System.out.println("Uso: ComparaciónArchivos f1 f2");
            return;
        }

        try (FileInputStream f1 = new FileInputStream(args[0]);
             FileInputStream f2 = new FileInputStream(args[1])){

            do {
                i = f1.read();
                j = f2.read();
            }   while (i != -1 && j != -1);

            if (i != j) {
                System.out.println("Archivos diferentes.");
                System.out.println(j);
            }   else {
                System.out.println("Archivos iguales");
            }
        }   catch (IOException exc) {
            System.out.println("Error de E/S: " + exc);
        }
    }
}
