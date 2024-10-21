package SeungWook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class 웰컴_키트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] counts = br.readLine().split(" ");

        String[] s = br.readLine().split(" ");
        int t = Integer.parseInt(s[0]);
        int p = Integer.parseInt(s[1]);

        int tCount = 0;

        for (int i = 0; i < 6; i++) {
            int count = Integer.parseInt(counts[i]);
            tCount += count / t;

            if (count % t != 0) {
                tCount++;
            }
        }

        System.out.println(tCount);
        System.out.println(p == 0 ? 0 : n / p + " " + n % p);
    }
}
