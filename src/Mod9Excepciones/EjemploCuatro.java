package Mod9Excepciones;
import java.io.IOException;

public class EjemploCuatro {
    public static void main(String[] args) {
        char ch;

        try {
            ch = aviso("Escriba una letra");
        } catch (IOException exc) {
            System.out.println("Ocurrió una excepción de E/S.");
            ch = 'X';
        }

        System.out.println("Usted oprimió " + ch);
    }

    public static char aviso(String cad) throws IOException {
        System.out.println(cad + ": ");
        return (char) System.in.read();
    }
}

