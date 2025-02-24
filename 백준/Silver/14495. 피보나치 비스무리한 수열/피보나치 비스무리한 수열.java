
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int len;
	static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		if (N <= 3) {
			sb.append(1);
		} else {

			long[] dp = new long[N + 1];
			dp[0] = 0;
			dp[1] = 1;
			dp[2] = 1;
			dp[3] = 1;

			for (int i = 4; i < N + 1; i++) {
				dp[i] = dp[i - 1] + dp[i - 3];
			}

			sb.append(dp[N]);
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
