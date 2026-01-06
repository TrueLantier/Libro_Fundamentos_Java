package Proyecto1;

public interface InterfazPrueba {
    int min = 0;
    int max = 10;
    String msjerror = "Error de límites";
}

interface A {
    void met1();
    void met2();
}
interface B extends A {
    void met3();
}

class MiClase implements B {
    @Override
    public void met1() {
        System.out.println("Implementa met1");
    }

    @Override
    public void met2() {
        System.out.println("Implementa met2");
    }

    @Override
    public void met3() {
        System.out.println("Implementa met3");
    }

    public static void main(String[] args) {
        MiClase mc = new MiClase();
        mc.met1();
    }
}