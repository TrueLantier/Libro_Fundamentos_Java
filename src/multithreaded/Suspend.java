package multithreaded;

public class Suspend {
    static void main(String[] args) {
        MyThreadStop my1 = MyThreadStop.createAndStart("My thread");
        try {
            System.out.println("Main thread sleeping.");
            Thread.sleep(1000); // Esto es para el hilo main.

            my1.mySuspended();
            System.out.println("Suspending thread.");
            Thread.sleep(1000); // Hay una pausa en el programa.

            my1.myResume();
            System.out.println("Resuming thread.");
            Thread.sleep(1000);

            my1.mySuspended();
            System.out.println("Suspending thread.");
            Thread.sleep(1000);

            my1.myResume();
            System.out.println("Resuming thread.");
            Thread.sleep(1000);

            my1.mySuspended();
            System.out.println("Stopping thread.");
            my1.myStop();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        try {
          my1.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("Main thread exiting.");
    }
}

class MyThreadStop implements Runnable{
    Thread thread;
    boolean suspended;
    boolean stopped;

    public MyThreadStop(String name) {
        thread = new Thread(this, name);
        suspended = false;
        stopped = false;
    }

    public static MyThreadStop createAndStart(String name) {
        MyThreadStop myThreadStop = new MyThreadStop(name);
        myThreadStop.thread.start();
        return myThreadStop;
    }

    @Override
    public void run() {
        System.out.println(thread.getName() +  " starting.");
        try {
            for (int i = 1; i <= 1000; i++) {
                System.out.print(i + " ");
                if (i % 10 == 0) {
                    System.out.println();
                    Thread.sleep(250);
                }

                synchronized (this) {
                    // Este bloque synchronized usa VARIABLES, no métodos y tampoco son synchronized.
                    while (suspended) {
                        wait();
                    }
                    if (stopped) { break;}
                }
            }
        } catch (InterruptedException e) {
            System.out.println(thread.getName() + " interrupted.");
        }
        System.out.println(thread.getName() + " exiting.");
    }

    synchronized void myStop() {
        stopped = true;
        suspended = false;
        notify();
    }
    synchronized void mySuspended() {
        suspended = true;
    }
    synchronized void myResume() {
        suspended = false;
        notify();
    }
}

