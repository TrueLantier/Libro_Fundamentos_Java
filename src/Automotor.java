interface IAutomotor {
    int rango();
    double gasolinaNecesaria(int km);
}

class Carro implements IAutomotor{
    private int pasajeros; // número de pasajeros
    private int tanquegas; // capacidad del tanque en litros
    private int kpl; // consumo de gasolina en km por litros

    Carro( int p, int f, int m) {
        pasajeros = p;
        tanquegas = f;
        kpl = m;
    }

    @Override
    public int rango() {
        return kpl*tanquegas;
    }
    @Override
    public double gasolinaNecesaria(int kilómetros) {
        return (double) kilómetros / kpl;
    }
}

class Camioneta extends Carro {
    private int capacidadCarga; // en kilos

    Camioneta(int p, int f, int m, int c) {
        super(p, f, m);
        capacidadCarga = c;
    }
    int obtenerCarga() { return capacidadCarga; }
    void colocarCarga(int c) { capacidadCarga = c; }
}

public class Automotor {
    public static void main(String[] args) {
        Camioneta semi = new Camioneta(2, 800, 2, 20000);
        Camioneta pickup = new Camioneta(3, 100, 4, 1000);
        double litros;
        int distancia = 252;

        litros = semi.gasolinaNecesaria(distancia);
        System.out.println("Un semiremolque puede cargar " + semi.obtenerCarga() + " kilos.");
        System.out.println("Para recorrer " + distancia + " km necesita " + litros + " litros de gasolina.");

        litros = pickup.gasolinaNecesaria(distancia);
        System.out.println("Un pickup puede cargar " + pickup.obtenerCarga() + " kilos.");
        System.out.println("Para recorrer " + distancia + " km necesita " + litros + " litros de gasolina.");

    }
}
