package IOMod10.CharacterStreams;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class ReadLines {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new
                InputStreamReader(System.in, StandardCharsets.UTF_8));
        String str;

        System.out.println("Introduce líneas de texto.");
        System.out.println("Introduce 'stop' para terminar.");
        do {
            str = br.readLine();
            System.out.println(str);
        }   while (!str.equals("stop"));
    }
}
