import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 여우는_어떻게_울지 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        
        for(int i = 0; i< n; i++){
            HashMap<String, Boolean> map = new HashMap<>();
            
            String[] cryings = br.readLine().split(" ");
            
            while (true) {
                String line = br.readLine();
                if (line.equals("what does the fox say?")) break;

                String[] animalCryings = line.split(" goes ");
                if (!map.containsKey(animalCryings[1])) {
                    map.put(animalCryings[1], true);
                }
            }

            StringBuffer sb = new StringBuffer();
            for(String s : cryings){
                if (!map.containsKey(s)) {
                    sb.append(s).append(" ");
                }
            }

            System.out.println(sb.toString().trim());
        }
    }
}
