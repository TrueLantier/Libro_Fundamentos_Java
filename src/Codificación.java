public class Codificación {
    public static void main(String[] args) {
        String msj = "Esta es una prueba.";
        String codmsj = "";
        String decmsj = "";
        int key = 88;
        String clave = "Aprender";
        int j = 0;
        // Interesante, el 77 come caracter.

        System.out.println("Mensaje original: " + msj);

        // Codificación básica. Una sola clave.
//        for ( int i=0; i<msj.length(); i++) {
//            codmsj = codmsj + (char) (msj.charAt(i) ^ clave.length());
//
//        }
//        System.out.println("Mensaje codificado: " + codmsj);
//
//        for ( int i=0; i<msj.length(); i++) {
//            decmsj = decmsj + (char) (codmsj.charAt(i) ^ clave.length());
//        }
//        System.out.println("Mensaje decodificado: " + decmsj);

        // Más seguro. Diferentes letras con diferentes claves.
        j = 0;
        for ( int i=0; i<msj.length(); i++) {
            codmsj = codmsj + (char) (msj.charAt(i) ^ clave.charAt(j));
            j++;
            if (j==8) j=0;
        }
        System.out.println("Mensaje codificado: " + codmsj);

        j = 0;
        for ( int i=0; i<msj.length(); i++) {
            decmsj = decmsj + (char) (codmsj.charAt(i) ^ clave.charAt(j));
            j++;
            if (j==8) j=0;
        }
        System.out.println("Mensaje decodificado: " + decmsj);
    }
}
