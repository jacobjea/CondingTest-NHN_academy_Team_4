import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 소가_길을_건너간_이유 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt( br.readLine());

        CowInfo[] cowInfos = new CowInfo[n];
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            cowInfos[i] = new CowInfo(a, t);
        }
        
        Arrays.sort(cowInfos,(x,y)->{return Integer.compare(x.arriveTime, y.arriveTime);});

        int currentTime = 0;
        for(CowInfo cowInfo : cowInfos){
            if(currentTime < cowInfo.arriveTime){
                currentTime = cowInfo.arriveTime;
            }
            currentTime += cowInfo.duringTime;
        }
        System.out.println(currentTime);
    }
    public static class CowInfo{
        public int arriveTime;
        public int duringTime;
        public CowInfo(int arriveTime, int duringTime){
            this.arriveTime = arriveTime;
            this.duringTime = duringTime;
        }
        @Override
        public String toString(){
            return "a:" + arriveTime + "/" + "d:" + duringTime;
        }
    }
}
