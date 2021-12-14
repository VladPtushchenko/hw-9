import org.json.simple.*;

import java.io.*;

public class convertToJSON {
    public static void main(String[] args) {
        String fileDir = System.getProperty("user.dir")+ File.separator;

        JSONArray objects = new JSONArray();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileDir+"file.txt"))){
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
        try (FileWriter file = new FileWriter(fileDir+"file.json")) {
            file.write(objects.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
