package search.bfsDfs;

/*
1. 아이디어 - dfs
x, y -> y, x로 배열에 표시

isvisited[][]
List<int> cnts
Integer cnt

for n for m : 
	if !isVisited[i][j] && !map :
		cnt = 1
		dfs(i, j, cnt)
		cnts.add(cnt)

dfs(r, c, cnt) :
	isVisited = true
	for 4:
		nr = r + dr[i] 
		nc = c + dc[j]
		
		if isIn && !isVisited !map :
			isVisited = true
			dfs(nr, nc, cnt+1)

print(cnts.size)

2. 시간 복잡도
mn * mn+4mn = mn * 5mn = O((mn)^2)) = 10000^2 = 100000000 < 2억

3. 자료구조
map : boolean[][]
각 영역 크기 : List<Integer> cnts
방문 체크 : boolean[][]

 */
import java.util.*;
public class 영역_구하기 {
	static int m, n, k;
	static boolean[][] map, isVisited;
	static List<Integer> cnts;
	static Integer cnt;
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		k = sc.nextInt();
		
		map = new boolean[m][n];
		
		for(int i=0; i<k; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			for(int r=y1; r<y2; r++) {
				for(int c=x1; c<x2; c++) {
					map[r][c] = true;
				}
			}
		}
		
//		for(int i=0; i<m; i++) {
//			for(int j=0; j<n; j++) {
//				if (map[i][j]) {
//					System.out.print("1 ");
//				}
//				else { System.out.print("0 "); }
//			}
//			System.out.println();
//		}
		
		isVisited = new boolean[m][n];
		cnts = new ArrayList<>();
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if (!isVisited[i][j] && !map[i][j]) {
					cnt = Integer.valueOf(1);
//					System.out.printf("dfs(%d, %d) cnt: %d\n", i, j, cnt);
					dfs(i, j);
					cnts.add(cnt);
				}
			}
		} 
		
		System.out.println(cnts.size());
		Collections.sort(cnts);
		for(int cnt : cnts) System.out.print(cnt + " ");
	}

	private static void dfs(int r, int c) {
		isVisited[r][c] = true;
		for (int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr>=0 && nr<m && nc>=0 && nc<n && !isVisited[nr][nc] && !map[nr][nc]) {
//				System.out.printf("재귀 START (%d, %d) cnt: %d\n", nr, nc, cnt);
				isVisited[nr][nc] = true;
				dfs(nr, nc);
				cnt++;
			}
		}
		
	}

}