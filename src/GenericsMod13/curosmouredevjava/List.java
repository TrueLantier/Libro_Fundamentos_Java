package GenericsMod13.curosmouredevjava;

import java.util.ArrayList;
import java.util.Arrays;

public class List {
    static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        var numbers = new ArrayList<Integer>();

        names.add("Angel");
        names.add("Eduardo");
        names.add("Pedraza Ordoñez");
        names.add(null); // Admite adiciones vacías.
        names.add("Angel");
        System.out.println(names);
        System.out.println(names.size() + " " + names.contains("Angel")); // 0 true
        System.out.println(names.getFirst() + " " + names.get(1) + " " + names.getLast());

        names.set(3, "Programador");
        System.out.println(names.getLast());

        numbers.add(0);
        numbers.add(0);
        numbers.add(0);
        numbers.add(0);
        numbers.add(3, 3);
        numbers.remove(4);

        System.out.println(Arrays.toString(numbers.toArray()));


        names.clear();
        System.out.println(names.size());
        numbers.removeAll(numbers);
        System.out.println(numbers.size());

    }
}
