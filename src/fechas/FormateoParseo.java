package fechas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormateoParseo {
    LocalDate hoy = LocalDate.now();

    // Formatear Fecha -> String
    public void formatear() {
        // Formato ISO por defecto (lo que usa parse() sin formatter)
        DateTimeFormatter iso = DateTimeFormatter.ISO_LOCAL_DATE;
        hoy.format(iso); // "2025-04-13"

        // Formato personalizado
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        hoy.format(fmt); // "13/04/2025"

        // Más elaborado
        DateTimeFormatter largo =
                DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM 'de' yyyy", new Locale("es"));
        hoy.format(largo); // "domingo, 13 de abril de 2025"
    }

    // Parsear String -> Fecha
    public void parsear() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate fecha = LocalDate.parse("25/12/2025", fmt);
    }
}
