class Varags{
    static void vaPrueba(int ... v) {
        System.out.println(v.length);
    }
    static void vaPrueba(int a, int ... v) {
        System.out.println(v.length);
    }

//    static void vaPrueba(String msj, int ... v) {
//        System.out.println(msj + v.length);
//    }
}

public class ParaEjemplos {
    public static void main(String[] args) {
        //Varags.vaPrueba("1", 1);

        Varags.vaPrueba();
    }
}
