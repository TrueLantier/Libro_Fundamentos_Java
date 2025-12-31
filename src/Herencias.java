import Proyecto1.ParaEjemplos; // Puedo importar un paquete y de ahí sus clases.

abstract class FormaDosD {
    private double ancho;
    private double alto;
    private String nombre;

    FormaDosD() {
        ancho = alto = 0;
        nombre = null;
    }
    FormaDosD(double w, double h, String n) {
        ancho = w;
        alto = h;
        nombre = n;
    }
    FormaDosD(double x, String n) {
        ancho = alto = x;
        nombre = n;
    }
    FormaDosD(FormaDosD ob) {
        ancho = ob.ancho;
        alto = ob.alto;
        nombre = ob.nombre;
    }

    double getAncho() {return ancho;}
    double getAlto() {return alto;}
    void setAnchoAncho(double w) {ancho = w;}
    void setAltoAlto(double h) {alto = h;}
    String getNombre() { return nombre; }

    void mostrarDim() {
        System.out.println("El ancho y alto son: " + ancho + " " + alto);
    }
    abstract double area();
}
class Círculo extends FormaDosD {
    Círculo() {
        super();
    }
    Círculo(double x) {
        super(x, "Círculo");
    }
    Círculo(Círculo ob) {
        super(ob);
    }

    @Override
    double area() {
        return Math.PI * (getAncho() / 2) * (getAncho() / 2);
    }
}
class Rectang extends FormaDosD {
    Rectang() {
        super();
    }
    Rectang(double w, double h) {
        super(w, h, "un rectángulo");
    }
    Rectang(double x) {
        super(x, "un rectángulo");
    }
    Rectang(Rectang ob) {
        super(ob);
    }

    boolean esCuadrado() {
        return getAncho() == getAlto();
    }

    @Override
    double area() { return getAncho() * getAlto(); }
}
class TriangDos extends FormaDosD {
    private String estilo;

    TriangDos() {
        super();
        estilo = null;
    }
    TriangDos(String s, double w, double h) {
        super(w,h, "un triángulo");
        estilo = s;
    }
    TriangDos(double x) {
        super(x, "un triángulo");
        estilo = "isósceles";
    }
    TriangDos(TriangDos ob) {
        super(ob);
        estilo = ob.estilo;
    }

    @Override
    double area() {
        return getAncho() * getAlto() / 2;
    }
    void mostrarEstilo() {
        System.out.println("El triángulo es: " + estilo);
    }
}
class ColorTriang extends TriangDos{
    private String color;
    ColorTriang(String c, String s, double w, double h) {
        super(s, w, h);
        color = c;
    }

    String getColor() {return color;}
    void mostrarColor() {
        System.out.println("El color es " + color);
    }
}

public class Herencias {
    public static void main(String[] args) {
        FormaDosD[] formas = new FormaDosD[4];
        formas[0] = new TriangDos("recto", 8.0, 12.0);
        formas[1] = new Rectang(10);
        formas[2] = new Rectang(10, 4);
        formas[3] = new TriangDos(7.0);

        for (int i = 0; i < formas.length; i++) {
            System.out.println("El objeto es: " + formas[i].getNombre());
            System.out.println("El área es: " + formas[i].area());
            System.out.println();
        }
        System.out.println(formas[0].getClass() );
    }
//    static {
//        System.out.println("Esto va primero en Herencias.");
//    }
}

// Interesante
class A {
    A() {
        System.out.println("Construyendo A.");
    }
    static {
        System.out.println("Esto va primero en A.");
    }
}
class B extends A {
    B() {
        System.out.println("Construyendo B.");
    }
    static {
        System.out.println("Esto va primero en B.");
    }
}
class C extends B {
    C() {
        System.out.println("Construyendo C.");
    }
    static {
        System.out.println("Esto va primero en C.");
    }
}

class X {
    int a;
    int b;
    int c = 100;
    X(int i) { a = i; }
}
class Y extends X{
    int d;
    int e = 200;
    Y(int i, int j) {
        super(j);
        b = i;
        c = 1000;

    }
}
class Z extends Y {
    int f;
    Z(int i, int j, int k) {
        super(j, k);
        d = i;
        c = 999;
        e = 666;
    }

}
