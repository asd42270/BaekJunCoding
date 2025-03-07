import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		if (N >= 4) {
			int[] dp = new int[N + 1];

			dp[2] = 1;
			dp[3] = 1;

			for (int i = 4; i <= N; i++) {
				if (i % 3 == 0 && i % 2 == 0) {
					dp[i] = Math.min(dp[i / 3] + 1, Math.min(dp[i / 2] + 1, dp[i - 1] + 1));
				} else if (i % 3 == 0) {
					dp[i] = Math.min(dp[i / 3] + 1, dp[i - 1] + 1);
				} else if (i % 2 == 0) {
					dp[i] = Math.min(dp[i / 2] + 1, dp[i - 1] + 1);
				} else {
					dp[i] = dp[i - 1] + 1;
				}
			}
			System.out.println(dp[N]);
		} else if (N <= 1) {
			System.out.println(0);
		} else {
			System.out.println(1);
		}

	}
}
