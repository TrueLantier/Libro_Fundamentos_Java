package multithreaded;

public class TickTockBetter {
    static void main(String[] args) {
        TickTockTime tt = new TickTockTime();

        MyThreadTime mt1 = new MyThreadTime("Tick", tt);
        MyThreadTime mt2 = new MyThreadTime("Tock", tt);

        mt1.thread.start();
        while (true) // Hasta que el hilo uno no inicie, no inicia el hilo 2.
            if (mt1.thread.isAlive()) {
                mt2.thread.start();
                break;
            }

        try {
            mt1.thread.join();
            mt2.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("\nMain is over.");
        }
    }

class MyThreadTime implements Runnable{
    Thread thread;
    TickTockTime ttOb;

    MyThreadTime(String name, TickTockTime tt) {
        thread = new Thread(this, name);
        ttOb = tt;
    }

    public static MyThreadTime createAndStart(String name, TickTockTime tt) {
        MyThreadTime myThreadTime = new MyThreadTime(name, tt);
        myThreadTime.thread.start(); // Si quiero que duerma debo hacerlo en Run().
        return myThreadTime;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }

        if (thread.getName().compareTo("Tick") == 0) {
            for (int i = 0; i < 5; i++) {
                ttOb.tick(true);
                dormirHilo(500);
            }
            ttOb.tick(false);
        } else {
            for (int i = 0; i < 5; i++) {
                if (i==0) {
                    dormirHilo(500); // PERFECTO
                }
                ttOb.tock(true);
                dormirHilo(500);
            }
            ttOb.tock(false);
        }
    }

    public void dormirHilo(int ml) {
        try {
            Thread.sleep(ml);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
    }
}


class TickTockTime {
    String state;

    synchronized void tick(boolean running) {
        if (!running) {
            state = "ticked";
            notify();
            return;
        }

        System.out.print("Tick ");

        // Aquí se podría poner el temporizador de 500.

        state = "ticked";
        notify();
        try {
            while (!state.equals("tocked")) {
                wait(); // Es necesario que esté en un bucle while porque puede ocurrir esa condición rara.
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
    }

    synchronized void tock(boolean running) {
        if (!running) {
            state = "tocked";
            notify();
            return;
        }

        System.out.println("Tock ");

        // Aquí se podría poner el temporizador de 500.

        state = "tocked";
        notify();
        try {
            while (!state.equals("ticked")) {
                wait();
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
    }
}
