package IOMod10.ByteStreams.RandomAccess;
import java.io.*;

public class RandomAccessDemo {
    public static void main(String[] args) {
        double[] data = { 19.4, 10.1, 123.54, 33.0, 87.9, 7425 };
        double d;

        try (RandomAccessFile raf = new RandomAccessFile("random.dat", "rw")){
            for (int i = 0; i < data.length; i++) {
                raf.writeDouble(data[i]);
            }

            raf.seek(0);
            d = raf.readDouble();
            System.out.println("Primer valor es: " + d);

            raf.seek(8);
            d = raf.readDouble();
            System.out.println("Segundo valor es: " + d);

            raf.seek(8*3);
            d = raf.readDouble();
            System.out.println("Cuarto valor es: " + d);

            System.out.println();

            System.out.println("Aquí esta cada otro valor.");

        }   catch (IOException exc) {
            System.out.println("Error de E/S: " + exc);
        }
    }
}
