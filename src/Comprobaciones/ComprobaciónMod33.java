package Comprobaciones;

public class ComprobaciónMod33 {
    static String reversa(String cadena) { // Ejercicio 6
        if (cadena.length() == 1) return cadena;
        int d = cadena.length();
        String vacio = "";
        for (int i = 0; i < d - 1; i++) {
            vacio += cadena.charAt(i);
        }
        return cadena.charAt(d-1) + reversa(vacio);
    }

    int suma(int ... v){ // ejercicio 13
        int suma = 0;
        for (int i = 0; i < v.length; i++) {
            suma += v[i];
        }
        return suma;
    }
    public static void main(String[] args) {
        // 1: No, solo se puede acceder a miembros private a través de otros miembros de la misma clase.
        // 2: Anteceder.
        // 5: No, mala sobrecarga de métodos. Solo se diferencian por el tipo devuelto.
        // 7: static . Así todos los miembros podrán Compartir esa variable.
        // 8: Se usa para declarar cosas justo cuando se llama a la clase. Predefinir variables o métodos.
        // A veces una clase requerirá cierta inicialización antes de estar lista para poder crear objetos.
        // 9: Es una clase anidada dentro de otra clase. Puede acceder a los miembros de la clase Exterior
        // pero no al revés.
        // 10: private.
        // 11: Firma del método.
        // 12: Valor.
        // 14: Sí se puede.
        // 15: int met(int i, int ... v) | int met(int ... v).

        System.out.println(reversa("yohagoyogahoy"));
    }
}
