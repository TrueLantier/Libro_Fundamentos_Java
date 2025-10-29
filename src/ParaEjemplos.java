public class ParaEjemplos {
    public static void main(String[] args) {
        int result;

        for ( int i = -2; i<3; i++) {
            result = (i != 0) ? (100/i) : 0;
            if (i !=0) {
                System.out.println("100 / " + i + "es " + result);
            }
        }
    }
}
