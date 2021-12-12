import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Map.Entry;



public class hm9_3 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("F:\\file.txt"))) {
            String s;
            String text="";
            while ((s = br.readLine()) != null) {
                text=text.concat(s+" ");
            }
            text = text.replace("-","").replaceAll("\\s{2,}", " ").trim();;
            Map<String, Integer> wordsCounter = new HashMap<>();
            for (String word : text.split(" "))
            {
                if(wordsCounter.containsKey(word)){
                    wordsCounter.put(word,wordsCounter.get(word)+1);
                }else{
                    wordsCounter.put(word,1);
                }
            }

            Map<String, Integer> sortedMapDesc = sortByValue(wordsCounter);
            printMap(sortedMapDesc);
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

    }
    private static Map<String, Integer> sortByValue(Map<String, Integer> unSortMap)
    {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(unSortMap.entrySet());

        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()) == 0
        ? o2.getKey().compareTo(o1.getKey())
        : o2.getValue().compareTo(o1.getValue()));
        return list.stream().collect(Collectors.toMap(Map.Entry::getKey, Entry::getValue, (a, b) -> b, LinkedHashMap::new));

    }

    private static void printMap(Map<String, Integer> map)
    {
        map.forEach((key, value) -> System.out.println(key + " " + value));
    }
}
