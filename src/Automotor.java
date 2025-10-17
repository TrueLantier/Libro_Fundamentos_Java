class Carro{
    int pasajeros;
    int tanquegas;
    int kpl;

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
