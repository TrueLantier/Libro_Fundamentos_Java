public class ParaEjemplos {
    public static void main(String[] args) {
        String tels[][] = {
                { "Juan", "5555-3322"},
                { "Mary", "5555-8976"},
                { "Jaime", "5555-1037"},
                { "Raquel", "5555-1400"},
        };
        int i;
        if (args.length != 1) {
            System.out.println("Uso: java Teléfono <nombre>");
        }   else {
            for ( i=0; i< tels.length; i++){
                if ( tels[i][0].equals(args[0]) ) {
                    System.out.println( tels[i][0] + ": " + tels[i][1] );
                    break;
                }
            }
            if ( i == tels.length ) {
                System.out.println("El nombre no se encuentra.");
            }
        }
    }
}
