import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 베스트셀러_seungwook {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        for(int i =0; i<n; i++){
            String s = br.readLine();
            if (map.containsKey(s)) {
                map.put(s, map.get(s)+1);
            }
            else{
                map.put(s, 1);
            }
        }

        String bestSeller = "";
        int maxCount = 0;
        for(HashMap.Entry<String,Integer> entry : map.entrySet()){
            String title = entry.getKey();
            int count = entry.getValue();

            if (count > maxCount || (count == maxCount && title.compareTo(bestSeller) < 0)){
                bestSeller = title;
                maxCount = count;
            }
        }
        System.out.println(bestSeller);
    }
}
