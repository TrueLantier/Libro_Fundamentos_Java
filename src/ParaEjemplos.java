class Exterior{
    int[] nums;

    Exterior(int[] n) {
        nums = n;
    }

    void Analiza() {
        Interior inOb = new Interior();
        System.out.println(inOb.min());
        System.out.println(inOb.max());
        System.out.println(inOb.prom());
    }

    class Interior{
        int min() {
            int m = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < m) m = nums[i];
            }
            return m;
        }
        int max() {
            int m = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > m) m = nums[i];
            }
            return m;
        }
        int prom() {
            int a = 0;
            for (int i = 0; i < nums.length; i++) {
                a += nums[i];
            }
            return a / nums.length;
        }
    }
}

public class ParaEjemplos {
    public static void main(String[] args) {
        int[] x = { 3, 2, 1, 5, 6, 9, 7, 8};
        Exterior ext = new Exterior(x);
        ext.Analiza();
    }
}
