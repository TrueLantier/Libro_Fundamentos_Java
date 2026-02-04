package IOMod10;
import java.io.*;

public class RWData {
    public static void main(String[] args) {
        int i = 10;
        double d = 1023.56;
        boolean b = true;

        try (DataOutputStream dataOut = new DataOutputStream(new FileOutputStream("testdata"))){
            System.out.println("Escribiendo " + i);
            dataOut.writeInt(i);

            System.out.println("Escribiendo " + d);
            dataOut.writeDouble(d);

            System.out.println("Escribiendo " + b);
            dataOut.writeBoolean(b);

            System.out.println("Escribiendo " + 12.2 * 7.4);
            dataOut.writeDouble(12.2 * 7.4);
        }   catch (IOException exc) {
            System.out.println("Error de escritura.");
            return;
        }

        System.out.println();

        try (DataInputStream dataIn = new DataInputStream(new FileInputStream("testdata"))){
            i = dataIn.readInt();
            System.out.println("Leyendo " + i);

            d = dataIn.readDouble();
            System.out.println("Leyendo " + d);

            b = dataIn.readBoolean();
            System.out.println("Leyendo" + b);

            d = dataIn.readDouble();
            System.out.println("Leyendo " + d);
        } catch (Exception exc) {
            System.out.println("Error de lectura.");
        }
    }
}
