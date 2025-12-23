class Carro{
    private int pasajeros; // número de pasajeros
    private int tanquegas; // capacidad del tanque en litros
    private int kpl; // consumo de gasolina en km por litros

    Carro( int p, int t, int k) {
        pasajeros = p;
        tanquegas = t;
        kpl = k;
    }
    int rango(){
        return kpl*tanquegas;
    }
    double gasnec( int kilómetros) {
        return (double) kilómetros / kpl;
    }
}

class Camioneta extends Carro {
    private int capacidadCarga;

    Camioneta(int p, int f, int m, int c) {
        super(p, f, m);
        capacidadCarga = c;
    }
    int obtenerCarga() { return capacidadCarga; }
    void colocarCarga(int c) { capacidadCarga = c; }
}

public class Automotor {
    public static void main(String[] args) {
        Carro minivan = new Carro(7, 60, 6);
        Carro deportivo = new Carro(2, 50, 4);
        double litros;
        int dist = 252; // Es en kilómetros.

        litros = minivan.gasnec(dist);
        System.out.println("Para recorrer " + dist + " km una minivan necesita " + litros + " de gasolina.");

        litros = deportivo.gasnec(dist);
        System.out.println("Para recorrer " + dist + " km un deportivo necesita " + litros + " de gasolina.");
    }
}
