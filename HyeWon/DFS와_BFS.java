import java.util.*;
public class DFS와_BFS {
    static boolean[][] map;
    static boolean[] chk;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();

        map = new boolean[n+1][n+1];
        chk = new boolean[n+1];

        for(int i=0; i<m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            map[v1][v2] =true;
            map[v2][v1] =true;
        }

        // for(int i=0; i<map.length; i++) System.out.println(Arrays.toString(map[i]));

        dfs(start);
        System.out.println();
        chk = new boolean[n+1];
        bfs(start);
    }

    static public void dfs(int start) {
        chk[start] = true;
        System.out.print(start+" ");

        // List<Integer> list = new ArrayList<>();
        for(int i=0; i<map.length; i++) {
            if (map[start][i] && start!=i && !chk[i]) dfs(i);
        }
    }
	
	public static void bfs(int start) {
		q.add(start);
		chk[start] = true;
		
		while(!q.isEmpty()) {
			
			start = q.poll();
            System.out.print(start+" ");
			
			for(int i = 1 ; i<map.length ; i++) {
				if(map[start][i] && !chk[i]) {
					q.add(i);
					chk[i] = true;
				}
			}
		}
		
		
	}
}
