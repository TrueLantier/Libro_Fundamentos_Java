package multithreaded;

public class Sync {
    static void main(String[] args) {
        int[] a = {1 ,2, 3, 4, 5};

        MyThreadArray mt1 = MyThreadArray.createAndStart("Child #1", a);
        MyThreadArray mt2 = MyThreadArray.createAndStart("Child #2", a);

        try {
            mt1.thread.join();
            mt2.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
    }
}

class MyThreadArray implements Runnable{
    Thread thread;
    static SumArray sa = new SumArray();
    int[] a;
    int answer;

    MyThreadArray(String name, int[] nums) {
        thread = new Thread(this, name);
        a = nums;
    }

    public static MyThreadArray createAndStart(String name, int[] nums) {
        MyThreadArray myThreadArray = new MyThreadArray(name, nums);
        myThreadArray.thread.start();
        return myThreadArray;
    }

    @Override
    public void run() {
        System.out.println(thread.getName() + " starting.");

        /*
          Bloque synchronized si los métodos no son sincronizados -->
          synchronized (sa) {
              answer = sa.sumArray(a);
          }
         */

        answer = sa.sumArray(a);
        System.out.println("Sum for " + thread.getName() + " is " + answer);
        System.out.println(thread.getName() + " terminating");
    }
}

class SumArray {
    private int sum;

    synchronized int sumArray(int[] nums) {
        sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            System.out.println("Running total for: " + Thread.currentThread().getName() + " is " + sum);

            try {
                Thread.sleep(10); // allow task-switch
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }

        return sum;
    }
}
