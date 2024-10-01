package SeungWook;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;
public class 영단어_암기는_괴로워 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            String word = br.readLine();
            if (word.length() >= m) {
                map.put(word, map.getOrDefault(word, 0)+1);
            }
        }
        // collection 인터페이스를 상속 받는 자료구조끼리 변환가능
        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((entry1, entry2)-> {
            int frequencyValue = entry2.getValue().compareTo(entry1.getValue());
            if (frequencyValue != 0) return frequencyValue;

            int lengthValue = entry2.getKey().length() - entry1.getKey().length();
            if (lengthValue != 0) return lengthValue;

            return entry1.getKey().compareTo(entry2.getKey());
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<list.size(); i++){
            sb.append(list.get(i).getKey());

            if (i != list.size()-1) {
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
