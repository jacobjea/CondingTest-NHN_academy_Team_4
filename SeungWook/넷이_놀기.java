import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;
import java.io.IOException;

public class 넷이_놀기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int witdh = Integer.parseInt(s[0]);
        int high = Integer.parseInt(s[1]);
        Set<Pos> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            // String[] line = br.readLine().split(" ");
            set.add(new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int count= 0;
        for(Pos pos : set){
            if (set.contains(new Pos(pos.x + witdh, pos.y)) && set.contains(new Pos(pos.x, pos.y + high)) && set.contains(new Pos(pos.x + witdh, pos.y + high))){
                count++;
            }
        }
        System.out.println(count);
    }

    public static class Pos{
        int x, y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj){
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pos pos = (Pos) obj;
            return x == pos.x && y == pos.y;
        }

        @Override
        public int hashCode(){
            return Objects.hash(x,y);
        }
    }
}
