package IOMod10.CharacterStreams;
import java.io.*;
import java.nio.charset.StandardCharsets;

class Help {
    private String helpfile; // Nombre del archivo de ayuda.

    Help(String helpfile) {
        this.helpfile = helpfile;
    }

    boolean helpOn(String what) {
        int ch;
        String topic, info;

        try (BufferedReader helpBR = new BufferedReader(new FileReader(helpfile))) {
            do {
                ch = helpBR.read();

                if (ch == '#') {
                    topic = helpBR.readLine();
                    if (what.compareTo(topic) == 0) {
                        do {
                            info = helpBR.readLine();
                            if (info != null) System.out.println(info);
                        }   while ((info != null) && (info.compareTo("") != 0));
                        return true;
                    }
                }
            }   while (ch != -1);
        }   catch (IOException e) {
            System.out.println("Error accediendo al archivo.");
            return false;
        }
        return false;
    }

    String getSelection() {
        String topic = "";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        System.out.println("Escriba el tema: ");
        try {
            topic = br.readLine();
        } catch (IOException e) {
            System.out.println("Error leyendo la consola.");
        }
        return topic;
    }
}

public class FileHelp {
    public static void main(String[] args) {
        String ruta = "src/IOMod10/CharacterStreams/helpfile.txt";
        Help hlpObj = new Help(ruta);
        String topic;

        System.out.println("Prueba el sistema de ayuda. Ingresa 'stop' para terminar.");
        do {
            topic = hlpObj.getSelection();
            if (!hlpObj.helpOn(topic)) {
                System.out.println("Tema no encontrado.\n");
            }
        }   while (topic.compareTo("stop") != 0);
    }
}
