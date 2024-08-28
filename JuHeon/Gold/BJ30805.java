import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_30805{
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, M;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        List<Integer> a = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            a.add(Integer.parseInt(st.nextToken()));
        }

        M = Integer.parseInt(br.readLine());
        List<Integer> b = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            b.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> ans = solve(a, b);
        sb.append(ans.size()).append('\n');
        for(int i : ans){
            sb.append(i).append(' ');
        }

        System.out.println(sb);
    }

    static List<Integer> solve(List<Integer> arr1, List<Integer> arr2){
        List<Integer> result = new ArrayList<>();

        if(arr1.isEmpty() || arr2.isEmpty()){
            return result;
        }

        int max1 = Collections.max(arr1);
        int max2 = Collections.max(arr2);
        int idx1 = arr1.indexOf(max1);
        int idx2 = arr2.indexOf(max2);

        if(max1 == max2){
            result.add(max1);

            arr1.subList(0, idx1+1).clear();
            arr2.subList(0, idx2+1).clear();

            result.addAll(solve(arr1, arr2));
        } else if(max1 > max2){
            arr1.remove(idx1);
            result.addAll(solve(arr1, arr2));
        } else{
            arr2.remove(idx2);
            result.addAll(solve(arr1, arr2));
        }

        return result;
    }
}
