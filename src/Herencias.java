class FormaDosD {
    private double ancho;
    private double alto;
    private String nombre;

    FormaDosD() {
        ancho = alto = 0;
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

    double obtenerAncho() {return ancho;}
    double obtenerAlto() {return alto;}
    void establecerAncho(double w) {ancho = w;}
    void establecerAlto(double h) {alto = h;}
    String getNombre() { return nombre; }

    void mostrarDim() {
        System.out.println("El ancho y alto son: " + ancho + " " + alto);
    }
    double area() {
        System.out.println("area() debe sobreescribirse");
        return 0.0;
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
        return obtenerAncho() == obtenerAlto();
    }

    double area() { return obtenerAncho() * obtenerAlto(); }
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
    int i, j;
    A(int a, int b) {
        i = a;
        j = b;
    }

    void mostrar() {
        System.out.println(i + " " + j);
    }
//    A() {
//        System.out.println("Construyendo A.");
//    }
//    static {
//        System.out.println("Esto va primero en A.");
//    }
}
class B extends A {
    int k;
    B(int a, int b, int c) {
        super(a,b);
        k = c;
    }

    void mostrar(String msj) {
        //super.mostrar();
        System.out.println(msj + k);
    }
//    B() {
//        System.out.println("Construyendo B.");
//    }
//    static {
//        System.out.println("Esto va primero en B.");
//    }
}
class C extends B {
    C(int a, int b, int c, int d) {
        super(a, b, c);
    }
//    C() {
//        System.out.println("Construyendo C.");
//    }
//    static {
//        System.out.println("Esto va primero en C.");
//    }
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
