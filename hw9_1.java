import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class hw9_1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("F:\\file.txt"))) {
            String s;
            String pattern = "^((\\(\\d{3}\\)[ ]?)|(\\d{3}[-]))?\\d{3}[-]\\d{4}";
            while ((s = br.readLine()) != null) {
                Matcher matcher = Pattern.compile(pattern).matcher(s);
                if(matcher.find()) {
                    System.out.println(matcher.group(0));
                }
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}

