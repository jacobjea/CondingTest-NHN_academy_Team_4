import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 가희와_키워드 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        HashMap<String, Boolean> map = new HashMap<>();
        for(int i = 0; i <n; i++){
            map.put(br.readLine(), true);
        }

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i <m; i++){
            String[] keywords = br.readLine().split(",");
            for(int j = 0; j< keywords.length; j++){
                if (map.containsKey(keywords[j])) {
                    map.remove(keywords[j]);
                }
            }
            sb.append(map.size());
            if (i != m-1) {
               sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
