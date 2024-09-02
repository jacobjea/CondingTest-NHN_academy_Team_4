import java.util.*;
public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new LinkedList<>();
        for(int i=0; i<n; i++) {
            list.add(sc.nextInt());
        }
        Collections.sort(list);
        // System.out.println(list);
        int result = 0;
        for(int i=0; i<n; i++) {
            int sum = 0;
            for(int j=0; j<=i; j++) {
                // System.out.print(list.get(j)+" ");
                sum+=list.get(j);
            }

            result += sum;
        }
            
        System.out.println(result);
    }
}
