package SeungWook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

public class 덩치 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Info[] infos = new Info[n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            infos[i] = new Info(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < infos.length; i++) {
            int rank = 1;
            for (int j = 0; j < infos.length; j++) {
                int comparation = infos[i].compareTo(infos[j]);
                if (comparation < 0) {
                    rank++;
                }
            }
            infos[i].rank = rank;
            sb.append(infos[i].rank).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}

class Info implements Comparable<Info> {
    int weight;
    int high;
    int rank = 0;

    public Info(int weight, int high) {
        this.weight = weight;
        this.high = high;
    }

    @Override
    public String toString() {
        return weight + ", " + high + ":" + rank;
    }

    @Override
    public int compareTo(Info i) {
        int weightComparation = Integer.compare(this.weight, i.weight);
        int highComparation = Integer.compare(this.high, i.high);
        if (weightComparation > 0 && highComparation > 0) {
            return 1;
        } else if (weightComparation < 0 && highComparation < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
