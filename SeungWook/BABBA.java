import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BABBA {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // B = BA, A = B
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[45+1][2];
        map[0][0] = 0;
        map[0][1] = 0;

        map[1][0] = 0;
        map[1][1] = 1;

        map[2][0] = 1;
        map[2][1] = 1;

        map[3][0] = 1;
        map[3][1] = 2;

        map[4][0] = 2;
        map[4][1] = 3;

        for(int i = 5; i< map.length; i++){
            map[i][0] = map[i-1][1];
            map[i][1] = map[i-1][0] + map[i-1][1];
        }

        System.out.println(map[n][0] + " " + map[n][1]);
    }
}
