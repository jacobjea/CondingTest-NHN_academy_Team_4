package SeungWook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class 돌_게임3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        boolean[] isWins = new boolean[1000+1];

        isWins[0] = false;
        isWins[1] = true;
        isWins[2] = false;
        isWins[3] = true;
        isWins[4] = true;
        isWins[5] = true;

        for(int i =6; i<isWins.length; i++){
            if (!isWins[i-1] || !isWins[i-3] || !isWins[i-4]) {
                isWins[i] = true;
                continue;
            }
            isWins[i] = false;
        }

        System.out.println(isWins[n] ? "SK" : "CY");
    }
}
