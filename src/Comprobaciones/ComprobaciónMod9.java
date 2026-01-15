package Comprobaciones;

public class ComprobaciónMod9 {
    public static void main(String[] args) {
        // 1: Throwable.
        // 2: La cláusula try-catch se usa cuando un programa es propenso(por diversas razones) a generar
        // un error. En el bloque try se escribe el código y, si ocurre una excepción entonces el
        // programa cambia de ejecución al bloque catch, donde la excepción será capturada y habrá un código de
        // respuesta.
        // 3: No hay bloque try antes de la instrucción catch.
        // 4: Si no se captura una excepción se obtiene la terminación anormal del programa.
        // 5: La excepción de la superclase antecede a la de una subclase en los catch(su orden).
        // 6: Sí, se pueden relanzar excepciones.
        // 7: Falso, es el código ejecutado cuando se termina el bloque try-catch.
        // 8: Todas las excepciones verificadas o personalizadas que descienden de Exception.
        // Las RuntimeException y Error no.
        // 9: Mi clase no es una excepción, puesto que no hereda de Exception.
        // 11: Puede generarse una excepción por un error en la JVM, un error en el programa, o
        // explícitamente mediante una instrucción throws.
        // 12: Error y Exception
        // 13: Permitir que las excpeciones con el mismo código puedan ser capturadas y procesadas por el mismo
        // catch.
        // 14: Mi código no debería generalmente capturar/atrapar excepciones de Error, pues esto significaría
        // que hay serios problemas con la JVM o mi uso de ella.
    }
}
