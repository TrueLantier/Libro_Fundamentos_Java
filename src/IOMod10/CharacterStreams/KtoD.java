package IOMod10.CharacterStreams;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class KtoD {
    public static void main(String[] args) {
        String str;
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in), StandardCharsets.UTF_8));
        String ruta = "/home/angel/Documentos/ESCUELA/LibroFundamentosJava/src/IOMod10/CharacterStreams/text.txt";
        String ruta2 = "prueba.txt";

        System.out.println("Introduce texto, 'stop' para terminar.");
        try (FileWriter fw = new FileWriter(ruta)){
            do {
                System.out.println(": ");
                str = br.readLine();
                if (str.compareTo("stop") == 0) break;
                str = str + "\r\n";
                fw.write(str);
            }   while (str.compareTo("stop") != 0);

        }   catch (IOException e) {
            System.out.println("Error de E/S: " + e);
        }
    }
}
