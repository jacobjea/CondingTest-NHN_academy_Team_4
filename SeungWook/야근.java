import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class 야근 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        map.put("STRAWBERRY", 0);
        map.put("BANANA", 0);
        map.put("LIME", 0);
        map.put("PLUM", 0);

        for(int i = 0 ; i< n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String fruit = st.nextToken();
            int count = Integer.parseInt(st.nextToken());
            map.put(fruit, map.get(fruit) + count);
        }

        for(var entry : map.entrySet()){
            if (entry.getValue() == 5) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
