package SeungWook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class 영화감독_숌 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 브루트포스로 탐색 (전체 탐색)
        int count = 0;
        int num = 666;

        int result = 0;
        while (count < n) {
            String s = Integer.toString(num);
            if (s.contains("666")) {
                result = num;
                count++;
            }
            num++;
        }
        System.out.println(result);
    }
}
