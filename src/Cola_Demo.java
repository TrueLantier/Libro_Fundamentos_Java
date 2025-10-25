class Cola {
    char q[];
    int colocar_lugar, obtener_lugar;
    Cola( int dimen) {
        q = new char[dimen+1];
        colocar_lugar = obtener_lugar = 0;
    }
    void colocar( char ch) {
        if (colocar_lugar == q.length-1 ) {
            System.out.println(" -- La cola se ha llenado.");
            return;
        }
        colocar_lugar++;
        q[colocar_lugar] = ch;
    }
    char obtener() {
        if ( obtener_lugar==colocar_lugar ) {
            System.out.println(" -- La cola se ha vaciado.");
            return (char) 0;
        }
        obtener_lugar++;
        return q[obtener_lugar];
    }
    void reiniciar_cola() {
        colocar_lugar = obtener_lugar = 0;
    }
}

public class Cola_Demo {
    public static void main(String[] args) {
        Cola colaGrande = new Cola(100);
        Cola colaPeque = new Cola(5);
        // System.out.println(colaGrande[2]);   Interesante, esto da error. Array type expected; found: Cola.
        char ch;
        int i;

        /*System.out.println("Uso de colaGrande para almacenar alfabeto.");
        for ( i=0; i<26; i++)
            colaGrande.colocar( (char) ('A' + i ));

        System.out.print("Contenido de colaGrande: ");
        for ( i=0; i<26; i++) {
            ch = colaGrande.obtener();
            if ( ch != (char) 0) System.out.print(ch);
        }
        System.out.println("\n");*/

        System.out.println("Uso de colaPeque para generar errores.");
        for ( i=0; i<6; i++) {
            System.out.print("Intento almacenar " + (char) ('Z' - i));
            colaPeque.colocar( (char) ( 'Z' - i ));
            System.out.println();
        }

        System.out.print("Contenido de colaPeque: ");
        for ( i= 0; i<6; i++) {
            ch = colaPeque.obtener();
            if ( ch != (char) 0) System.out.print(ch);
        }
    }
}