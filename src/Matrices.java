public class Matrices {
    public static void main(String[] args) {
        // IMPORTANTE EJEMPLO de las referencias a objetos por parte de las variables.
        int i;
        int[] num1 = new int[10];
        int[] num2 = new int[10];

        for ( i=0; i<10; i++) {
                num1[i] = i;
        }
        for ( i=0; i<10; i++) {
                num2[i] = -i;
        }

        System.out.print("Esta es num1: ");
        for ( i=0; i<10; i++) {
            System.out.print( num1[i] + " " );
        }
        System.out.println();

        System.out.print("Esta es num2: ");
        for ( i=0; i<10; i++) {
            System.out.print( num2[i] + " " );
        }
        System.out.println();

        num2 = num1;
        System.out.print("Esta es num2 tras asignarse: ");
        for ( i=0; i<10; i++) {
            System.out.print( num2[i] + " " );
        }
        System.out.println();

        num2[3] = 99;

        System.out.print("Esta es num1 tras cambiar mediante num2: ");
        for ( i=0; i<10; i++) {
            System.out.print( num1[i] + " " );
        }
        System.out.println();

        /*int num[] = new int[10];
        int matriz[] = {99, -10, 100123, 18, -978, 5623, 463, -9, 287, 49};
        int guardar;

        for (int i = 0; i<10; i++) {
            for (int j = i+1; j < 10; j++) {
                if ( matriz[i]>matriz[j] ) {
                    guardar = matriz[i];
                    matriz[i] = matriz[j];
                    matriz[j] = guardar;
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(matriz[i] + " " );
        }*/
    }
}
