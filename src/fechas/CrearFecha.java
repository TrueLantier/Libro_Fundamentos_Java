package fechas;

import java.time.LocalDate;
import java.time.Month;
import java.time.*;

public class CrearFecha {
    // 1. Hoy
    LocalDate hoy = LocalDate.now();

    // 2. Fecha específica
    LocalDate navidad = LocalDate.of(2025, 12, 25);
    // o con el enum Month (más legible)
    LocalDate navidadNueva = LocalDate.of(2025, Month.DECEMBER, 25);

    // 3. Desde un String (el formato debe coincidir exactamente)
    LocalDate fecha = LocalDate.parse("2025-04-13"); // ISO 8601 por defecto

    /*
      Extraer información. Se pone en un método porque el compilador espera en una clase solo ver declaraciones
      de campos o métodos.
     */

    public void extraerInformación() {
        hoy.getYear();        // 2026
        hoy.getMonth();       // APRIL (enum)
        hoy.getMonthValue();  // 4 (int)
        hoy.getDayOfMonth();  // 13
        hoy.getDayOfWeek();   // SUNDAY (enum)
    }

    // Manipular
    LocalDate mañana        = hoy.plusDays(1);
    LocalDate próximoMes    = hoy.plusMonths(1);
    LocalDate añoPasado     = hoy.minusYears(1);
    LocalDate vencimiento   = hoy.plusWeeks(2); // útil para préstamos

    // Comparar
   public void comparar() {
       LocalDate prestamo    = LocalDate.of(2025, 4, 1);
       LocalDate vencimiento = LocalDate.of(2025, 4, 15);
       LocalDate hoy         = LocalDate.now();

       prestamo.isBefore(vencimiento);  // true
       hoy.isAfter(vencimiento);        // depende de cuándo corras esto
       prestamo.isEqual(hoy);           // false

       // También puedes usar compareTo() — devuelve negativo, 0, o positivo
       prestamo.compareTo(hoy);
   }
}
