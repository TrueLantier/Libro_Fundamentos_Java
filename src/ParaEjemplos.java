class StaticBloque{
    static double raíz2;
    static double raíz3;

    static {
        System.out.println("Dentro del bloque static");
        raíz2 = Math.sqrt(2);
        raíz3 = Math.sqrt(3);
    }

    StaticBloque(String msj) {
        System.out.println(msj);
    }
}
public class ParaEjemplos {
    public static void main(String[] args) {
        StaticBloque ob = new StaticBloque("Dentro del constructor");
    }
}
