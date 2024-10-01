package SeungWook;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 파일_정리 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<String,Integer> map = new HashMap<>();
        for(int i =0; i<n; i++){
            String[] file = br.readLine().split("\\.");
            map.put(file[1], map.getOrDefault(file[1], 0)+1);
        }

        List<HashMap.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((entry1,entry2) -> {
            return entry1.getKey().compareTo(entry2.getKey());
        });

        StringBuffer sb = new StringBuffer();
        for(int i =0; i<list.size(); i++){
            sb.append(list.get(i).getKey()).append(" ").append(list.get(i).getValue());
            if (i != list.size()-1) sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
