class Sobre {
    int x;

    Sobre(){
        System.out.println("Sobre()");
        x = 0;
    }
    Sobre(int i) {
        System.out.println("Sobre(int)");
        x = i;
    }
    Sobre(double d) {
        System.out.println("Sobre(double)");
        x = (int) d;
    }
    Sobre(int i, int j){
        System.out.println("Sobre(int, int)");
        x = i * j;
    }
}

    public class ParaEjemplos {
        public static void main(String[] args) {
            Sobre t1 = new Sobre();
            Sobre t2 = new Sobre(8);
            Sobre t3 = new Sobre(10.8);
            Sobre t4 = new Sobre(2, 10);

            System.out.println(t1.x + " " + t2.x + " " + t3.x + " " + t4.x);

        }
    }
