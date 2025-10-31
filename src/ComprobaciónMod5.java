public class ComprobaciónMod5 {
    public static void main(String[] args) {
        double ejercicioUno[] = new double[10];
        double[] ejercicioUnoUno = new double[10];

        int ejercicioDos[] = {1, 2, 3, 4, 5};

        double ejercicioTres[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double promedio = 0;
        for ( double x: ejercicioTres) {
            promedio += x;
        }
        promedio /= 10;

        String[] ej4str = {"Saludar", "mundo", "adiós", "Angel", "uno", "dos", "millones", "cuatro"};
        String guardarStr;
        for ( int i=0; i<8; i++) {
            for ( int j = 0; j<8; j++) {
                int compare = ej4str[i].compareTo(ej4str[j]);
                if ( ej4str[i].length() < ej4str[j].length() ) {
                    //   Esto es una opción.
                    guardarStr = ej4str[i];
                    ej4str[i] = ej4str[j];
                    ej4str[j] = guardarStr;
                    // Tener cuidado con los métodos String. Algo pasa.
                }
            }
        }
        // Hecho.

        int ej4[] = {1, 3, 5, 7, 2, 4, 6, 9, 8, 0};
        int guardar;
        for ( int i=0; i<10; i++) {
            for ( int j = 0; j<10; j++) {
                if ( ej4[i] < ej4[j] ) {
                    guardar = ej4[i];
                    ej4[i] = ej4[j];
                    ej4[j] = guardar;
                }
            }
        }

//        for ( int i = 0; i<8; i++) {
//            System.out.print(ej4str[i] + " ");
//        }
        String ejercicio_seis = "Me gusta java.";
        //System.out.println(ejercicio_seis.length() + " " + ejercicio_seis.charAt(0));

        int x = 5;
        int y;
        y = x<0 ? 10 : 20;
        //System.out.println(y);

        int[] nums = { 99, -10, 100123, 18, -978, 5623, 463, -9, 287, 49 };
        int min, max;
        min = max = nums[0];
        for ( int z: nums) {
            min = min>z ? z : min; //Esto es innecesario, ya que el operador ternario necesita un "else" y aquí no hace falta.
            max = max<z ? z : max;
        }
        //System.out.println(min + " " + max);


    }
}
