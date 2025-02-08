import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        String[] nums = br.readLine().split(" ");
        int[] numList = new int[n];

        for (int i=0; i<n; i++) {
            numList[i] = Integer.parseInt(nums[i]);
        }

        int current = 0;
        for (int i = 0; i<=n-3; i++) {
            for (int j=i+1; j<=n-2; j++) {
                for (int k = j+1; k<=n-1; k++) {
                    int now = numList[i] + numList[j] +  numList[k];
                    if (now <=m && current < now) {
                        current = now;
                    }
                }
            }
        }

        System.out.println(current);
    }
}
