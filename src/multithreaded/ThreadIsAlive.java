package multithreaded;

public class ThreadIsAlive {
    static void main(String[] args) {
        MyThreadImproved mt1 = MyThreadImproved.crearEIniciar("Child 1");
        MyThreadImproved mt2 = MyThreadImproved.crearEIniciar("Child 2");
        MyThreadImproved mt3 = MyThreadImproved.crearEIniciar("Child 3");
        int countMain = 0;

        do {
            System.out.print(".");
            ++countMain;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted.");
            }
        } while (mt1.thrd.isAlive() || mt2.thrd.isAlive() || mt3.thrd.isAlive());

        System.out.println(countMain);
        System.out.println("Main thread ending.");
    }
}
