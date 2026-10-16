package multithreaded;

/*
  Aquí los 4 hilos se ejecutan de forma concurrente sin forzar al main a terminar de último, y por ende, en ocasiones
  no lo es.
 */

public class ThreadSM {
    static void main(String[] args) throws InterruptedException{
        MyThreadImproved mt1 = MyThreadImproved.crearEIniciar("Hijo 1");
        MyThreadImproved mt2 = MyThreadImproved.crearEIniciar("Hijo 2");
        MyThreadImproved mt3 = MyThreadImproved.crearEIniciar("Hijo 3");

        System.out.println("Main thread starting.");
        for (int count = 0; count < 10; count++) {
            Thread.sleep(400);
            System.out.println("En " + Thread.currentThread().getName() + " la cuenta es: " + count);
        }
        System.out.println("Main thread ending.");
    }
}
