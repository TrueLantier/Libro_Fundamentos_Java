package IOMod10.CharacterStreams;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class AvgNums {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in), StandardCharsets.UTF_8));
        String str;
        int n;
        double sum = 0.0;
        double avg, t;

        System.out.println("¿Cuántos números ingresarás?");
        str = br.readLine();
        try {
            n = Integer.parseInt(str);
        }   catch (NumberFormatException e) {
            System.out.println("Formato inválido.");
            n = 0;
        }

        System.out.println("Ingresa " + n + " valores.");
        for (int i = 0; i < n; i++) {
            System.out.println(": ");
            str = br.readLine();
            try {
                t = Double.parseDouble(str);
            } catch (NumberFormatException e) {
                System.out.println("Formato inválido");
                t = 0.0;
            }
            sum += t;
        }
        avg = sum / n;
        System.out.println("El promedio es: " + avg);
    }
}
