class Pot{
    double b;
    int e;
    double val;

    Pot( double base, int exp) {
        b = base;
        e = exp;
        val = 1;
        if (exp==0) return;
        for (; exp>0; exp--) val = val*base;
    }
    double obtener_pot() {
        return val;
    }
}

public class ParaEjemplos {
    public static void main(String[] args) {
        Pot x = new Pot(4.0, 2);
        Pot y = new Pot(2.5, 1);
        Pot z = new Pot(5.7, 0);

        System.out.println( x.b + " elevado a la " + x.e + " potencia es " + x.obtener_pot());
        System.out.println( y.b + " elevado a la " + y.e + " potencia es " + y.obtener_pot());
        System.out.println( z.b + " elevado a la " + z.e + " potencia es " + z.obtener_pot());
    }
}
