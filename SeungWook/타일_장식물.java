package SeungWook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class 타일_장식물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] map = new long[80+1];
        
        map[0] = 0;
        map[1] = 1;
        map[2] = 1;
        map[3] = 2;
        map[4] = 3;
        for(int i =5; i<map.length; i++){
            map[i] = map[i-1] + map[i-2];
        }
        
        if (n == 1) {
            System.out.println(4);
            return;
        }
        if (n == 2) {
            System.out.println(6);
            return;
        }
        long result = 2 * (map[n] + map[n-1]) + 2 * (map[n-1] + map[n-2]);
        System.out.println(result);
    }
}
