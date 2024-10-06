import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class 동일한_단어_그룹화하기 {
        public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        for(int i = 0 ; i < n; i++){
            String[] s = br.readLine().split("");
            Arrays.sort(s);
            String newS = String.join("", s);
            set.add(newS);
        }

        System.out.println(set.size());
    }
}
