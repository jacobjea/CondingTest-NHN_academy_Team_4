import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배고픈_아리의_샌드위치_구매하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int price = Integer.parseInt(st.nextToken());
        int ariMoney = Integer.parseInt(st.nextToken());

        int myMoney = 1023;

        System.out.println(Integer.toBinaryString(myMoney));
        System.out.println(Integer.toBinaryString(2));
        System.out.println(Integer.toBinaryString(1024));
        System.out.println("-----------------------------");

        System.out.println(Integer.toBinaryString(myMoney));
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(1024));
        System.out.println("-----------------------------");
        System.out.println("0"+Integer.toBinaryString(1023));
        System.out.println(Integer.toBinaryString(1027));
        System.out.println("0000000" + Integer.toBinaryString(12));
    }
}
