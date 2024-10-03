package search.bfsDfs;
/*
1 29
-9

1. 아이디어 dfs
관계도 

dfs(int curr, int target, int degree):

 */
import java.util.*;

public class 촌수계산 {
    static List<Integer>[] relations;
    static boolean[] isVisited;
    static boolean isFinded;
     static int result=-1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        relations = new List[n+1];

        for(int i=0; i<=n; i++) {
            relations[i] = new LinkedList<>();
        }

        int m = sc.nextInt();
        while(m-- > 0) {
            int parent = sc.nextInt();
            int child = sc.nextInt();
            // System.out.println(parent + ", " + child);

            relations[parent].add(child);
            relations[child].add(parent);
        }
        // System.out.println("check");
        
        isVisited = new boolean[n+1];

//        int result = dfs(x, y, 0);
//        if (result==0) System.out.println(-1);
//        else System.out.println(result);

        dfs(x, y, 1);
        System.out.println(result);
        
    }  
    
    public static void dfs(int x, int target, int degree) {
        // if (x==target) return degree;
        // degree++;
        for(int next : relations[x]){
            if(isVisited[next]) continue;
            
            if (next==target) {
                // isFinded = true;
            	result = degree;
                return;
//                return degree;
            }
            isVisited[next] = true;
//            System.out.printf("dfs(%d, %d, %d)\n", next, target, degree+1);
            dfs(next, target, degree+1);
//            System.out.println("dfs 반환 = "+degree);
            // if(isFinded) break;
//            if(degree!=0) break;
//            degree--;
        }
        // if(isFinded) return degree;
        // else return -1;
//        System.out.println("return +"+degree);
//        return degree;
    }
}
