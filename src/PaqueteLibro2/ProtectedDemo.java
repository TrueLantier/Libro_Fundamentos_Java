package PaqueteLibro2;
import PaqueteLibro.Libro;

class ExtLibro extends Libro {
    private String editor;

    ExtLibro(String t, String a, int f, String e) {
        super(t, a, f);
        editor = e;
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println(editor);
        System.out.println();
    }

    public String getEditor() { return editor; }
    public void setEditor(String e) { editor = e; }

    public String getTítulo() { return título; }
    public void setTítulo(String t) { título = t; }
    public String getAutor() { return autor; }
    public void setAutor(String a) { autor = a; }
    public int getFecha() { return fechaPublicación; }
    public void setFecha(int f) { fechaPublicación = f; }
}

public class ProtectedDemo {
    public static void main(String[] args) {
        ExtLibro[] libros = new ExtLibro[5];
        libros[0] = new ExtLibro("Principios de Java", "Schildt", 2005, "Osborne/McGraw-Hill");
        libros[1] = new ExtLibro("Java: The Complete Reference", "Schildt", 2005, "Osborne" +
                "/McGraw-Hill");
        libros[2] = new ExtLibro("The Art of Java", "Schildt y Holmes", 2003, "Osborne" +
                "/McGraw-Hill");
        libros[3] = new ExtLibro("Tromente Roja", "Clancy",
                1986, "Putman");
        libros[4] = new ExtLibro("En el camino", "Kerouac",
                1955, "Viking");

        for (ExtLibro libro: libros) { libro.mostrar(); }

        System.out.println("Libros de Schildt.");
        for (int i = 0; i < libros.length; i++) {
            if (libros[i].getAutor() == "Schildt") {
                System.out.println(libros[i].getTítulo());
            }
        }


    }
}
