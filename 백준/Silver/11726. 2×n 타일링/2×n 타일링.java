import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		if (N >= 3) {

			int[] dp = new int[N + 1];
			dp[1] = 1;
			dp[2] = 2;

			// dp[i] = dp[i-1]
			// dp[2] = 2
			// dp[3] = dp[2]*2 - 1 = 3
			// dp[4] = dp[3]*2 - 1 = 5
			// dp[5] = dp[4]*2 - 3 = 7
			int num = 1;
			for (int i = 3; i <= N; i++) {
				dp[i] = (dp[i - 1] + dp[i - 2])%10007;
			}

			System.out.println(dp[N]);

		} else {
			System.out.println(N);
		}
	}

}
