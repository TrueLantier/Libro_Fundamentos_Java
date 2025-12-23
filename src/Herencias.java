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

    void mostrarDim() {
        System.out.println("El ancho y alto son: " + ancho + " " + alto);
    }
    double obtenerAncho() {return ancho;}
    double obtenerAlto() {return alto;}
    void establecerAncho(double w) {ancho = w;}
    void establecerAlto(double h) {alto = h;}
}

class TriangDos extends FormaDosD {
    String estilo;

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

public class Herencias {
    public static void main(String[] args) {
        TriangDos t1 = new TriangDos("isósceles", 4, 4);
        TriangDos t2 = new TriangDos(5);

        t1.mostrarEstilo();
        t1.mostrarDim();
        System.out.println(t1.area());
        System.out.println();
        t2.mostrarEstilo();
        t2.mostrarDim();
        System.out.println(t2.area());

    }
}

class A {
    int i;
}
class B extends A {
    int i;
    B(int a, int b) {
        super.i = a;
        i = b;
    }

    void mostrar() {
        System.out.println(super.i);
        System.out.println(i);
    }
}