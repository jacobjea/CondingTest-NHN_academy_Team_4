
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class 돌_게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] isWin = new boolean[1000+1];
        // 첫번째 상근- SK 
        // 두번째 창영- CY
        // 하나 또는 3개 가져간다.
        // 배열 값이 0인 경우이길 수 있다.
        // 0 상근
        // 1 창영
        isWin[0] = false;
        isWin[1] = true;
        isWin[2] = false;
        isWin[3] = true;

        // 4개 이상의 돌에 대해 계산
        for (int i = 4; i <= n; i++) {
            // i개 돌이 있을 때, 상대방이 지는 상태로 만들 수 있는 경우가 있으면 이김
            if (!isWin[i - 1] || !isWin[i - 3]) {
                isWin[i] = true;  // 1개 또는 3개를 가져가서 상대방을 지게 만들 수 있음
            }
        }
        // System.out.println( Arrays.toString(isWin));
        System.out.println(isWin[n] ? "SK" : "CY");
    }
}
