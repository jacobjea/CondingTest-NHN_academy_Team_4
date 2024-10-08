/*
1. 아이디어 : bfs

while(true)
    for r, c : 치즈가 없으면 반복 종료
    hours++
    방문 기록 초기화
    bfs(0, 0) # 0, 0 은 치즈가 없기 때문
    for visitCnt
        2이상이면 녹이기

hours 출력

bfs(startR, startY)
    startR, startY 방문 처리
    enqueue
    while(큐 빌때까지) 
        r, c = dequeue
        for 4
            if 범위 벗어나면 continue
            if 치즈 아니고, 
                방문 안 했으면 
                    nr, nc 방문 처리
                    nr, nc enqueue
            else (치즈이면) 방문++

2. 시간 복잡도
전체 반복 : 100 * 100 / 4
    치즈가 다 녹았는지 확인 : 100*100
    bfs : v+e = v+4v = 5v = 5*100^2

3. 자료구조
방문 횟수 : int[][]
    치즈면 방문할 때마다 증가
    아니면 방문유무만 표시
모눈종이 : boolean[][]
6 40
7 21 
 */

import java.io.*;
import java.util.*;

public class 치즈 {
    static int n, m;
    static boolean[][] grid;
    static int[][] visitCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new boolean[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                String val = st.nextToken();
                if(val.equals("0")) grid[i][j] = false;
                else grid[i][j] = true;
            }
        }

        int hours = 0;

        while(true) {
            boolean isEnd = true;
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if(grid[i][j]) {
                        isEnd = false;
                        break;
                    }
                }
                if(!isEnd) break;
            }
            if(isEnd) break;

            hours++;
            visitCnt = new int [n][m];
            bfs(0, 0);

            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(visitCnt[i][j]>=2) grid[i][j] = false;
                }
            }
        }

        System.out.println(hours);
    }    

    static public void bfs(int sr, int sc) {
        visitCnt[sr][sc] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int [] {0,0});

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        while(!q.isEmpty()) {
            int[] pos = q.poll();
            int r = pos[0];
            int c = pos[1];
            for(int d=0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr<0 || nr>=n || nc<0 || nc>=m) continue;
                if (grid[nr][nc]) visitCnt[nr][nc]++;
                else {
                    if (visitCnt[nr][nc]==0) {
                        visitCnt[nr][nc] = 1;
                        q.add(new int [] {nr, nc});
                    }
                }
            }
        }
    }
}
