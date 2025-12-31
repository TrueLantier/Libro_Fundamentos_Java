package PaqueteLibro;

class Libro{
    private String título;
    private String autor;
    private int fechaPublicación;

    Libro(String t, String a, int f) {
        título = t;
        autor = a;
        fechaPublicación = f;
    }
    void mostrar() {
        System.out.println(título);
        System.out.println(autor);
        System.out.println(fechaPublicación);
        System.out.println();
    }
}

public class LibroDemo {
    public static void main(String[] args) {
        Libro libros[] = new Libro[5];
        libros[0] = new Libro("Principios de Java", "Schildt", 2005);
        libros[1] = new Libro("Java: The Complete Reference", "Schildt", 2005);
        libros[2] = new Libro("The Art of Java", "Schildt y Holmes", 2003);
        libros[3] = new Libro("Tormenta Roja", "Clancy", 1986);
        libros[4] = new Libro("En el camino", "Kerouac", 1955);

        for (int i = 0; i < libros.length; i++) { libros[i].mostrar(); }
    }
}
