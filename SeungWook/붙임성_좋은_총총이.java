package SeungWook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 붙임성_좋은_총총이 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // String[] tastCase = br.readLine().split("\n");
        HashMap<String,Boolean> map = new HashMap<>();
        map.put("ChongChong", true);

        for(int i = 0; i< n; i++){
            String[] s = br.readLine().split(" ");
            // String[] s = tastCase[i].split(" ");
            if (map.containsKey(s[0])) {
                map.put(s[1], true);
            }

            if (map.containsKey(s[1])) {
                map.put(s[0], true);
            }
        }

        System.out.println(map.size());
    }
}
