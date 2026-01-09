package Mod9Excepciones;
import java.lang.ArrayIndexOutOfBoundsException;

public class Ejemplos {
    public static void main(String[] args) {
        int[] nums = new int[4];

        try {
            System.out.println("Antes de que se genere la excepción.");
            nums[7] = 10;
            System.out.println("Esto no se muestra.");
        } catch (Exception e) {
            System.out.println("Índice fuera de límite.");
        }
        System.out.println("Tras el catch");
    }
}

class ExceptionPrueba {
    static void genExc() {
        int[] nums = new int[4];
        System.out.println("Antes de la excepción.");
    }
}
