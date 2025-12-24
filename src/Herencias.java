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
        C c = new C();
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