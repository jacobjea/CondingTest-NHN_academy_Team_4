import java.util.*;

public class 듣보잡 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < N + M; i++) {
            String name = sc.nextLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 2) {
                count += 1;
                list.add(entry.getKey());
            }
        }

        Collections.sort(list);
        System.out.println(count);
        for (String s: list) {
            System.out.println(s);
        }
    }
}
