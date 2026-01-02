package PaqueteLibro;

public class Libro{
    protected String título;
    protected String autor;
    protected int fechaPublicación;

    public Libro(String t, String a, int f) {
        título = t;
        autor = a;
        fechaPublicación = f;
    }
    public void mostrar() {
        System.out.println(título);
        System.out.println(autor);
        System.out.println(fechaPublicación);
        System.out.println();
    }
}
