package multithreaded;

/*
  Aquí sí se pausa al thread Main en 3 ocasiones. Lo interesante es que los joins no pausan a los otros hilos, solo
  al que invoca.
 */

public class ThreadFM {
    static void main(String[] args) {
        MyThreadImproved mt1 = MyThreadImproved.crearEIniciar("Child 1");
        MyThreadImproved mt2 = MyThreadImproved.crearEIniciar("Child 2", 500);
        MyThreadImproved mt3 = MyThreadImproved.crearEIniciar("Child 3", 600);

        try {
            mt1.thrd.join();
            System.out.println("Child #1 joined.");

            mt2.thrd.join();
            System.out.println("Child #2 joined.");

            mt3.thrd.join();
            System.out.println("Child #3 joined.");
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("Main thread ending.");
    }
}
