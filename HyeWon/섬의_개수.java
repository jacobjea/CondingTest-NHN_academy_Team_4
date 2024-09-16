/*
1. 아이디어 : bfs

무한반복
    w, h 입력 받기
    0 0 이면 종료
    for r : h 
        line scan
        values = 빈칸으로 split
        for c : w
            map[r][c] = values[c]
    
    isVisited 초기화    
    cnt=0
    for h, w 
        1 && 방문x :
            bfs
            cnt++
    
    cnt 출력

dr, dc 선언
bfs:
    방문 처리
    큐에 넣기
    큐가 빌때까지 반복
        dequeue
        for 8
            nr, nc
            if 1, 방문x, isIn:
                방문 처리
                enqueue

2. 시간 복잡도
testcase * h * w * (v+e) = hw * (v+8v) = hw9v = 50^4 < 2억
 */

import java.io.*;
import java.util.*;


public class 섬의_개수 {
    static int map[][];
    static boolean isVisited[][];
    static int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};
    static int w;
    static int h;

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            // String line = br.readLine();
            // String[] wH = line.split(" ");
            // int w = Integer.parseInt(wH[0]);

            StringTokenizer line = new StringTokenizer(br.readLine(), " ");
            // if(line.equals("0 0")) break;
            w = Integer.parseInt(line.nextToken());
            h = Integer.parseInt(line.nextToken());
            if(w==0 && h==0) break;

            // System.out.printf("h:%d, w:%d\n", h, w);
            map = new int[h][w];
            for (int r=0; r<h; r++) {
                line = new StringTokenizer(br.readLine(), " ");
                for (int c=0; c<w; c++) { // line.length
                    // System.out.printf("c:%d, countTokens():%d\n", c, line.countTokens());
                    map[r][c] = Integer.parseInt(line.nextToken());
                }
            } 

            // for(int i=0; i<h; i++) System.out.println(Arrays.toString(map[i]));
            // System.out.println();

            isVisited = new boolean[h][w];
            int cnt = 0;

            for (int r=0; r<h; r++) {
                for (int c=0; c<w; c++) {
                    if(map[r][c]==1 && !isVisited[r][c]){
                        cnt++;
                        bfs(r, c);
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    static void bfs(int r, int c) {
        isVisited[r][c] = true;

        Queue<Integer> qr = new LinkedList<>();
        Queue<Integer> qc = new LinkedList<>();

        qr.add(r);
        qc.add(c);

        while(!qr.isEmpty()) {
            r = qr.poll();
            c = qc.poll();

            for (int i=0; i<8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr>=0 && nr<h && nc>=0 && nc<w && map[nr][nc]==1 && !isVisited[nr][nc]) {
                    isVisited[nr][nc] = true;
                    qr.add(nr);
                    qc.add(nc);
                }

            }

        }

    }
}