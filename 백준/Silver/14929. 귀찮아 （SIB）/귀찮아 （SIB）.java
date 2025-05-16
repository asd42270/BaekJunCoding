import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine(), " ");
		long[] arr = new long[N];
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		long[] dp = new long[N];
		
		for (int i=1; i<N; i++) {
			dp[i] = dp[i-1] + arr[i-1];
		}
		
		long sum = 0;
		for (int i=1; i<N; i++) {
			sum+=(dp[i]*arr[i]);
		}
		
		System.out.println(sum);
	}

}
