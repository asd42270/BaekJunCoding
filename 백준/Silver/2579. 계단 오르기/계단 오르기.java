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

		if (N == 0) {
			System.out.println(0);
		} else {

			int[] stair = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				stair[i] = Integer.parseInt(br.readLine());
			}

			int[] dp = new int[N + 1];
			dp[1] = stair[1];
			
			if (N>=2) {
				dp[2] = stair[1] + stair[2];
			}

			if (N >= 3) {
				for (int i = 3; i <= N; i++) {
					dp[i] = Math.max(stair[i] + stair[i - 1] + dp[i - 3], stair[i] + dp[i - 2]);
				}

				System.out.println(dp[N]);

			} else {
				System.out.println(dp[N]);
			}
		}
	}
}
