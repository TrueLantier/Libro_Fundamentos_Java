package Proyecto1;

public interface Serie {
    int getNext();
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

class PorTres implements Serie {
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


    }
}