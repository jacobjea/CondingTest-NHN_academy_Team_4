import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 임진왜란 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        HashMap<String,Integer> map = new HashMap<>();

        String[] correct = br.readLine().split(" ");
        int allCasesCount = (n * (n-1))/2;

        for(int i = 0; i< n; i++){
            map.put(correct[i], i);
        }
        
        int count = 0;
        String[] answer = br.readLine().split(" ");
        for(int i = 0; i< n-1; i++){
            for(int j = i+1; j<n; j++){
                if (map.get(answer[i]) < map.get(answer[j])){
                    count++;
                }
            }
        }
        System.out.println(count + "/" + allCasesCount);
    }
}
