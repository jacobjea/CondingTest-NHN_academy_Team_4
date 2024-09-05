import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.util.LinkedList;

public class DFS_and_BFS {
    public static boolean node[][];
    public static boolean check[];
    public static int N, M, V;
    public static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        V = Integer.parseInt(temp[2]);

        node = new boolean[N][N];
        check = new boolean[N];

        for(int i=0; i<M; i++) {
            String[] tp = br.readLine().split(" ");
            int a = Integer.parseInt(tp[0]);
            int b = Integer.parseInt(tp[1]);
            node[a-1][b-1] = node[b-1][a-1] = true;
        }
        dfs(V-1, bw);
        bw.write("\n");
        check = new boolean[N];
        bfs(V-1, bw);
        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }


    public static void dfs(int v, BufferedWriter bw) throws IOException {
        check[v] = true;
        bw.write(Integer.toString(v+1) + " ");
        for(int i=0; i<N; i++) {
            if(node[v][i] && !check[i]) {
                dfs(i, bw);
            }
        }
    }

    public static void bfs(int v, BufferedWriter bw) throws IOException {
        queue.add(v);
        check[v] = true;
        while(!queue.isEmpty()) {
            v = queue.poll();
            bw.write(Integer.toString(v+1) + " ");
            for(int i=0; i<N; i++) {
                if(node[v][i] && !check[i]) {
                    queue.add(i);
                    check[i] = true;
                }
            }
        }
    }
}