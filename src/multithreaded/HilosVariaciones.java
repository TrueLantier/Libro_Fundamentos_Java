package multithreaded;

public class HilosVariaciones {
    static void main(String[] args) {
        System.out.println("Empezando el hilo Main.");

        MyThreadImproved mt = MyThreadImproved.crearEIniciar("Hijo 1");

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
