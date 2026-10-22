package multithreaded;

/*
  Ejemplo de race condition.
 */

public class ThreadTM {
    static void main(String[] args) {
        MyThreadSync mt1 = new MyThreadSync("Hijo 1");
        MyThreadSync mt2 = new MyThreadSync("Hijo 2");

        mt1.thread.start();
        mt2.thread.start();

        try {
            mt1.thread.join();
            mt2.thread.join();
            System.out.println(MyThreadSync.contador);
        } catch (InterruptedException e) {
            System.out.println("Hilo main interrumpido.");
        }
        System.out.println("Hilo main terminado.");
    }
}

class MyThreadSync implements Runnable{
    Thread thread;
    static int contador = 0;

    public MyThreadSync(String name) {
        thread = new Thread(this, name);
    }

    @Override
    public void run() {
        System.out.println(thread.getName() + " iniciando.");
        incrementar();
        System.out.println(thread.getName() + " terminando.");
    }

    void incrementar() {
        for (int i = 0; i < 5; i++) {
            ++contador;
        }
    }
}
