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
}

public class ProtectedDemo {
}
