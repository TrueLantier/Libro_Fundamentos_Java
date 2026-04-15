## `DateTimeFormatter` — Entre fechas y texto

### ¿Por qué existe?

Porque el mundo no guarda fechas en formato ISO. Un usuario venezolano espera ver `13/04/2025`, no `2025-04-13`. Y cuando recibes datos de un formulario o un archivo, vienen como `String` — necesitas convertirlos a `LocalDate` para poder operar.

`DateTimeFormatter` hace las dos direcciones: **fecha → texto** (formatear) y **texto → fecha** (parsear).

---

El formatter que usas para formatear es **el mismo** que usas para parsear. Si el patrón no coincide exactamente con el String, lanza `DateTimeParseException`.

---

### Los símbolos que más vas a usar

| Símbolo | Significa | Ejemplo |
|---|---|---|
| `yyyy` | Año 4 dígitos | 2025 |
| `MM` | Mes numérico | 04 |
| `MMMM` | Mes en texto | abril |
| `dd` | Día 2 dígitos | 13 |
| `EEEE` | Día de semana | domingo |
| `HH` | Hora (24h) | 14 |
| `mm` | Minutos | 30 |
| `ss` | Segundos | 00 |

El error más común: `MM` vs `mm`. Mes vs minutos. Son case-sensitive y Java no te avisa — simplemente produce resultados incorrectos en silencio.

---

### Buena práctica

Los formatters son thread-safe e inmutables. Defínelos como constantes, no los crees dentro de métodos que se llaman repetidamente:

```java
private static final DateTimeFormatter FORMATO_DISPLAY = 
    DateTimeFormatter.ofPattern("dd/MM/yyyy");
```
---