import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        int[][] cor = new int[n][2];
        for(int i=0; i<n; i++) {
            String[] coordinate = reader.readLine().split(" ");
            cor[i][0] = Integer.parseInt(coordinate[0]);
            cor[i][1] = Integer.parseInt(coordinate[1]);
        }
        Arrays.sort(cor, (i, j) -> {
            return (i[0] == j[0]) ? (i[1] - j[1]) : (i[0] - j[0]);
        });
        for(int i=0; i<n; i++) {
            writer.write(Integer.toString(cor[i][0]) + " " + Integer.toString(cor[i][1]) + "\n");
        }
        writer.flush();
        writer.close();
        reader.close();
    }
}
