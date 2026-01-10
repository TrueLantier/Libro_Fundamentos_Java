package Mod9Excepciones;

public class Ejemplos {
    public static void main(String[] args) {
        int[] nums = new int[4];
        int[] numer = {4, 8, 16, 32, 64, 128};
        int[] denom = {2, 0, 4, 4, 0, 8};

        try {
            System.out.println("Antes de que se genere la excepción 1.");
            nums[7] = 10;
            System.out.println("Esto no se muestra.");
        } catch (Exception e) {
            System.out.println("Índice fuera de límite. Excepción 1");
        }

        try {
            ExceptionPrueba.genExc();
        } catch (ArrayIndexOutOfBoundsException exc) {
            System.out.println("Índice fuera de límites. Excepción 2.");
        }

        System.out.println("Antes de la excepción 3.");
        for (int i = 0; i < numer.length; i++) {
            try {
                System.out.println(numer[i] + " / " + denom[i] + " es " + numer[i] / denom[i]);
            } catch (ArithmeticException exc) {
                System.out.println("No se puede dividir entre 0.");
            } catch (ArrayIndexOutOfBoundsException exc) {
                System.out.println("Índice fuera de límites.");
            }
        }

    }
}

class ExceptionPrueba {
    static void genExc() {
        int[] nums = new int[4];
        System.out.println("Antes de la excepción 2.");
        nums[7] = 10;
        System.out.println("Esto no se muestra.");
    }
}
