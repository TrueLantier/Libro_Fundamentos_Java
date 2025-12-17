class Cola {
    private char q[];
    private int colocar_lugar, obtener_lugar;
    Cola( int dimen) {
        q = new char[dimen+1];
        colocar_lugar = obtener_lugar = 0;
    }
    Cola(Cola ob) {
        colocar_lugar = ob.colocar_lugar;
        obtener_lugar = ob.obtener_lugar;
        q = new char[ob.q.length];

        for (int i = obtener_lugar + 1; i <= colocar_lugar; i++) {
            q[i] = ob.q[i];
        }
    }
    Cola(char[] c) {
        colocar_lugar = 0;
        obtener_lugar = 0;
        q = new char[c.length+1];
        for (int i = 0; i < c.length; i++) colocar(c[i]);
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
}

public class ClaseCola {
    public static void main(String[] args) {
        Cola q1 = new Cola(10);

        char[] nombre = {'A', 'N', 'G', 'E', 'L'};
        Cola q2 = new Cola(nombre);

        char ch;
        int i; // Esto es porque voy a usar varias veces estas variables

        for (i = 0; i < 10; i++) {
            q1.colocar((char) ('A' + i));
        }
        Cola q3 = new Cola(q1);

        for (i = 0; i < 5; i++) {
            System.out.print(q1.obtener());
        }
        System.out.println();

        for (i = 0; i < 5; i++) {
            System.out.print(q2.obtener());
        }
        System.out.println();

        for (i = 0; i < 10; i++) {
            System.out.print(q3.obtener());
        }
    }
}