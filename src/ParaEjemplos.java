public class ParaEjemplos {
    public static void main(String[] args) {
        System.out.println( "Hay " + args.length + " argumentos de línea de comandos." );
        System.out.println("Son");
        for ( int i = 0; i< args.length; i++) {
            System.out.println( "arg[" + i + "]: " + args[i] );
        }
    }
}
