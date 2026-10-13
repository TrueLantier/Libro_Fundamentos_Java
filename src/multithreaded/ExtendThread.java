package multithreaded;

// Uso de herencia, no composición.

public class ExtendThread {
    static void main(String[] args) {
        System.out.println("Hilo Main empezando.");

//        MyExtendThread mt = new MyExtendThread("Hijo 1");
//        mt.start();
        MyExtendThread mt = MyExtendThread.crearEIniciar("Hijo 1");

        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Hilo Main interrumpido.");
            }
        }

        System.out.println("Hilo Main terminando.");
    }
}

class MyExtendThread extends Thread {

    MyExtendThread(String name) {
        super(name);
    }

    public void run() {
        System.out.println(getName() + " empezando.");
        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("En " + getName() + " la cuenta es: " + count);
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrumpido.");
        }
        System.out.println(getName() + " terminando.");
    }

    public static MyExtendThread crearEIniciar(String name) {
        MyExtendThread myThread = new MyExtendThread(name);
        myThread.start();
        return myThread;
    }
}
