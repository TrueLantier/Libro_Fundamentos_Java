package multithreaded;

public class ThreadCom {
    static void main(String[] args) {
        TickTock tt = new TickTock();
        MyThreadWait mt1 = MyThreadWait.createAndStart("Tick", tt);
        MyThreadWait mt2 = MyThreadWait.createAndStart("Tock", tt);

        try {
            mt1.thread.join();
            mt2.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

    }
}

class MyThreadWait implements Runnable{
    Thread thread;
    TickTock ttOb;

    MyThreadWait(String name, TickTock tt) {
        thread = new Thread(this, name);
        ttOb = tt;
    }

    public static MyThreadWait createAndStart(String name, TickTock tt) {
        MyThreadWait myThreadWait = new MyThreadWait(name, tt);
        myThreadWait.thread.start();
        return myThreadWait;
    }

    @Override
    public void run() {
        if (thread.getName().compareTo("Tick") == 0) {
            for (int i = 0; i < 5; i++) { ttOb.tick(true);}
            ttOb.tick(false);
        } else {
            for (int i = 0; i < 5; i++) { ttOb.tock(true);}
            ttOb.tock(false);
        }
    }
}

class TickTock {
    String state;

    synchronized void tick(boolean running) {
        if (!running) {
            state = "ticked";
            notify();
            return;
        }

        System.out.print("Tick ");
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

        System.out.print("Tock ");
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