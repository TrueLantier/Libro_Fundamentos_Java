class MostrarBits {
    int num_bits;
    MostrarBits( int n){
        num_bits = n;
    }
    void mostrar( long val) {
        long masc = 1;
        masc <<=num_bits-1;
        int espaciador = 0;

        for ( ; masc != 0; masc >>>=1) {
            if ( (val & masc) != 0) System.out.print("1 ");
            else System.out.print("0 ");
            espaciador++;
            if ( (espaciador % 8) == 0) {
                System.out.print(" ");
                espaciador = 0;
            }
        }
        System.out.println();
    }
}

public class MostrarBitsDemo {
    public static void main(String[] args) {
        MostrarBits b = new MostrarBits(8);
        MostrarBits i = new MostrarBits(32);
        MostrarBits li = new MostrarBits(64);

        System.out.println("123 en binario: ");
        b.mostrar(123);

        System.out.println("\n87987 en binario es: ");
        i.mostrar(87987);

        System.out.println("\n237658768 en binario: ");
        li.mostrar(237658768);

        System.out.println("\n8 bits de orden bajo de 87987 en binario: ");
        b.mostrar(87987);

    }
}
