package multithreaded;

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
        } catch (Exception e) {
            System.out.println("Más y más y más excepciones.");
        }

        System.out.println();
    }

    public void agregar(ICCHAR icchar) throws Exception{ // Debido a que ColaFijaLlena no es pública.
        for (int i = 0; i < 10; i++) {
            icchar.put((char) ('A' + i));
        }
    }

    public void mostrar(ICCHAR icchar) throws Exception{ // Lo mismo.
        System.out.println("Contenido de cola fija");
        for (int i = 0; i < 10; i++) {
            char ch = icchar.get();
            System.out.print(ch + " ");
        }
    }
}
