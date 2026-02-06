package IOMod10.CharacterStreams;
import java.nio.charset.Charset;

public class VerCharset {
    public static void main(String[] args) {
        String charsetPorDefecto = Charset.defaultCharset().name();

        System.out.println(charsetPorDefecto);
    }
}
