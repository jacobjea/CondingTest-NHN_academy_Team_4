package search.bfsDfs;

/*
1. 아이디어 : BFS
--입력
ArrayList<LinkedList> 그래프 = new ArrayList<>(정점 개수)

--탐색
boolean[] isVisited = new boolean[정점 개수]
for i, j
	bfs(i, j)
	트루면 sb+1
	아니면 sb+0
	
	+ \n

boolean bfs(start, end):
	방문체크
	큐 <- start
	while(큐가 빌 때까지)
		정점 <- 디큐
		for 정점의 링크들
		 	if 방문x
			방문 처리
			end이면 true 반환
			아니면 enqueue
	false 리턴

2. 시간 복잡도
n * n * (n+e) = n^2 * 2n = 2n^3 = n*3 = 100^3 = 1000000

3. 자료구조
그래프 : LinkedList[]
방문 표시 : boolean[]
 */
import java.util.*;
import java.io.*;
public class 경로_찾기 {
	static ArrayList<List<Integer>> graph;
	static boolean[] isVisited;


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
//		LinkedList<Integer>[] graph
 		graph = new ArrayList<>(n);
 		
 		for(int i=0; i<n; i++) graph.add(i, new LinkedList<>());
		
		for(int i=0; i<n; i++) {
			String[] row = br.readLine().split(" ");
			for(int j=0; j<n; j++) {
				String isOne = row[j];
				if(isOne.equals("1")) graph.get(i).add(j);
			}
			
		}
		
		isVisited = new boolean[n];
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				Arrays.fill(isVisited, false);
				if (bfs(i, j)) sb.append("1 ");
				else sb.append("0 ");
			}
			sb.append("\n");
			
		}	
		System.out.println(sb);
	}
	
	public static boolean bfs(int start, int end) {
//		isVisited[start] = true;
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		while(!q.isEmpty()) {
			int vertex = q.poll();
			for(int next : graph.get(vertex)) {
				if(!isVisited[next]) {
					isVisited[next] = true;
					if(next == end) return true;
					else q.add(next);
				}
			}
		}
		return false;
	}

}
