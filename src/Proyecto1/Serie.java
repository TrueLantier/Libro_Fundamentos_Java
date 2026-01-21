package Proyecto1;

public interface Serie {
    int getNext();

    default int[] getNextArray(int n) {
        return getArray(n);
    }

    default int[] skipAndGetNextArray(int skip, int n) {
        getArray(skip);
        return getArray(n);
    }

    private int[] getArray(int n) {
        int[] vals = new int[n];
        for(int i=0; i < n; i++) vals[i] = getNext();
        return vals;
    }

    void reset();
    void setStart(int x);
}

class PorDos implements Serie {
    int inicio;
    int val;
    int ant;

    PorDos() {
        inicio = 0;
        val = 0;
        ant = -2;
    }

    @Override
    public int getNext(){
        ant = val;
        val += 2;
        return val;
    }
    @Override
    public void reset() {
        inicio = 0;
        val = 0;
        ant = -2;
    }
    @Override
    public void setStart(int x) {
        inicio = x;
        val = x;
        ant = x - 2;
    }
    int getPrior(){ return ant; }
}

class PorTres implements Serie, InterfazPruebaDos {
    int inicio;
    int val;
    int ant;

    PorTres() {
        inicio = 0;
        val = 0;
        ant = -3;
    }

    @Override
    public int getNext(){
        ant = val;
        val += 3;
        return val;
    }

    @Override
    public void reset() {
        inicio = 0;
        val = 0;
        ant = -3;
    }

    @Override
    public void setStart(int x) {
        inicio = x;
        val = x;
        ant = x - 3;
    }

    int getPrior(){ return ant; }
}

class SerieDemo {
    public static void main(String[] args) {
        PorDos dosOb = new PorDos();
        PorTres tresOb = new PorTres();
        Serie ob;

        for (int i = 0; i < 5; i++) {
            ob = dosOb;
            System.out.println("Valores de PorDos: " + ob.getNext());
            System.out.println();
            ob = tresOb;
            System.out.println("Valores de PorTres: " + ob.getNext());
        }
    }
}