package IOMod10.CharacterStreams;
import java.io.*;

class Help {
    String helpfile; // Nombre del archivo de ayuda.

    Help(String helpfile) {
        this.helpfile = helpfile;
    }

//    boolean helpOn(String what) {
//        int ch;
//        String topic, info;
//
//        try (BufferedReader helpBR = new BufferedReader(FileReader(helpfile))){
//            do {
//                ch = helpBR.read();
//
//                if (ch == '#') {
//                    topic = helpBR.readLine();
//                    if (what.compareTo(topic) == 0) {
//                        do {
//                            info = helpBR.readLine();
//                            if (info != null) System.out.println(info);
//                        }   while ((info != null) && (info.compareTo("") != 0));
//                        return true;
//                    }
//                }
//            }   while (ch != -1);
//        }   catch (IOException e) {
//            System.out.println();
//        }
//    }
}

public class FileHelp {
    public static void main(String[] args) {

    }
}
