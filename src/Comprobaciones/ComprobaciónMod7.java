package Comprobaciones;

import Proyecto1.Serie;

public class ComprobaciónMod7 {
    public static void main(String[] args) {
        // 1: Una superclase no tiene acceso a los miembros de una subclase. Una subclase sí tiene acceso
        // a todos los miembros de la superclase que no sean privados.
        // 3: Haciéndolos privados.
        // 4: Primero en los constructores de las subclases, llaman al constructor de la superclase
        // e inicializan la parte del objeto correspondiente. Se puede usar también en los métodos sobreescritos
        // para llamar al método de la subclase y que se ejecute también, en general para llamar a miembros de las
        // superclases.
        // 5: Clase Alfa, clase Beta, clase Gamma
        // 6: Esto es importante porque en ocasiones lo que se se desea realizar es que se ejecute el método de la
        // subclase, no el de la superclase.
        // 7: Una clase abstracta es una clase especial para diseño. De ella no se pueden crear referencias a
        // objetos. Se caracterizan principalmente por tener un método abstracto.
        // 8: Usando la palabra clave "final".
        // 9: Tenemos clase abstracta A, subclase B de A, y subclase C de B.
        // Con la clase A se declara un método abstracto, el cual será sobreescrito por B y C.
        // Este método será usado por objetos según hagan referencia. Y sus funciones variarán dependiendo
        // del tipo de llamada. El polimorfismo se evidencia por la distintas(poli) aplicaciones(formas) que
        // tienen métodos con la misma firma y retorno.
        // 10: Object
        // 11: Cierto, si una clase contiene un método abstracto debe declararse abstracta.
        // 12: final , para constantes con nombre.
        // 13: Es de tipo A.
        /*
        El método makeObj() tiene un tipo de retorno declarado (en su firma) de A.
        Esto es lo que el compilador usa para determinar el tipo de la expresión makeObj(1),
        independientemente de la ruta de ejecución que se tome en tiempo de ejecución (new A() o new B()).
        En tiempo de ejecución, makeObj(1) devolverá efectivamente un objeto de tipo B.
        Sin embargo, la referencia almacenada en myRef será de tipo A (la referencia es de tipo superclase,
        apuntando a un objeto de subclase). Esto es polimorfismo clásico.
        Por lo tanto, el compilador infiere que myRef es de tipo A.
        Podrás llamar solo a los métodos definidos en A (a menos que hagas un cast posterior a B).
         */
        // 14: Será de tipo B. Casteo.
        System.out.println(Prueba('a'));
        char myref = (char) Prueba(1);
    }

    static int Prueba(int a) {
        char b = 'b';
        long l = 1L;
        return b;

    }

    static char PruebaDos(char a) {
        int num = 1;
        return (char) num;
    }
}
