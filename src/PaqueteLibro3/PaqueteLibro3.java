package PaqueteLibro3;
import PaqueteLibro.*;

public class PaqueteLibro3 {
    public static void main(String[] args) {
        Libro[] libros = new Libro[5];
        libros[0] = new Libro("Principios de Java", "Schildt", 2005);
        libros[1] = new Libro("Java: The Complete Reference", "Schildt", 2005);
        libros[2] = new Libro("The Art of Java", "Schildt y Holmes", 2003);
        libros[3] = new Libro("Tormenta Roja", "Clancy", 1986);
        libros[4] = new Libro("En el camino", "Kerouac", 1955);

        for (int i = 0; i < libros.length; i++) { libros[i].mostrar(); }
    }
}
