package Mod9Excepciones;

public class EjemploTres {
    public static void main(String[] args) {
        try {
            ExceptionPrueba.genExc();
        } catch (ArrayIndexOutOfBoundsException exc) {
            System.out.println("El mensaje estándar es: ");
            System.out.println(exc);
            System.out.println(exc.getMessage());
            //System.out.println(exc.toString());
            System.out.println("\nRastreo de pila: ");
            exc.printStackTrace();
        }
    }
}

class ExcPrueba {
    static void genExc() {
        int[] nums = new int[4];
        System.out.println("Antes de la excepción.");
        nums[7] = 10;
        System.out.println("Esto no se despliega.");
    }
}