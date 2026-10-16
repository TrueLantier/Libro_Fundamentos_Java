package multithreaded;

/*
  El 1.er join detiene al hilo Main, por lo tanto, los demás joins no afectan como tal la ejecución de dicho hilo.
  Sin embargo, puede ocurrir que El hilo 1 finalice, se haga el 1.er print y luego se vuelva a parar Main para esperar
  por los hilos 2 y 3.
 */

public class ThreadJoin {
    static void main(String[] args) {
        MyThreadImproved mt1 = MyThreadImproved.crearEIniciar("Child 1");
        MyThreadImproved mt2 = MyThreadImproved.crearEIniciar("Child 2");
        MyThreadImproved mt3 = MyThreadImproved.crearEIniciar("Child 3");

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
