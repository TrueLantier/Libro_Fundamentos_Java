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
            //System.out.println("\nRastreo de pila: ");
            //exc.printStackTrace();
        }

        System.out.println();
        for (int i = 0; i < 3; i++) {
            UsoFinally.genExc(i);
            System.out.println();
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

class UsoFinally {
    public static void genExc(int number) {
        int t;
        int[] nums2 = new int[2];

        System.out.println("Recibiendo " + number);
        try {
            switch (number) {
                case 0:
                    t = 10 / number;
                    break;
                case 1:
                    nums2[4] = 4;
                    break;
                case 2:
                    return;
            }
        } catch (ArithmeticException exc) {
            System.out.println("No se puede dividir entre cero.");
            return;
        } catch (ArrayIndexOutOfBoundsException exc) {
            System.out.println("No hay elemento coincidente.");
        } finally {
            System.out.println("Dejando try.");
        }
    }
}