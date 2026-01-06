package Proyecto1;

interface InterfazPruebaDos {

}

public class ParaEjemplos implements InterfazPrueba{
    public static void main(String[] args) {
        int[] nums = new int[max];

        for (int i = min; i < 11; i++) {
            if (i >= max) {
                System.out.println(msjerror);
            }   else {
                nums[i] = i;
                System.out.println(nums[i] + i);
            }
        }
    }
}

class Sup{
    void quien() {
        System.out.println("quien() en Sup");
    }
}
class Sup1 extends Sup{
    void quien() {
        System.out.println("quien() en Sup1");
    }
}
class Sup2 extends Sup{
    void quien() {
        System.out.println("quien() en Sup2");
    }
}