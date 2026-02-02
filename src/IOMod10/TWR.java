package IOMod10;
import java.io.*;

public class TWR {
    public static void main(String[] args) {
        int i;

        if (args.length != 2) {
            System.out.println("Uso: CopyFile desde hasta");
            return;
        }

        try (FileInputStream fin = new FileInputStream(args[0]);
             FileOutputStream fout = new FileOutputStream(args[1])){
            do {
                i = fin.read();
                if (i != -1) fout.write(i);
            }   while (i != -1);
        }   catch (IOException exc) {
            System.out.println("Error de E/S: " + exc);
        }
    }
}
