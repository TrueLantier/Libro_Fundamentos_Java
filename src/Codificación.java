public class Codificación {
    public static void main(String[] args) {
        String msj = "Esta es una prueba.";
        String codmsj = "";
        String decmsj = "";
        int key = 77;
        // Interesante, el 77 come caracter.

        System.out.println("Mensaje original: " + msj);

        for ( int i=0; i<msj.length(); i++) {
            codmsj = codmsj + (char) (msj.charAt(i) ^ key);

        }
        System.out.println("Mensaje codificado: " + codmsj);

        for ( int i=0; i<msj.length(); i++) {
            decmsj = decmsj + (char) (codmsj.charAt(i) ^ key);
        }
        System.out.println("Mensaje decodificado: " + decmsj);

    }
}
