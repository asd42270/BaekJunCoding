import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] square = new int[100][100];
        int count = 0;

        for(int i = 0; i<4; i++) {
            String[] xyxy = br.readLine().split(" ");
            int x1 = Integer.parseInt(xyxy[0]);
            int y1 = Integer.parseInt(xyxy[1]);
            int x2 = Integer.parseInt(xyxy[2]);
            int y2 = Integer.parseInt(xyxy[3]);

            for(int j = x1; j<x2; j++) {
                for (int k = y1; k<y2; k++) {
                    if(square[j][k]==0) {
                        square[j][k]++;
                        count++;
                    }
                }
            }
        }

        System.out.println(count);

    }
}
