package Mod9Excepciones;

public class EjemplosDos {
    public static void main(String[] args) {
        int[] numer = {4, 8, 16, 32, 64, 128};
        int[] denom = {2, 0, 4, 4, 0, 8};

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
