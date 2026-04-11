package GenericsMod13.curosmouredevjava;

import java.util.HashMap;

public class Maps {
    static void main() {
        /*
          Almacena conjuntos de pares de valores. Clave-Valor, como los diccionarios de Python.
          Como trabaja con el hash tampoco admite repetidos.
         */

        HashMap<String, String> names = new HashMap<>();
        var numbers = new HashMap<Integer, String>();

        names.put("Angel", "Programador");
        names.put("Betty", "Doctora");
        names.put("Patty", "Doctora");
        names.put("Talía", "Arquitecta");
        names.put("Eduardo", "Programador");

        System.out.println(names.size());
        System.out.println(names);
        System.out.println(names.get("Angel"));
        System.out.println(names.get("Yordanska")); // Devuelve null.
        System.out.println(names.containsKey("Eduardo"));
        System.out.println(names.containsValue("Arquitecta"));
        names.put("Eduardo", "Ingeniero"); // Cambia el valor. Actualiza.
        names.replace("Betty", "Médica"); // Reemplaza el valor si existe.
        names.replace("Patty", "Médica");
        names.putIfAbsent("Tania", "Maestra"); // Poner si no existe.
        System.out.println(names);
        System.out.println(names.values());
        System.out.println(names.keySet());
        names.remove("Eduardo"); // Devuelve/Retorna el valor eliminado. Programador
        System.out.println(names);

        names.clear();
        System.out.println(names);
    }
}
