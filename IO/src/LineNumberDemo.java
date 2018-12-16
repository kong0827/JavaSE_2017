import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class  LineNumberDemo{

    public static void main(String[] args) {
        InputStream in = LineNumberDemo.class.getResourceAsStream("code.txt");
        LineNumberReader reader = new LineNumberReader(new InputStreamReader(in));
        String line;
        try {
            while ((line=reader.readLine()) != null) {
                System.out.println(reader.getLineNumber()+":"+line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
