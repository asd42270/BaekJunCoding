import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i<=n; i++) {
            String num = String.valueOf(i);
            int sum = i;
            for(int j=0; j<num.length(); j++) {
                sum+=(Integer.parseInt(String.valueOf(num.charAt(j))));
            }

            if(sum == n) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);

    }
}