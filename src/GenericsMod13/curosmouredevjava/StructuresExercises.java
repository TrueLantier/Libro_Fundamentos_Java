package GenericsMod13.curosmouredevjava;

import java.util.*;
import java.util.List;

public class StructuresExercises {
    static void main() {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        System.out.println(nums);
        nums.remove(3);
        System.out.println(nums);

        HashSet<String> nombres = new HashSet<>();
        nombres.add("Pedro");
        nombres.add("Pablo");
        System.out.println(nombres);
        nombres.add("Pedro");
        nombres.add("Juan");
        nombres.remove("Pablo");
        System.out.println(nombres);

        HashMap<String, Integer> contactos = new HashMap<>();
        contactos.put("Angel", 53133428);
        contactos.put("Patty", 56108079);
        contactos.put("Betty", 52728281);
        contactos.put("Eliminar", 1111);
        System.out.println(contactos);
        contactos.remove("Eliminar");
        contactos.replace("Angel", 666);
        System.out.println(contactos);

        String[] novelas = {
                "The Primal Hunter",
                "Shadow Slave",
                "Advent of the Three Calamities"
        };
        ArrayList<String> novelasList = new ArrayList<>(Arrays.asList(novelas));
        // List.of(novelas); // Ver para qué sirve.
        // ArrayList<String> novelasList =  (ArrayList<String>) Arrays.asList(novelas); // Funciona pero feo.
        /*
         Otra vía:
         ArrayList<String> novelasList = new ArrayList<>();
         Collections.addAll(novelasList, novelas);
         */

        HashSet<String> novelasSet = new HashSet<>(novelasList);
        // novelasSet.addAll(novelasList); // Sirve también.

        HashMap<String, String> novelasMap = new HashMap<>();
        for (String elemento: novelasSet) {
            novelasMap.put(elemento, elemento);
        }

        for (Map.Entry<String, String> novela: novelasMap.entrySet()) {
            System.out.println(novela);
        }
    }
}
