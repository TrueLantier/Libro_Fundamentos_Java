package IOMod10;
import java.io.*;

public class TWRMejorado {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("TWRMejorado.");
            System.out.println("Ejemplo: copia Origen.txt Destino.txt");
        }

        String origen = args[0];
        String destino = args[1];

        File archivoOrigen = new File(origen);
        if (!archivoOrigen.exists()) {
            System.out.println("ERROR: El archivo '" + origen + "' no existe.");
        }

        File archivoDestino = new File(destino);

        try (FileInputStream fin = new FileInputStream(origen);
             FileOutputStream fout = new FileOutputStream(destino)){

            System.out.println("Copiando: " + origen + " --> " + destino);

            byte[] buffer = new byte[8192];
            int bytesLeidos;
            long totalBytes = 0;

            while ((bytesLeidos = fin.read(buffer)) != -1) {
                fout.write(buffer, 0, bytesLeidos);
                totalBytes += bytesLeidos;
            }

            System.out.println("Copia completada: " + totalBytes + " bytes");

        }   catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado - " + e.getMessage());
        }   catch (SecurityException e) {
            System.out.println("Error de permisos: " + e.getMessage());
        }   catch (IOException e) {
            System.out.println("Error durante la copia: " + e.getMessage());
            archivoDestino.delete();
        }
    }
}
