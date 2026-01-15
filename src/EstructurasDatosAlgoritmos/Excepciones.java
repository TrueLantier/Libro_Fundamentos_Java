package EstructurasDatosAlgoritmos;

class ColaFijaLlenaExcepción extends Exception {
    int dim;

    ColaFijaLlenaExcepción(int s) { dim = s; }

    @Override
    public String toString() {
        return "\nLa cola se ha llenado. El tamaño máximo es: " + dim;
    }
}

class ColaFijaVacíaExcepción extends Exception {

    @Override
    public String toString() { return "\nLa cola está vacía."; }
}

class PilaLlenaExcepción extends Exception {
    int dim;

    PilaLlenaExcepción(int s) { dim = s; }

    @Override
    public String toString() {
        return "\nLa pila se ha llenado. El tamaño máximo es: " + dim;
    }
}

class PilaVacíaExcepción extends Exception {

    @Override
    public String toString() { return "\nLa pila está vacía."; }
}