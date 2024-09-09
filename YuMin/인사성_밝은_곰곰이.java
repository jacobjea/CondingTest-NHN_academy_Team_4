import java.io.*;
import java.util.*;

public class 인사성_밝은_곰곰이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> set = new TreeSet<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (s.equals("ENTER")) {
                count += set.size();
                set.clear();
                continue;
            }
            set.add(s);
        }
        count += set.size();

        System.out.println(count);
    }
}
