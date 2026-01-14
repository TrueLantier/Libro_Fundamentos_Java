package Mod9Excepciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class EjemplosVariados {
}

// 1. Error - Errores Graves (NO se deben capturar normalmente)

class ErroresEjemplo {
    public static void main(String[] args) {
        // OutOfMemoryError - Cuando la JVM se queda sin memoria
        try {
            List<byte[]> lista = new ArrayList<>();
            while (true) {
                lista.add(new byte[1024 * 1024]); // 1MB cada vez
            }
        } catch (OutOfMemoryError e) {
            System.out.println("¡Memoria agotada! " + e.getMessage());
            // Aquí podrías intentar liberar memoria o terminar ordenadamente
        }

        // StackOverflowError - Recursión infinita
        try {
            recursionInfinita(0);
        } catch (StackOverflowError e) {
            System.out.println("Stack overflow: " + e.getMessage());
        }

        // NoClassDefFoundError - Clase no encontrada en tiempo de ejecución
        // Ocurre cuando compilas con una clase, pero no está en el classpath al ejecutar
    }

    private static void recursionInfinita(int n) {
        recursionInfinita(n + 1); // ¡Llamada recursiva sin caso base!
    }
}

// 2. RuntimeException (Unchecked/No verificadas)

class RuntimeExceptionEjemplo {

    public void demostrarRuntimeExceptions() {
        // NullPointerException - La más común
        String texto = null;
        try {
            int longitud = texto.length(); // ¡texto es null!
        } catch (NullPointerException e) {
            System.out.println("Error: variable nula. " + e.getMessage());
        }

        // ArrayIndexOutOfBoundsException
        int[] numeros = {1, 2, 3};
        try {
            System.out.println(numeros[5]); // Índice fuera de rango
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Índice de array inválido: " + e.getMessage());
        }

        // ClassCastException
        Object obj = "Soy un String";
        try {
            Integer numero = (Integer) obj; // ¡No se puede convertir String a Integer!
        } catch (ClassCastException e) {
            System.out.println("Error de casteo: " + e.getMessage());
        }

        // NumberFormatException
        try {
            int numero = Integer.parseInt("no-es-un-numero");
        } catch (NumberFormatException e) {
            System.out.println("Formato numérico inválido: " + e.getMessage());
        }

        // ArithmeticException
        try {
            int resultado = 10 / 0; // División por cero
        } catch (ArithmeticException e) {
            System.out.println("Error aritmético: " + e.getMessage());
        }

        // IllegalArgumentException
        try {
            establecerEdad(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Argumento ilegal: " + e.getMessage());
        }
    }

    private void establecerEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa: " + edad);
        }
        // ... lógica normal
    }
}

// 3. Excepciones Verificadas (Checked)

class CheckedExceptionEjemplo {

    // Todas estas deben ser declaradas con throws o manejadas con try-catch

    // IOException y sus subclases
    public void leerArchivo(String ruta) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(ruta));
        // FileNotFoundException es subclase de IOException
        String linea = reader.readLine();
        reader.close();
    }

    // SQLException
    public void consultaBaseDatos() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bd");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios");
        // ... procesar resultados
    }

    // ParseException
    public Date parsearFecha(String fechaStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return (Date) sdf.parse(fechaStr); // Puede fallar si el formato es incorrecto
    }

    // ClassNotFoundException
    public void cargarClaseDinamica() throws ClassNotFoundException {
        Class<?> clase = Class.forName("com.ejemplo.MiClase");
        // La clase debe existir en el classpath
    }

    // InterruptedException
    public void procesoLargo() throws InterruptedException {
        Thread.sleep(5000); // El hilo puede ser interrumpido
        System.out.println("Proceso completado");
    }

    // CloneNotSupportedException
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // Si la clase no implementa Cloneable
        return super.clone();
    }
}

//Ejemplo Completo de Jerarquía Personalizada

// Creando nuestra propia jerarquía de excepciones
class MiExcepcionBase extends Exception {
    public MiExcepcionBase(String mensaje) {
        super(mensaje);
    }
}

// Excepción verificada personalizada
class MiExcepcionVerificada extends MiExcepcionBase {
    public MiExcepcionVerificada(String mensaje) {
        super(mensaje);
    }
}

// Excepción no verificada personalizada
class MiExcepcionNoVerificada extends RuntimeException {
    public MiExcepcionNoVerificada(String mensaje) {
        super(mensaje);
    }
}

// Excepción más específica
class SaldoInsuficienteException extends MiExcepcionVerificada {
    private double saldoActual;
    private double montoRequerido;

    public SaldoInsuficienteException(double saldo, double monto) {
        super(String.format("Saldo insuficiente. Actual: %.2f, Requerido: %.2f",
                saldo, monto));
        this.saldoActual = saldo;
        this.montoRequerido = monto;
    }

    public double getSaldoActual() { return saldoActual; }
    public double getMontoRequerido() { return montoRequerido; }
}

// Uso en una aplicación bancaria
class CuentaBancaria {
    private double saldo;

    public void retirar(double monto) throws SaldoInsuficienteException {
        if (monto > saldo) {
            throw new SaldoInsuficienteException(saldo, monto);
        }
        saldo -= monto;
    }

    public void procesarTransaccion() {
        try {
            retirar(1000);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Faltan: " + (e.getMontoRequerido() - e.getSaldoActual()));
            // Podemos ofrecer alternativas
        }
    }
}