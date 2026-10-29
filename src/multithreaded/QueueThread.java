package multithreaded;

import EstructurasDatosAlgoritmos.*;
import EstructurasDatosAlgoritmos.ICCHAR;

public class QueueThread implements Runnable {
    public Thread thread;
    public ICCHAR icchar;

    public QueueThread(String name) {
        thread = new Thread(this, name);
    }

    @Override
    public void run() {
        try {
            agregar(icchar);
            mostrar(icchar);
        } catch (ColaVacíaExcepción | ColaLlenaExcepción e) {
            System.out.println(thread.getName() + " " + e);
        } catch (Exception e) {
            System.out.println("Otro tipo de excepción.");
        }
    }

    public void agregar(ICCHAR icchar) throws Exception{ // Debido a que ColaFijaLlena no es pública.
        System.out.println("Inicio de " + thread.getName());
        for (int i = 0; i < 10; i++) {
            icchar.put((char) ('A' + i));
        }
    }

    public void mostrar(ICCHAR icchar) throws Exception{ // Lo mismo.
        System.out.println("Contenido de cola fija en " + thread.getName());
        for (int i = 0; i < 10; i++) {
            char ch = icchar.get();
            System.out.print(ch + " ");
        }
        System.out.println();
    }
}
