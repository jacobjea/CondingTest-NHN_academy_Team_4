import java.io.*;

/**
 * Hello world!
 *
 */
public class Body 
{
    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        People[] people = new People[n];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            people[i] = new People(a, b);
        }

        for (int i = 0; i < n; i++) {
            for(int j=0; j<n; j++) {
                if(i == j) {
                    continue;
                }
                if(people[i].getX() < people[j].getX() && people[i].getY() < people[j].getY()) {
                    people[i].levelUp();
                }
            }
        }

        for(People p : people) {
            bw.write(p.getLevel() + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

class People {
    private int x, y, level;
    public People(int x, int y) {
        this.x = x;
        this.y = y;
        this.level = 1;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void levelUp() {
        this.level++;
    }

    public int getLevel() {
        return this.level;
    }
}
