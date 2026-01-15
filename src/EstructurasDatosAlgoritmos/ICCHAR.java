package EstructurasDatosAlgoritmos;
public interface ICCHAR {
    void put(char ch) throws ColaLlenaExcepción;
    char get() throws ColaVacíaExcepción;
    void reset();
}