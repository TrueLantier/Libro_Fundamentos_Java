package Mod9Excepciones;

public class EjemplosDos {
    public static void main(String[] args) {
        int[] numer = {4, 8, 16, 32, 64, 128, 256, 512};
        int[] denom = {2, 0, 4, 4, 0, 8};

        try {
            for (int i = 0; i < numer.length; i++) {
                try {
                    System.out.println(numer[i] + " / " + denom[i] + " es " + numer[i] / denom[i]);
                } catch (ArithmeticException exc) {
                    System.out.println("No se puede dividir entre 0.");
                }
            }
        } catch (ArrayIndexOutOfBoundsException exc) {
            System.out.println("No hay elemento coincidente.");
            System.out.println("Error fatal. Programa terminado.");
        }

        try {
            System.out.println("Antes del lanzamiento.");
            throw new ArithmeticException();
        } catch (ArithmeticException e) {
            System.out.println("Excepción capturada.");
            throw e;
        }
    }
}
