package IOMod10;
import java.io.*;

public class MostrarArchivo {
    public static void main(String[] args) throws IOException{
        int i;
        //String ruta = "/home/angel/Documentos/ESCUELA/LibroFundamentosJava/src/IOMod10/PRUEBA.txt";
        FileInputStream fin = null;
        FileOutputStream fout = null;
        if (args.length != 2) {
            System.out.println("Uso: CopyFile desde hasta");
            return;
        }

        try {
            fin = new FileInputStream(args[0]);
            fout = new FileOutputStream(args[1]);

            do {
                i = fin.read();
                if (i != -1) fout.write(i);
            }   while (i != -1);
        }   catch (FileNotFoundException exc) {
            System.out.println("Archivo no encontrado");
        }   catch (IOException exc) {
            System.out.println("Error leyendo el archivo.");
        }   finally {
            try {
                if (fin != null) fin.close();
            }   catch (IOException exc) {
                System.out.println("Error cerrando el archivo.");
            }
            try {
                if (fout != null) fout.close();
            }   catch (IOException exc) {
                System.out.println("Error cerrando el archivo.");
            }
        }
    }
}
