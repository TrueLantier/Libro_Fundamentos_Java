package Proyecto1;

interface InterfazPruebaDos {

}

public class ParaEjemplos {
    public static void main(String[] args) {

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