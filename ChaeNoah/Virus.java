import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;



public class Virus {
    static boolean[][] graph;
    static boolean[] visit;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        graph = new boolean[n][n];
        visit = new boolean[n];

        for(int i=0; i<c; i++) {
            String[] computer = br.readLine().split(" ");
            int a = Integer.parseInt(computer[0]) - 1;
            int b = Integer.parseInt(computer[1]) - 1;

            graph[a][b] = graph[b][a] = true;
        }
        int count = dfs(0);
        bw.write(Integer.toString(count) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    public static int dfs(int n) {
        visit[n] = true;
        for(int i=0; i<visit.length; i++) {
            if(!visit[i] && graph[n][i]) {
                count++;
                dfs(i);
            }
        }
        return count;
    }
}
