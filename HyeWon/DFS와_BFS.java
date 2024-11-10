package search.bfsDfs;

/*
1:17
1. 아이디어
List<Integer>[] vertex = new List[n+1];
for n
	vertext[i] = new LinkedList<>[];

for m
	v1, v2 = sc
	vertext[v1].add(v2)
	vertext[v2].add(v1)

boolean [n+1] visited

bfs(start):
	start 방문 처리 
	인큐
	while(큐 빌때까지)
		currV = dequeue
		임시 배열 초기화
		for vertext[currV]
			if 방문 안했으면
				방문 처리
				배열에 넣기
		배열 오름 차순 정렬
		배열 차례대로 출력하고 인큐

dfs(v):
	start 방문 처리
	//스택 푸쉬
	//while(스택 빌떄까지)
	//	currV = 팝
//		min = n
		for graph[v]
			if 방문 안했으면
				dfs(nv)

2. 시간 복잡도
v+e = 1000+10000 = 11000
		

 */
import java.io.*;
import java.util.*;

public class DFS와_BFS {
	static List<Integer>[] graph;
	static int n;
	static boolean [] visited;
	static StringBuilder resultForDfs = new StringBuilder();


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		int startV = Integer.parseInt(line[2]);
		
		graph = new List[n+1];
		for(int i=1; i<n+1; i++) {
			graph[i] = new LinkedList<>(); 
		}
		
		for(int i=0; i<m; i++) {
			line = br.readLine().split(" ");
			int v1 = Integer.parseInt(line[0]);
			int v2 = Integer.parseInt(line[1]);
			
			graph[v1].add(v2);
			graph[v2].add(v1);
		}

		for(int i=1; i<n+1; i++) {
			Collections.sort(graph[i]);
		}
		
		visited = new boolean [n+1];
		dfs(startV);
		System.out.println(resultForDfs);

		bfs(startV);
	}

	private static void dfs(int v) {
		visited[v] = true;
		resultForDfs.append(v).append(" ");
		for(int nv : graph[v]) {
			if(!visited[nv]) {
				dfs(nv);
			}
		}
	}

	private static void bfs(int startV) {
		boolean [] visited = new boolean [n+1];
		visited[startV] = true;
		Queue<Integer> q = new LinkedList<>();
		q.add(startV);
		
		StringBuilder result = new StringBuilder();
		result.append(startV).append(" ");
		
		while(!q.isEmpty()) {
			int currV = q.poll();
//			int[] tmp = new int[graph[currV].size()];
//			List<Integer> tmp = new ArrayList<>();
			for(int i=0; i<graph[currV].size(); i++) {
				int nv = graph[currV].get(i);
				if(!visited[nv]) {
					visited[nv] = true;
//					tmp[i] = nv;
//					tmp.add(nv);

					q.add(nv);
					result.append(nv).append(" ");
				}
			}
//			Arrays.sort(tmp);
			
//			Collections.sort(tmp);
//			for(int v : tmp) {
//				q.add(v);
//				result.append(v).append(" ");
//			}
		}
		
		System.out.println(result);
		
	}

}
