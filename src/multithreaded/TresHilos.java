package multithreaded;

public class TresHilos {
    static void main(String[] args) {
        MyThreadImproved mt1 = MyThreadImproved.crearEIniciar("Hijo 1");
        MyThreadImproved mt2 = MyThreadImproved.crearEIniciar("Hijo 2");
        MyThreadImproved mt3 = MyThreadImproved.crearEIniciar("Hijo 3");

        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Hilo Main interrumpido.");
            }
        }

        System.out.println("Hilo Main terminado.");
    }
}
