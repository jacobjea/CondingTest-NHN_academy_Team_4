import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 학생_번호 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] array = new String[n];
        for(int i = 0; i< n; i++){
            array[i] = br.readLine(); 
        }

        boolean isValid = false;
        Map<String,Boolean> map = new HashMap<>();
        int k = 1;
        while (!isValid) {
            isValid = true;
            for(String s  : array){
                String subStr = s.substring(s.length()-k);
                if (map.containsKey(subStr)) {
                    map.clear();
                    k++;
                    isValid = false;
                    break;
                }
                else{
                    map.put(subStr, true);
                }
            }
        }
        System.out.println(k);
    }
}
