package multithreaded;

public class UseThreads {
    static void main(String[] args) {
        System.out.println("Empezando el hilo Main.");

        MyThread mt = new MyThread("Hijo 1");
        Thread newThrd = new Thread(mt);
        newThrd.start();

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
