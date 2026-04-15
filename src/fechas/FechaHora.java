package fechas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class FechaHora {
    // Ahora mismo
    LocalDateTime ahora = LocalDateTime.now();

    // Valor específico
    LocalDateTime dt = LocalDateTime.of(2025, Month.DECEMBER, 25, 9, 30, 0);
    //                                       año    mes                       día       H         M          S

    // Combinando objetos que ya tienes
    LocalDate fecha = LocalDate.of(2025, 4, 13);
    LocalTime hora  = LocalTime.of(14, 30);
    LocalDateTime dt2  = LocalDateTime.of(fecha, hora);

    // Desde String
    LocalDateTime dt3 = LocalDateTime.parse("2025-04-13T14:30:00"); // ISO por defecto

    // Extraer, manipular y comparar.
    public void manipular() {
        LocalDateTime ahora = LocalDateTime.now();

        // Extraer
        ahora.getHour();    // 14
        ahora.getMinute();  // 30
        ahora.getSecond();  // 0

        // Manipular — misma lógica inmutable
        LocalDateTime despues = ahora.plusHours(3).plusMinutes(30);

        // Comparar — mismos métodos
        ahora.isBefore(despues);  // true
    }

    // Separar cuando lo necesito.
    LocalDateTime ahora2 = LocalDateTime.now();

    LocalDate soloFecha = ahora2.toLocalDate();
    LocalTime soloHora  = ahora2.toLocalTime();

    // Formatear con DateTimeFormatter
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    LocalDateTime ahora3 = LocalDateTime.now();
    String texto = ahora3.format(fmt);        // "13/04/2025 14:30:00"

    LocalDateTime dt4 = LocalDateTime.parse("13/04/2025 14:30:00", fmt);
}
