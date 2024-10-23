package SeungWook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.lang.StringBuilder;
public class 요세푸스_문제_0 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i<=n; i++){
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder();

        sb.append("<");
        while (!queue.isEmpty()) {
            for(int i =0; i<m-1; i++){
                queue.add(queue.poll());
            }

            sb.append(queue.poll());
            if (!queue.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append(">");
        System.out.println(sb.toString());
    }
}
