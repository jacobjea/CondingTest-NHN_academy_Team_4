import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;


public class 물건_팔기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] requiredCost = new int[n];
        int[] delivery = new int[n];

        List<Info> infos = new ArrayList<>();
        // 최대 이익 -> (상품 가격 - 배송비) * 구매자 수
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            requiredCost[i] = Integer.parseInt(s[0]);
            delivery[i] = Integer.parseInt(s[1]);
        }

        int income = 0;
        for (int i = 0; i < n; i++) {
            income = 0;
            for (int j = 0; j < n; j++) {
                if (requiredCost[i] <= requiredCost[j] && requiredCost[i] > delivery[j]) {
                    income += requiredCost[i] - delivery[j];
                }
            }
            if(income > 0){
                infos.add(new Info(income, requiredCost[i]));
            }
        }

        if (infos.size() == 0) {
            System.out.println("0");
            return;
        }

        Collections.sort(infos, new Comparator<Info>() {
            @Override
            public int compare(Info i1, Info i2){
                int comparation = i2.income - i1.income;
                if (comparation != 0) {
                    return comparation;
                }
                else{
                    return i1.requiredCost - i2.requiredCost;
                }
            }
        });

        System.out.println(infos.get(0).requiredCost);
    }

    static class Info{
        int income = 0;
        int requiredCost;
        public Info(int income, int requiredCost){
            this.income = income;
            this.requiredCost = requiredCost;
        }
    }
}
