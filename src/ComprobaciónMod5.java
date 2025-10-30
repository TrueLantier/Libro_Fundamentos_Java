public class ComprobaciónMod5 {
    public static void main(String[] args) {
        double ejercicioUno[] = new double[10];
        double[] ejrcicioUnoUno = new double[10];

        int ejercicioDos[] = {1, 2, 3, 4, 5};

        double ejercicioTres[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double promedio = 0;
        for ( double x: ejercicioTres) {
            promedio += x;
        }
        promedio /= 10;

        String[] ej4str = {"hola", "mundo", "adiós", "Angel", "uno", "dos", "millones", "cuatro"};

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

        for ( int i = 0; i<10; i++) {
            System.out.print(ej4[i] + " ");
        }
    }
}
