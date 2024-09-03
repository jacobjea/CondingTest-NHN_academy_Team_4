import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Stack_2 {
    public static void main(String[] args) throws IOException {
        LinkedList<Integer> list = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            String[] temp = br.readLine().split(" ");
            switch(Integer.parseInt(temp[0])) {
            case(1):
                list.add(Integer.parseInt(temp[1]));
                break;
            case(2):
                if(list.isEmpty()) {
                    bw.write("-1");
                }
                else {
                    bw.write(Integer.toString(list.pollLast()));
                }
                bw.write("\n");
                break;
            case(3):
                bw.write(Integer.toString(list.size()));
                bw.write("\n");
                break;
            case(4):
                if(list.isEmpty()) {
                    bw.write("1");
                }
                else {
                    bw.write("0");
                }
                bw.write("\n");
                break;
            case(5):
                if(!list.isEmpty()) {
                    bw.write(Integer.toString(list.peekLast()));
                }
                else {
                    bw.write("-1");
                }
                bw.write("\n");
                break;
            }
            bw.flush();            
        }
    }
}
