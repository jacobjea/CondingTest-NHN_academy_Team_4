import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 배부른_마라토너 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<String,Integer> map = new HashMap<>();
    
        for(int i = 0 ; i< n; i++){
            String line = br.readLine();
            map.put(line, map.getOrDefault(line, 0)+1);
        }

        for(int i = 0 ; i< n-1; i++){
            String line = br.readLine();

            int count = map.get(line);
            if (count == 1) {
                map.remove(line);    
            }
            else{
                map.put(line, count-1);
            }
        }

        String value = map.keySet().stream().findFirst().get();
        System.out.println(value);
    }
}
