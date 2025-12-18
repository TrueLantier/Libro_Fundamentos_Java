class Pila{
    private char[] q;
    private int lugar;

    Pila(int dimen) {
        q = new char[dimen+1];
        lugar = 0;
    }
    Pila(Pila ob) {
        q = new char[ob.q.length]; //ob.q;
        lugar = ob.lugar;
        for (int i = 1; i <= lugar; i++) {
            q[i] = ob.q[i];
        }
    }
    Pila(char[] a) {
        q = new char[a.length+1];
        for (char c : a) poner(c);
    }

    void poner(char a) {
        ++lugar;
        if (lugar == q.length) {
            System.out.println(" -- La pila se ha llenado.");
            --lugar;
            return;
        }
        q[lugar] = a;
    }
    char quitar() {
        if (lugar == 0) {
            System.out.println(" -- La pila se ha vaciado.");
            return (char) 0;
        }
        --lugar;
        return q[lugar+1];
    }
}

public class ClasePila {
    public static void main(String[] args) {
        Pila op = new Pila(5);

        char[] nombre = { 'A', 'N', 'G', 'E', 'L'};
        Pila op3 = new Pila(nombre);

        for (int i = 0; i < 5; i++) {
            op.poner( (char) ('A' + i));
        }
        Pila op2 = new Pila(op);

        for (int i = 0; i < 5; i++) {
            System.out.print( op.quitar() );
        }
        System.out.println();

        for (int i = 0; i < 5; i++) {
            System.out.print( op3.quitar() );
        }
        System.out.println();

        for (int i = 0; i < 5; i++) {
            System.out.print( op2.quitar() );
        }
    }
}
