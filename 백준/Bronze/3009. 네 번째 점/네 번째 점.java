import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arrX = new int[1001];
        int[] arrY = new int[1001];

        for(int i = 0; i<3; i++) {
            String[] xy = br.readLine().split(" ");

            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);

            arrX[x]++;
            arrY[y]++;
        }

        for(int i = 0; i<1001; i++)  {
            if (arrX[i]==1) {
                bw.write(i+" ");
                break;
            }
        }

        for(int i = 0; i<1001; i++)  {
            if (arrY[i]==1) {
                bw.write(i+" ");
                break;
            }
        }

        bw.flush();
        bw.close();
    }
}
