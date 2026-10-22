package multithreaded;

// Ejemplo de deadlock.

public class Thread4M {
    static void main(String[] args) {
        DeadLock d1 = new DeadLock("Hilo 1");
        DeadLock d2 = new DeadLock("Hilo 2");

        d1.thread.start();
        d2.thread.start();

        try {
            d1.thread.join(4000);
            d2.thread.join(4000);
        } catch (InterruptedException e) {
            System.out.println("Hilo main interrumpido.");
        }
        System.out.println("Hilo main finalizado");
    }
}

class DeadLock implements Runnable {
    Thread thread;

    public DeadLock(String name) {
        thread = new Thread(this, name);
    }

    @Override
    public void run() {
        System.out.println(thread.getName() + " empezando.");

        synchronized (this) {
            nada();
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(thread.getName() + " interrumpido.");
            }
        }
    }

    void nada() {
        // Este método no hace nada.
    }
}
