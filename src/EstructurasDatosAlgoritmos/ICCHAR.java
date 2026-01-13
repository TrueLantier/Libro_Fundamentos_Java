package EstructurasDatosAlgoritmos;
public interface ICCHAR {
    void put(char ch) throws ColaFijaLlenaExcepción;
    char get() throws ColaFijaVacíaExcepción;
    void reset();
}