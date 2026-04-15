Perfecto. Antes de escribir una sola línea, necesitas entender el contexto histórico porque Java tiene **dos APIs de fechas**, y la confusión entre ellas es fuente clásica de bugs.

---

## El pasado que debes conocer para ignorarlo

Java nació en 1995 con `java.util.Date` y `java.util.Calendar`. Ambas son **desastrosas**:

- `Date` es mutable (un objeto de fecha que alguien puede modificar por accidente)
- Los meses en `Calendar` empiezan en 0 (enero = 0, diciembre = 11)
- No distinguen entre "una fecha" y "un instante exacto en el tiempo"
- El manejo de zonas horarias es un desastre

Las vas a ver en código legacy. No las uses en código nuevo. Punto.

---

## La API moderna: `java.time` (Java 8, 2014)

Diseñada desde cero, inmutable, clara. Todo vive en el paquete `java.time`. La clave es entender que hay **varias clases porque representan cosas distintas**:

| Clase | Qué representa |
|---|---|
| `LocalDate` | Solo fecha. Sin hora, sin zona. (2025-04-13) |
| `LocalTime` | Solo hora. Sin fecha, sin zona. (14:30:00) |
| `LocalDateTime` | Fecha + hora. Sin zona. |
| `ZonedDateTime` | Fecha + hora + zona horaria. |
| `Instant` | Un punto exacto en el tiempo (como un timestamp Unix) |
| `Duration` | Diferencia en horas/minutos/segundos |
| `Period` | Diferencia en días/meses/años |

---

## La pregunta más importante antes de elegir una clase

> ¿El dato que estoy modelando **depende de la zona horaria** o no?

Un cumpleaños → `LocalDate`. No importa en qué país estés, tu cumpleaños es el mismo día.

Una reunión de Zoom entre Colombia y España → `ZonedDateTime`. Absolutamente depende de la zona.

La fecha en que se registró un préstamo en tu biblioteca → probablemente `LocalDateTime` si es un sistema local, o `Instant` si es distribuido.

---

## Las operaciones fundamentales

Con cualquiera de esas clases puedes hacer cuatro cosas:

**1. Crear** — desde ahora, desde un valor específico, o parseando un String.

**2. Manipular** — sumar días, restar meses, etc. Al ser inmutables, siempre te devuelven un objeto nuevo, no modifican el original.

**3. Comparar** — saber si una fecha es antes, después, o igual a otra.

**4. Formatear/Parsear** — convertir entre fecha y String. Aquí entra `DateTimeFormatter`.

---

## DateTimeFormatter merece atención especial

Es el puente entre fechas y texto. Tiene dos modos:

- Patrones predefinidos estándar (ISO 8601: `2025-04-13`)
- Patrones personalizados que tú defines (`dd/MM/yyyy`)

Un error común: confundir `MM` (mes) con `mm` (minutos). Son case-sensitive.

---

## Duration vs Period — una distinción que confunde

Ambos representan "un lapso de tiempo" pero son conceptualmente diferentes:

- **Duration**: piensa en un cronómetro. Mide segundos, minutos, horas. Es preciso.
- **Period**: piensa en un calendario. Mide días, meses, años. Es semántico.

¿Cuántos días faltan para que venza un préstamo? → `Period` o simplemente `ChronoUnit.DAYS.between(...)`.
¿Cuántos segundos tardó en responder un servidor? → `Duration`.

---

Una cosa que sorprende a muchos
LocalDate implementa Comparable, entonces puedes ordenar una List<LocalDate> con Collections.sort() o 
con streams sin ninguna configuración extra. Las fechas se ordenan cronológicamente de forma natural.

---

LocalDateTime — Fecha + hora, sin zona
¿Cuándo usarlo en lugar de LocalDate?
Cuando el momento exacto importa. Un préstamo de biblioteca puede vivir con solo fecha. 
Pero un log de sistema, una transacción, o una reserva de sala necesitan saber si fue a las 9am 
o a las 11pm. Ahí entra LocalDateTime.

---

La limitación que debes tener clara
LocalDateTime no sabe nada del mundo real en términos de zonas horarias. Si guardas LocalDateTime.now() en Venezuela 
y lo lees en España, el valor es el mismo número — no hay conversión automática. Para eso existe ZonedDateTime, 
que veremos al final.
Para sistemas locales (una app que corre en una sola región), LocalDateTime es suficiente y es lo que usarás 
el 80% del tiempo.

---

