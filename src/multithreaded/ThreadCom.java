package multithreaded;

public class ThreadCom {
    static void main(String[] args) throws InterruptedException {
        TickTock tt = new TickTock();
        TickTockBad ttb = new TickTockBad();
        MyThreadWait mt1 = MyThreadWait.createAndStart("Tick", ttb);
        MyThreadWait mt2 = MyThreadWait.createAndStart("Tock", ttb);

        MyThreadWait mt3 = MyThreadWait.createAndStart("Tick", tt);
        MyThreadWait mt4 = MyThreadWait.createAndStart("Tock", tt);

        try {
            mt1.thread.join();
            mt2.thread.join();
            mt3.thread.join();
            mt4.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("\nMain is over.");
    }
}

class MyThreadWait implements Runnable{
    Thread thread;
    TickTock ttOb;
    TickTockBad ttbad;

    MyThreadWait(String name, TickTock tt) {
        thread = new Thread(this, name);
        ttOb = tt;
    }
    MyThreadWait(String name, TickTockBad tt) {
        thread = new Thread(this, name);
        ttbad = tt;
    }

    public static MyThreadWait createAndStart(String name, TickTock tt) {
        MyThreadWait myThreadWait = new MyThreadWait(name, tt);
        myThreadWait.thread.start(); // Si quiero que duerma debo hacerlo en Run().
        return myThreadWait;
    }
    public static MyThreadWait createAndStart(String name, TickTockBad tt) {
        MyThreadWait myThreadWait = new MyThreadWait(name, tt);
        myThreadWait.thread.start();
        return myThreadWait;
    }

    @Override
    public void run() {

        if (ttOb != null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }

            if (thread.getName().compareTo("Tick") == 0) {
                for (int i = 0; i < 5; i++) { ttOb.tick(true);}
                ttOb.tick(false);
            } else {
                for (int i = 0; i < 5; i++) { ttOb.tock(true);}
                ttOb.tock(false);
            }
            return;
        }

        if (ttbad != null) {
            if (thread.getName().compareTo("Tick") == 0) {
                for (int i = 0; i < 5; i++) { ttbad.tick(true);}
                ttbad.tick(false);
            } else {
                for (int i = 0; i < 5; i++) { ttbad.tock(true);}
                ttbad.tock(false);
            }
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

        System.out.println("Tock ");
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

class TickTockBad {
    String state;

    synchronized void tick(boolean running) {
        if (!running) {
            state = "ticked";
            return;
        }

        System.out.print("Tick ");
        state = "ticked";
    }

    synchronized void tock(boolean running) {
        if (!running) {
            state = "tocked";
            return;
        }

        System.out.println("Tock ");
        state = "tocked";
        notify();
    }
}