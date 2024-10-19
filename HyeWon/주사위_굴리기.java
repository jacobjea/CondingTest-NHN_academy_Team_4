package implementation;

/*
2:28
4:29
-10

1. 문제 정리
- 주사위의 각 면의 고유 번호
  2
4 1 3
  5
  6
d1 = 위 몃
d3 = 오른쪽 면
d6 = 바닥면
처음에는 각 면의 모든 값 0

- 주사위 굴리기
-- 북쪽으로 굴렸을 때
d2 d1 d5 d6 <- d1 d5 d6 d2
-- 남
2 1 5 6 <- 6 2 1 5
-- 서
4 1 3 6 <- 1 3 6 4
-- 동
4 1 3 6 <- 6 4 1 3

2. 아이디어
for k
	nr, nc <- cr+d[k], cc+d[k]
	if 범위 벗어나면 : continue
	if k==북
		d2 d1 d5 d6 <- d1 d5 d6 d2
	-- 남
		2 1 5 6 <- 6 2 1 5
	-- 서
		4 1 3 6 <- 1 3 6 4
	-- 동
		4 1 3 6 <- 6 4 1 3
		
	if 지도에서 현재 위치의 값이 0
		지도 현재 위치 <- 주사위 바닥 값
	else
		주사위 바닥면 <- 지도의 현재 위치 값
		지도의 현재 위치 값 <- 0
	
	윗면 d1 저장
	cr, cc <- nr, nc
 */
import java.io.*;
import java.util.*;


public class 주사위_굴리기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		
		int cr = Integer.valueOf(st.nextToken());
		int cc = Integer.valueOf(st.nextToken());
		
		int k = Integer.valueOf(st.nextToken());
		
//		System.out.println("Check porint 1");
		
		int[][] map = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.valueOf(st.nextToken());
			}
		}

		int[] d = new int[k];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<k; i++) {
			d[i] = Integer.valueOf(st.nextToken());
		}
//		System.out.println(Arrays.toString(d));
		
		int[] dr = {0, 0, 0, -1, 1};
		int[] dc = {0, 1, -1, 0, 0};
		int[] dice = {0, 0, 0, 0, 0, 0, 0};
		StringBuilder rst = new StringBuilder();
		
		for(int dn : d) {
			int nr = cr + dr[dn];
			int nc = cc + dc[dn];
			if (nr<0 || nr>n-1 || nc<0 || nc>m-1) continue;
			
			int[] tmp = new int[dice.length];
			System.arraycopy(dice, 0, tmp, 0, dice.length);
			
			if (dn == 3) { // 북
				dice[2] = tmp[1];
				dice[1] = tmp[5];
				dice[5] = tmp[6];
				dice[6] = tmp[2];
			}
			else if (dn == 4) { // 남
				dice[2] = tmp[6];
				dice[1] = tmp[2];
				dice[5] = tmp[1];
				dice[6] = tmp[5];
			}
			else if (dn == 2) { // 서
				dice[4] = tmp[1];
				dice[1] = tmp[3];
				dice[3] = tmp[6];
				dice[6] = tmp[4];
			}else { // 동
				dice[4] = tmp[6];
				dice[1] = tmp[4];
				dice[3] = tmp[1];
				dice[6] = tmp[3];
			}
			
			if(map[nr][nc] == 0) {
				map[nr][nc] = dice[6];
			}
			else {
				dice[6] = map[nr][nc];
				map[nr][nc] = 0;
			}
			
			rst.append(dice[1]+"\n");
			
			cr = nr;
			cc = nc;

//			System.out.println("-------" + dn + "------");
//			System.out.println(Arrays.toString(dice));
//			System.out.println("  " + dice[2]);
//			System.out.println(String.format("%d %d %d", dice[4], dice[1], dice[3]));
//			System.out.println("  " + dice[5]);
//			System.out.println("  " + dice[6]);
//			for(int o=0; o<n; o++) {
//				System.out.println(Arrays.toString(map[o]));
//			}
			
//			break;
		}
		
		System.out.println(rst);
	}

}
