package EstructurasDatosAlgoritmos;
public interface ICCHAR {
    void put(char ch) throws ColaLlenaExcepción;
    char get() throws ColaVacíaExcepción;
    void reset();
}

/*
Interesante. ColaLlenaExcepción y ColaVacíaExcepción tiene modificadores de acceso predeterminado en la
clase pública Excepciones. Entonces yo establezco que los métodos put y get de la interfaz pública ICCHAR
pueden lanzar ambas excepciones respectivamente.
Al la interfaz ser pública puede ser usada por clases de otros paquetes, y ellas podrán implementar sus
métodos. Sin embargo, como las excepciones son predeterminadas no podrán ser arrojas en otros paquetes,
para ese necesitarían tener su propio archivo y ser públicas.
Esto se traduce en: Problemas de visibilidad y encapsulamiento.
 */