import org.json.simple.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class convertToJSON {
    public static void main(String[] args) {
        JSONArray objects = new JSONArray();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("F://file.txt"))){
            String line = bufferedReader.readLine();
            String [] names = line.split(" ");
            while ((line=bufferedReader.readLine())!=null){
               String [] values = line.split(" ");
                JSONObject obj = new JSONObject();
                for(int i=0;i< names.length;i++) {
                   obj.put(names[i], values[i]);
               }
               objects.add(obj);
            }
        }catch (IOException e){
             System.out.println(e.getMessage());
        }
        try (FileWriter file = new FileWriter("F://file.json")) {
            file.write(objects.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
