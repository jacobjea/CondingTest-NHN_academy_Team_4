import java.util.*;
import java.io.*;

public class 베스트셀러 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        String maxKey = null;
        int maxValue = 0;

        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
            else if (entry.getValue() == maxValue) {
                if (entry.getKey().compareTo(maxKey) < 0) {
                    maxKey = entry.getKey();
                }
            }
        }
        
        System.out.println(maxKey);
    }
}