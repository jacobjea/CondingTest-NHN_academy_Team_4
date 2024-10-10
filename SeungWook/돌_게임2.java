import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class 돌_게임2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // 상근 sk
        // 창영 cy

        boolean[] map = new boolean[1000+1];
        map[0] = false;
        map[1] = false;
        map[2] = true;
        map[3] = false; // 1,1,1
        map[4] = true; // 3,1
        map[5] = false; // 

        for(int i = 6 ; i<map.length; i++){
            if(map[i-1] && map[i-3]){
                map[i] = false;
            }
            else{
                map[i] = true;
            }
        }
        System.out.println(map[n] ? "SK" : "CY");
    }
}
