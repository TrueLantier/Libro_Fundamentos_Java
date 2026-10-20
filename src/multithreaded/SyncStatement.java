package multithreaded;

public class SyncStatement {
    static void main(String[] args) {
        int[] a = {1 ,2, 3, 4, 5};

        MyThreadArraySS mt1 = MyThreadArraySS.createAndStart("Child #1", a);
        MyThreadArraySS mt2 = MyThreadArraySS.createAndStart("Child #2", a);

        try {
            mt1.thread.join();
            mt2.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
    }
}

class MyThreadArraySS implements Runnable{
    Thread thread;
    static SumArray sa = new SumArray();
    int[] a;
    int answer;

    MyThreadArraySS(String name, int[] nums) {
        thread = new Thread(this, name);
        a = nums;
    }

    public static MyThreadArraySS createAndStart(String name, int[] nums) {
        MyThreadArraySS myThreadArraySS = new MyThreadArraySS(name, nums);
        myThreadArraySS.thread.start();
        return myThreadArraySS;
    }

    @Override
    public void run() {
        System.out.println(thread.getName() + " starting.");

        synchronized (sa) {
            answer = sa.sumArray(a);
        }

        System.out.println("Sum for " + thread.getName() + " is " + answer);
        System.out.println(thread.getName() + " terminating");
    }
}

class SumArraySS {
    private int sum;

    int sumArray(int[] nums) {
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

