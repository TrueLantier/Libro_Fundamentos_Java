package Mod9Excepciones;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FuncionesNuevas {

// TRY-WITH-RESOURCES

/* Sintaxis
try (Recurso recurso1 = new Recurso();
     Recurso recurso2 = new Recurso()) {
    // usar recursos
} catch (Exception e) {
    // manejar excepciones
}
 */

// Ejemplo 1. Básico

    void leerArchivo(String ruta) {
        // El FileReader se cierra automáticamente
        try (FileReader reader = new FileReader(ruta)) {
            int caracter;
            while ((caracter = reader.read()) != -1) {
                System.out.print((char) caracter);
            }
        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }
        // ¡No necesitamos finally para cerrar!
    }

    //Ejemplo 2. Múltiples recursos

    public void copiarArchivo(String origen, String destino) {
        // Ambos recursos se cerrarán automáticamente en orden inverso
        try (FileInputStream fis = new FileInputStream(origen);
             FileOutputStream fos = new FileOutputStream(destino)) {

            byte[] buffer = new byte[1024];
            int bytesLeidos;

            while ((bytesLeidos = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesLeidos);
            }

            System.out.println("Copia completada");

        } catch (IOException e) {
            System.out.println("Error en copia: " + e.getMessage());
        }
    }

    //Ejemplo 3. Recursos personalizados

    // Creando nuestro propio recurso AutoCloseable
    class MiRecurso implements AutoCloseable {
        private String nombre;

        public MiRecurso(String nombre) {
            this.nombre = nombre;
            System.out.println("Abriendo recurso: " + nombre);
        }

        public void usar() {
            System.out.println("Usando recurso: " + nombre);
            if (nombre.equals("error")) {
                throw new RuntimeException("Error usando el recurso");
            }
        }

        @Override
        public void close() {
            System.out.println("Cerrando recurso: " + nombre);
            // Lógica de limpieza aquí
        }
    }

    // Uso
    public class EjemploRecursosPersonalizados {
        public void metodo(String[] args) {
            // Todos se cerrarán incluso si hay excepción
            try (MiRecurso r1 = new MiRecurso("r1");
                 MiRecurso r2 = new MiRecurso("r2");
                 MiRecurso r3 = new MiRecurso("error")) {

                r1.usar();
                r2.usar();
                r3.usar(); // Lanza excepción

            } catch (Exception e) {
                System.out.println("Excepción capturada: " + e.getMessage());
            }
            // Output:
            // Abriendo r1, Abriendo r2, Abriendo error
            // Usando r1, Usando r2
            // Cerrando error, Cerrando r2, Cerrando r1 (en orden inverso)
            // Excepción capturada: Error usando el recurso
        }
    }

    // multi-catch

    /*
    try {
    // código que puede lanzar varias excepciones
} catch (IOException | SQLException | ParseException e) {
    // manejo común para todas estas excepciones
}
     */

    public class ProcesadorAvanzado {

        public void procesarTransaccionBancaria(String archivoEntrada,
                                                String archivoSalida)
                throws IOException, SQLException, TransaccionException {

            // TRY-WITH-RESOURCES con múltiples recursos
            try (Connection conn = obtenerConexion();
                 FileReader reader = new FileReader(archivoEntrada);
                 FileWriter writer = new FileWriter(archivoSalida)) {

                // Procesamiento que puede lanzar varias excepciones
                procesarTransacciones(conn, reader, writer);

            } catch (FileNotFoundException | EOFException e) {
                // MULTI-CATCH: manejo similar para errores de archivo
                System.err.println("Error de archivo: " + e.getMessage());
                throw new TransaccionException("Archivo inválido", e);

            } catch (IOException | SQLException e) {
                // MULTI-CATCH para errores de E/S y base de datos
                System.err.println("Error de sistema: " + e.getMessage());

                // FINAL RETHROW: relanzamos con tipo preciso
                // Java sabe que 'e' es IOException o SQLException
                throw e;

            } catch (Exception e) {
                // Cualquier otra excepción
                System.err.println("Error inesperado: " + e.getMessage());
                throw new TransaccionException("Error desconocido", e);
            }
        }

        private Connection obtenerConexion() throws SQLException {
            return DriverManager.getConnection("jdbc:mysql://localhost/banco");
        }

        private void procesarTransacciones(Connection conn,
                                           Reader reader,
                                           Writer writer)
                throws IOException, SQLException {
            // Lógica compleja de procesamiento
        }
    }

    class TransaccionException extends Exception {
        public TransaccionException(String mensaje, Throwable causa) {
            super(mensaje, causa);
        }
    }
}