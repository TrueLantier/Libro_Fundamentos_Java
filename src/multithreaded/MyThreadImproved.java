package multithreaded;

// Mejorado.

public class MyThreadImproved implements Runnable{
    Thread thrd;

    MyThreadImproved(String name) {
        thrd = new Thread(this, name);
    }

    // Un factory method para crear e iniciar un hilo.
    public static MyThreadImproved crearEIniciar(String name) {
        MyThreadImproved myThreadImproved = new MyThreadImproved(name);
        myThreadImproved.thrd.start();
        return myThreadImproved;
    }

    @Override
    public void run() {
        System.out.println(thrd.getName() + " empezando.");
        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("En " + thrd.getName() + " la cuenta es: " + count);
            }
        } catch (InterruptedException e) {
            System.out.println(thrd.getName() + " interrumpido.");
        }
        System.out.println(thrd.getName() + " terminando.");
    }
}
