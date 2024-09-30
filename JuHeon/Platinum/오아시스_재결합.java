import java.io.*;
import java.util.*;

public class 오아시스_재결합{
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, M, K;
    
    static Node[] arr;
    static Stack<Node> stack = new Stack<>();

    static class Node implements Comparable<Node>{
        int height;
        int count;

        Node(int height, int count){
            this.height = height;
            this.count = count;
        }

        @Override
        public int compareTo(Node o){
            return this.height - o.height;
        }
    }
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = new Node[N];
        for(int i = 0; i < N; i++){
            Node node = new Node(Integer.parseInt(br.readLine()), 1);

            arr[i] = node;
        }

        long count = 0;
        for(int i = 0; i < N; i++){
            while(!stack.isEmpty() && stack.peek().compareTo(arr[i]) <= 0){
                Node tmp = stack.pop();
                count += tmp.count;

                if(tmp.height == arr[i].height){
                    arr[i].count += tmp.count;
                }
            }

            if(!stack.isEmpty()){
                count++;
            }

            stack.push(arr[i]);
        }

        System.out.println(count);
    }
}
