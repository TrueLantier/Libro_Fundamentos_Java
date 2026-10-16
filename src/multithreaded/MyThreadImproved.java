package multithreaded;

// Mejorado.

public class MyThreadImproved implements Runnable{
    Thread thrd;
    private int espera;

    MyThreadImproved(String name) {
        thrd = new Thread(this, name);
        espera = 400;
    }

    MyThreadImproved(String name, int espera) {
        thrd = new Thread(this, name);
        this.espera = espera;
    }

    // Un factory method para crear e iniciar un hilo.
    public static MyThreadImproved crearEIniciar(String name) {
        MyThreadImproved myThreadImproved = new MyThreadImproved(name);
        myThreadImproved.thrd.start();
        return myThreadImproved;
    }

    public static MyThreadImproved crearEIniciar(String name, int espera) {
        MyThreadImproved myThreadImproved = new MyThreadImproved(name, espera);
        myThreadImproved.thrd.start();
        return myThreadImproved;
    }

    @Override
    public void run() {
        System.out.println(thrd.getName() + " empezando.");
        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(espera);
                System.out.println("En " + thrd.getName() + " la cuenta es: " + count);
            }
        } catch (InterruptedException e) {
            System.out.println(thrd.getName() + " interrumpido.");
        }
        System.out.println(thrd.getName() + " terminando.");
    }
}
