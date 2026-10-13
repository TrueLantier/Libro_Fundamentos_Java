package multithreaded;

// Básico.

public class MyThread implements Runnable{
    String thrName;

    MyThread(String name) {
        thrName = name;
    }

    @Override
    public void run() {
        System.out.println(thrName + " empezando.");
        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("En " + thrName + " la cuenta es: " + count);
            }
        } catch (InterruptedException e) {
            System.out.println(thrName + " interrumpido.");
        }
        System.out.println(thrName + " terminando.");
    }
}
