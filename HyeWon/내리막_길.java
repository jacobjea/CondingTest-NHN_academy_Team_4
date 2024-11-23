/*
1. 아이디어 : dfs, dp(중복 호출 방지)
입력 받으 지도에 패딩 : 범위 체크 안하려고
    값: 0 (그래야 sum 영향도 없고 내리막길일 수도 없음)

dp[][] 초기화 : -1
    -1: 계산이 아직 안된 곳
    0~ : 계산 된 값 ;현재 지점까지의 경우의 수

dp[1][1] : 1로 초기화
    그래야 인접 좌표가 내리막길이면 sum 가능

dfs(n,m)

dfs(ci, cj):
    dp[ci, cj] == -1: // 계산
        dp[ci, cj] = 0
        for 4
            pi, pj 초기화(di, djf로)
            if 내리막길 이면: // map[ci, cj] < map[pi, pj]
                dp[ci, cj] += dfs(pi, pj)
    return dp[ci, cj]


 */
import java.util.*;
import java.io.*;

public class 내리막_길 {
    static int[][] dp;
    static int[][] map;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        map = new int[m+2][n+2];

        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        for(int i=0; i<m+2; i++) {
//            map[i][0] = -1;
//            map[i][n+1] = -1;
//        }
//
//        for(int i=0; i<n+2; i++) {
//            map[0][i] = -1;
//            map[m+1][i] = -1;
//        }

        dp = new int[m+2][n+2];
        for(int i=0; i<m+2; i++){
            Arrays.fill(dp[i], -1);
        }

        dp[1][1] = 1;

        System.out.println(dfs(m, n));

    }
    public static int dfs(int cr, int cc){
        if (dp[cr][cc] == -1) {
            dp[cr][cc] = 0;
            for (int d=0; d<4; d++) {
                int pr = cr + dr[d];
                int pc = cc + dc[d];

                if(map[cr][cc] < map[pr][pc]){
                    dp[cr][cc] += dfs(pr, pc);
                }
            }
        }
        return dp[cr][cc];
    }
}
