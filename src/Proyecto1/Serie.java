package Proyecto1;

public interface Serie {
    int getNext();
    void reset();
    void setStart(int x);
}

class PorDos implements Serie {
    int inicio;
    int val;

    PorDos() {
        inicio = 0;
        val = 0;
    }

    @Override
    public int getNext(){
        val += 2;
        return val;
    }

    @Override
    public void reset() {
        inicio = 0;
        val = 0;
    }

    @Override
    public void setStart(int x) {
        inicio = x;
        val = x;
    }
}

class SerieDemo {
    public static void main(String[] args) {
        PorDos ob = new PorDos();
        for (int i = 0; i < 5; i++) {
            System.out.println("El siguiente valor es: " + ob.getNext());
        }
        System.out.println("\nRestableciendo");
        ob.reset();
        System.out.println("\nEmpezando en 100");
        ob.setStart(100);
        for (int i = 0; i < 5; i++) {
            System.out.println("El siguiente valor es: " + ob.getNext());
        }
    }
}