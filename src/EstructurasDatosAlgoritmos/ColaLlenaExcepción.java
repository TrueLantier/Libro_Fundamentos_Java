package EstructurasDatosAlgoritmos;

public class ColaLlenaExcepción extends Exception {
    int dim;

    ColaLlenaExcepción(int s) { dim = s; }

    @Override
    public String toString() {
        return "\nLa cola se ha llenado. El tamaño máximo es: " + dim;
    }
}

