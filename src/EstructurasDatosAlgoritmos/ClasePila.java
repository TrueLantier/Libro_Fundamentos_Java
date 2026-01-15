package EstructurasDatosAlgoritmos;

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
    Pila(char[] a) throws PilaLlenaExcepción {
        q = new char[a.length+1];
        for (char c : a) poner(c);
    }

    void poner(char a) throws PilaLlenaExcepción {
        ++lugar;
        if (lugar == q.length) {
            --lugar;
            throw new PilaLlenaExcepción(q.length-1);
        }
        q[lugar] = a;
    }
    char quitar() throws PilaVacíaExcepción {
        if (lugar == 0) {
            throw new PilaVacíaExcepción();
        }
        --lugar;
        return q[lugar+1];
    }
}

public class ClasePila {
    public static void main(String[] args) throws PilaLlenaExcepción {
        Pila op = new Pila(5);

        char[] nombre = { 'A', 'N', 'G', 'E', 'L'};
        Pila op3 = new Pila(nombre);

        try {
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
        } catch (PilaLlenaExcepción | PilaVacíaExcepción e) {
            System.out.println(e);
        }
    }
}
