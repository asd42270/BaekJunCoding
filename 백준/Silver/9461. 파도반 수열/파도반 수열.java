import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		long[] dp = new long[101];
		dp[1] = 1; dp[2] = 1; dp[3] = 1;
		dp[4] = 2; dp[5] = 2;
		
		for(int i=6; i<101; i++) {
			dp[i] = dp[i-1] + dp[i-5];
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int i=0; i<T; i++) {
			sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}