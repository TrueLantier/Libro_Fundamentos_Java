package Mod9Excepciones;

public class MiExcepción {
    public static void main(String[] args) {
        int[] numer = {4, 8, 15, 32, 64, 127, 256, 512};
        int[] denom = {2, 0, 4, 4, 0, 8};
        for (int i = 0; i < numer.length; i++) {
            try {
                if (numer[i]%2 != 0) {
                    throw new
                            NonIntResultException(numer[i], denom[i]);
                }
                System.out.println(numer[i] + " / " + denom[i] + " es " + numer[i] / denom[i]);
            } catch (ArithmeticException exc) {
                System.out.println("No se puede dividir entre cero.");
            } catch (ArrayIndexOutOfBoundsException exc) {
                System.out.println("No hay elemento coincidente.");
            } catch (NonIntResultException exc) {
                System.out.println(exc);
            }
        }
    }
}

class NonIntResultException extends Exception {
    int n;
    int d;

    NonIntResultException(int i, int j) {
        n = i;
        d = j;
    }

    @Override
    public String toString() {
        return "El resultado de " + n + " / " + d + " no es un entero.";
    }
}