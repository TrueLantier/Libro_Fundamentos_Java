package IOMod10.CharacterStreams;
import java.io.*;

public class PrintWriterDemo {
    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out, true);
        int i = 10;
        double d = 123.65;

        pw.println("Usando PrintWriter");
        pw.println(i);
        pw.println(d);
        pw.println(i + " + " + d + " = " + (i+d));
        pw.print("a");
    }
}
