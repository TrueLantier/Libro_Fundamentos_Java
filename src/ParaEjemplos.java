// empezar paquetes

public class ParaEjemplos {
    public static void main(String[] args) {
        Sup ob = new Sup();
        Sup1 ob1 = new Sup1();
        Sup2 ob2 = new Sup2();

        Sup opref;
        opref = ob;
        opref.quien();

        opref = ob1;
        opref.quien();

        opref = ob2;
        opref.quien();
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