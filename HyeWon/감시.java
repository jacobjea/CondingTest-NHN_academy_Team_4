package implementation;

import java.util.*;

/*
10:20 ~ 11 3
11 20 ~ 12 10
12 16 ~ 1:23
43+50+67=160


1. 아이디어 : 백트랙킹
노드 : 카메라 번호
가지 : 카메라 회전 방향 케이스 (상우하좌)
종료 조건 : 카메라 번호 == 카메라 개수

2. 시간 복잡도
카메라 최대 8개
가지 4개
4^8 = (2^2)^8 = 2^16 = 2^6 * 2^10 > 64 * 1000 = 64000

3. 흐름
맵 세팅 (가장자리 벽 처리, 경계 체크 안하기 위해)

카메라 위치들을 리스트에 세팅

*방향 : [상,우,하,좌]
카메라 종류 : [ [], [1], [1,3], [0,1], [0,1,3], [0,1,2,3] ]
	CCTV의 번호가 1~5로 주어지므로 0번 인덱스는 사용x

dfs(0, 빈 리스트)

dfs(cctvN, cctv)
	cctvN == 카메라 개수
		사각지대 개수 구하고 min 업데이트
		종료
	
	// N번째 cctv (cctvN) 을 얼마나 회전 : 케이스 4 가지
	// 팁: for x : 비교 연산만 많아짐
	dfs(cctvN+1, cctv + [0]) 0도 회전 (그대로)
	dfs(cctvN+1, cctv + [1]) 90도 회전
	dfs(cctvN+1, cctv + [2]) 180도 회전
	dfs(cctvN+1, cctv + [3]) 270도 회전

dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]

int calBlind(cctv):
	visited 초기화
	
	for 카메라 개수 만큼
		rot = cctv[i]
		cr, cc <- 카메라 위치들[i]
		type = map[cr][cc]
		
		for t : 카메라 종료[type]
			t = (t+rot)%4
			nr, nc = cr, cc
			
			while true
				nr = nr + dr[t]
				nc = nc + dc[t]
				nr, nc가 벽이면 break
				방문 체크
	
	cnt = 0
	visited에서 방문 안했고 0이면 cnt++
			
 */

public class 감시 {
	static int N, M;
	static int[][] map;
	// 카메라 종류 : CCTV의 번호가 1~5로 주어지므로 0번 인덱스는 사용x
	static List<Integer>[] cctvSort = new ArrayList[] {
		    new ArrayList<>(),  // 첫 번째 ArrayList 초기화
		    new ArrayList<>(List.of(1)),  // 두 번째 ArrayList 초기화
		    new ArrayList<>(List.of(1,3)),  // 세 번째 ArrayList 초기화
		    new ArrayList<>(List.of(0,1)),  // 네 번째 ArrayList 초기화
		    new ArrayList<>(List.of(0,1,3)),  // 다섯 번째 ArrayList 초기화
		    new ArrayList<>(List.of(0,1,2,3))   // 여섯 번째 ArrayList 초기화
		};
	static List<int[]> cctvPositions;
	static int cctvCnt;

	// 방향 : [상,우,하,좌]
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static int min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N+2][M+2]; // 가장자리에 경계 추가하기 위해 사이즈를 +2
		
		Arrays.fill(map[0], 6);
		for(int i=1;i<=N; i++) {
			map[i][0] = 6;
			for(int j=1; j<=M; j++) {
				map[i][j] = sc.nextInt();
			}
			map[i][M+1] = 6;
		}
		Arrays.fill(map[N+1], 6);

		// cctv 위치 저장
		cctvPositions = new ArrayList<>();
		for(int i=1;i<=N; i++) {
			for(int j=1; j<=M; j++) {
				// cctv에 해당하면
				if(map[i][j]>=1 && map[i][j]<=5) {
					cctvPositions.add(new int[] {i, j});
				}
			}
		}
		
		cctvCnt = cctvPositions.size();
		
		min = N*M;

		
//		// 카메라 종류 세팅
//		cctvSort[1] = List.of(1);
//		cctvSort[2] = List.of(1, 3);
//		cctvSort[3] = List.of(0, 1);
//		cctvSort[4] = List.of(0, 1, 3);
//		cctvSort[5] = List.of(0, 1, 2, 3);
		
		dfs(0, new ArrayList<>());
		
		System.out.println(min);
	}

	// accum : cctv 쌓아감
	private static void dfs(int cctvN, ArrayList<Integer> accum) {
		// 종료 조건
		if (cctvN == cctvCnt) {
			min = Math.min(min, cal(accum));
			return;
		}
		
		dfs(cctvN+1, addToList(accum, 0));
		dfs(cctvN+1, addToList(accum, 1));
		dfs(cctvN+1, addToList(accum, 2));
		dfs(cctvN+1, addToList(accum, 3));
		
	}

	private static ArrayList<Integer> addToList(ArrayList<Integer> accum, int rot) {
		ArrayList<Integer> tmp= new ArrayList<>(accum);
		tmp.add(rot);
		return tmp;
	}

	private static int cal(ArrayList<Integer> cctv) {
		boolean[][] visited = new boolean[N+2][M+2];
		
		// cctv 개수만큼 반복
		for(int i=0; i<cctvCnt; i++) {
			int rot = cctv.get(i); // 0~3 (상,우,하,좌)
			
			// i번째 cctv 위치
			int cr = cctvPositions.get(i)[0]; // 변수명 : current row
			int cc = cctvPositions.get(i)[1]; // 변수명 : current column
			
			int type = map[cr][cc]; // 카메라 타입 (1~5)
			
			for(int s : cctvSort[type]) {
				s = (s+rot)%4;
				
				int nr = cr;
				int nc = cc;
				
				while (true) {
					nr += dr[s];
					nc += dc[s];
					if(map[nr][nc] == 6) break;
					visited[nr][nc] = true;
				}
			}
			
		}
		
		int cnt = 0;
		for(int i=1;i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(!visited[i][j] && map[i][j]==0) {
					cnt++;
				}
			}
		}
		
		return cnt;
	}

}
