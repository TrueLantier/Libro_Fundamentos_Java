package GenericsMod13.curosmouredevjava;

import java.util.HashSet;

public class Set {
    static void main(String[] args) {
        /*
          Solo almacenan datos únicos.
          No tienen orden (es por el hash).
          Se accede a los elementos de manera mucho más rápida que otras estructuras de datos.
         */

        HashSet<String> names = new HashSet<>();
        var numbers = new HashSet<Integer>();

        System.out.println(names.size());
        names.add("Angel");
        names.add("Angel"); // No se agrega porque es repetido.
        names.add("Eduardo");

        System.out.println(names);
        System.out.println(names.contains("Angel"));
        names.remove("Eduardo");
        System.out.println(names);

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        var countries = new HashSet<String>();
        countries.add("Cuba");
        countries.add("Colombia");
        countries.add("Brasil");

        names.addAll(countries);
        System.out.println(names);
        names.removeAll(countries);

        names.retainAll(countries); // Deja solo los elementos comunes.
    }
}
