import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.io.IOException;

public class 피시방_알바 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        for(int i = 0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            if (set.contains(num)) {
                count++;
            }
            else{
                set.add(num);
            }
        }
        System.out.println(count);
    }
}
