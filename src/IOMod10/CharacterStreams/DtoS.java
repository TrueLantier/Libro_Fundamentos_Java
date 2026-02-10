package IOMod10.CharacterStreams;
import java.io.BufferedReader;
import java.io.FileReader;

public class DtoS {
    public static void main(String[] args) {
        String s;
        String ruta = "/home/angel/Documentos/ESCUELA/LibroFundamentosJava/src/IOMod10/CharacterStreams/text.txt";
        String ruta2 = "prueba.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(ruta2))) {
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
        } catch (Exception e) {
            System.out.println("Error de E/S: " + e);
        }
    }
}
