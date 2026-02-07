package IOMod10.CharacterStreams;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class ReadChars {
    public static void main(String[] args) throws IOException{
        char c;
        EFC buffer = new EFC();

        /*
        Cuando trabaje por consola:
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in, System.console().charset()));
         */
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in)); // Mal, no especificar Charset.
        BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8)); // Bien.

        System.out.println("Introduce caracteres, punto para terminar");
        do {
            // c = (char) br3.read(); // Factible
            c = (char) buffer.efcBR2.read();
            System.out.println(c);
        }   while (c != '.');

        buffer.efcBR2.close();
        br2.close();
        br3.close();
    }
}