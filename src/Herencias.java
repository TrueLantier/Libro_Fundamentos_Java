class FormaDosD {
    private double ancho;
    private double alto;
    FormaDosD() {
        ancho = alto = 0;
    }
    FormaDosD(double w, double h) {
        ancho = w;
        alto = h;
    }
    FormaDosD(double x) {
        ancho = alto = x;
    }
    FormaDosD(FormaDosD ob) {
        ancho = ob.ancho;
        alto = ob.alto;
    }

    double obtenerAncho() {return ancho;}
    double obtenerAlto() {return alto;}
    void establecerAncho(double w) {ancho = w;}
    void establecerAlto(double h) {alto = h;}
    void mostrarDim() {
        System.out.println("El ancho y alto son: " + ancho + " " + alto);
    }
}

class TriangDos extends FormaDosD {
    private String estilo;

    TriangDos() {
        super();
        estilo = null;
    }
    TriangDos(String s, double w, double h) {
        super(w,h);
        estilo = s;
    }
    TriangDos(double x) {
        super(x);
        estilo = "isósceles";
    }
    TriangDos(TriangDos ob) {
        super(ob);
        estilo = ob.estilo;
    }

    double area() {
        return obtenerAncho() * obtenerAlto() / 2;
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
