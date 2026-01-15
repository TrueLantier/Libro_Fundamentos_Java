package EstructurasDatosAlgoritmos;

class ColaFija implements ICCHAR {
    private char[] q;
    private int putloc, getloc;

    ColaFija(int dim) {
        q = new char[dim+1];
        putloc = getloc = 0;
    }

    @Override
    public void put(char ch) throws ColaLlenaExcepción {
        if (putloc == q.length-1) {
            throw new ColaLlenaExcepción(q.length-1);
        }

        ++putloc;
        q[putloc] = ch;
    }
    @Override
    public char get() throws ColaVacíaExcepción{
        if (getloc == putloc) {
            throw new ColaVacíaExcepción();
        }

        ++getloc;
        return q[getloc];
    }
    @Override
    public void reset() { getloc = putloc = 0; }
}
class ColaCircular implements ICCHAR{
    private char[] q;
    private int putloc, getloc;

    ColaCircular(int dim) {
        q = new char[dim+1];
        putloc = getloc = 0;
    }

    @Override
    public void put(char ch) throws ColaLlenaExcepción {
        if (putloc+1 == getloc ||  (putloc == q.length-1 && getloc == 0)) {
            throw new ColaLlenaExcepción(q.length-1);
        }

        ++putloc;
        if (putloc == q.length) { putloc = 0; }
        q[putloc] = ch;
    }
    @Override
    public char get() throws ColaVacíaExcepción{
        if (getloc == putloc) {
            throw new ColaVacíaExcepción();
        }

        ++getloc;
        if (getloc == q.length) { getloc = 0; }
        return q[getloc];
    }
    @Override
    public void reset() { getloc = putloc = 0; }
}
class ColaDin implements ICCHAR {
    private char[] q;
    private int putloc, getloc;

    ColaDin(int dim) {
        q = new char[dim];
        putloc = getloc = 0;
    }

    @Override
    public void put(char ch) {
        if (putloc == q.length-1) {
            char[] t = new char[q.length * 2];
            for (int i = 0; i < q.length; i++) {
                t[i] = q[i];
            }
            q = t;
        }

        ++putloc;
        q[putloc] = ch;
    }
    @Override
    public char get() throws ColaVacíaExcepción {
        if (getloc == putloc) {
            throw new ColaVacíaExcepción();
        }

        ++getloc;
        return q[getloc];
    }
    @Override
    public void reset() { getloc = putloc = 0; }
}

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
        for (char value : c) colocar(value);
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
        ColaFija q1 = new ColaFija(10);
        ColaDin q2 = new ColaDin(5);
        ColaCircular q3 = new ColaCircular(10);

        ICCHAR icchar;
        char ch;
        int i;

        try {
            icchar = q1;
            for (i = 0; i < 11; i++) {
                icchar.put((char) ('A' + i));
            }
            System.out.println("Contenido de cola fija");
            for (i = 0; i < 10; i++) {
                ch = icchar.get();
                System.out.print(ch);
            }
            System.out.println();

//            icchar = q2;
//            for (i = 0; i < 10; i++) {
//                icchar.put((char) ('Z' - i));
//            }
//            System.out.println("Contenido de cola dinámica");
//            for (i = 0; i < 10; i++) {
//                ch = icchar.get();
//                System.out.print(ch);
//            }
//            System.out.println();
//
//            icchar = q3;
//            for (i = 0; i < 10; i++) {
//                icchar.put((char) ('A' + i));
//            }
//            System.out.println("Contenido de cola circular");
//            for (i = 0; i < 10; i++) {
//                ch = icchar.get();
//                System.out.print(ch);
//            }
//            System.out.println();
//
//            for (i = 10; i < 20; i++) {
//                icchar.put((char) ('A' + i));
//            }
//            System.out.println("Contenido de cola circular");
//            for (i = 0; i < 10; i++) {
//                ch = icchar.get();
//                System.out.print(ch);
//            }
//            System.out.println();
        } catch (ColaLlenaExcepción | ColaVacíaExcepción e) {
            System.out.println(e);
        }
    }
}