package IOMod10.CharacterStreams;
import java.io.*;
import java.nio.charset.StandardCharsets;

class Help {
    String helpfile; // Nombre del archivo de ayuda.

    Help(String helpfile) {
        this.helpfile = helpfile;
    }

    boolean helpOn(String what) {
        int ch;
        String topic, info;

        try (BufferedReader helpBR = new BufferedReader(new FileReader(helpfile))){
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
        String tema = "";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        System.out.println("Escriba el tema: ");
        try {
            tema = br.readLine();
        } catch (IOException e) {
            System.out.println("Error leyendo la consola.");
        }
        return tema;
    }
}

public class FileHelp {
    public static void main(String[] args) {
        Help hlpobj = new Help("helpfile.txt");
        String topic;

        System.out.println("Prueba el sistema de ayuda. Ingresa 'stop' para terminar.");
        do {
            topic = hlpobj.getSelection();
            if (!hlpobj.helpOn(topic)) {
                System.out.println("Tema no encontrado.\n");
            }
        }   while (topic.compareTo("stop") != 0);
    }
}
