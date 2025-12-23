class Carro{
    private int pasajeros; // número de pasajeros
    private int tanquegas; // capacidad del tanque en litros
    private int kpl; // consumo de gasolina en km por litros

    Carro( int p, int f, int m) {
        pasajeros = p;
        tanquegas = f;
        kpl = m;
    }
    int rango(){
        return kpl*tanquegas;
    }
    double gasolinaNecesaria( int kilómetros) {
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
        Camioneta camioneta = new Camioneta(2, 800, 2, 20000);


    }
}
