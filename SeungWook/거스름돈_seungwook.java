import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class 거스름돈_seungwook {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] map = new int[100000+1];

        map[0] = -1;
        map[1] = -1;
        map[2] = 1;
        map[3] = -1;
        map[4] = 2;
        map[5] = 1;
        map[6] = 3;
        map[7] = 2;
        map[8] = 4;
        map[9] = 3;

        for(int i = 10; i<map.length; i++){
            map[i] = Math.min(map[i-2], map[i-5]) + 1;
        }

        System.out.println(map[n]);
    }
}
