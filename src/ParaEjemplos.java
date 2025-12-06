class Bloque {
    int a, b, c;
    int volumen;

    Bloque(int i, int j, int k) {
        a = i;
        b = j;
        c = k;
        volumen = a * b * c;
    }

    boolean mismoBloque(Bloque ob) {
        if ((ob.a == a) && (ob.b == b) && (ob.c == c)) return true;
        else return false;
    }

    boolean mismoVolumen(Bloque ob) {
        if (ob.volumen == volumen) return true;
        else return false;
    }
}

    public class ParaEjemplos {
        public static void main(String[] args) {
            Bloque ob1 = new Bloque(10, 5, 2);
            Bloque ob2 = new Bloque(10, 5, 2);
            Bloque ob3 = new Bloque(4, 5, 5);

            System.out.println(ob1.mismoBloque(ob2));
            System.out.println(ob1.mismoBloque(ob3));
            System.out.println(ob1.mismoVolumen(ob3));
        }
    }


/*
class MatrizFallaSuave {
    private int a[];
    private int valerr;
    public int tamaño;

    public MatrizFallaSuave(int dimen, int errv) {
        a = new int[dimen];
        valerr = errv;
        tamaño = dimen;
    }
    public int obtener(int index) {
        if (ok(index)) return a[index];
        return valerr;
    }
    public boolean colocar(int index, int val) {
        if (ok(index)) {
            a[index] = val;
            return true;
        }
        return false;
    }
    private boolean ok(int index) {
        if (index >= 0 && index < tamaño) return true;
        return false;
    }
}

public class ParaEjemplos {
    public static void main(String[] args) {
       MatrizFallaSuave fs = new MatrizFallaSuave(5,-1);
       int x;

        System.out.println("Falla tranquilamente.");
        for (int i = 0; i < (fs.tamaño * 2); i++) {
            fs.colocar(i, i*10);
        }
        for (int i = 0; i < (fs.tamaño * 2); i++) {
            x = fs.obtener(i);
            if (x != -1) System.out.print(x + " ");
        }
        System.out.println("");

        System.out.println("\nFalla con reportes de error.");
        for (int i = 0; i < (fs.tamaño) * 2; i++) {
            if (!fs.colocar(i, i*10))
                System.out.println("Índice " + i + " fuera de límites");
        }

        for (int i = 0; i < (fs.tamaño * 2); i++) {
            x = fs.obtener(i);
            if (x != -1) System.out.print(x + " ");
            else System.out.println("Índice " + i + " fuera de límites");
        }
    }
}

 */