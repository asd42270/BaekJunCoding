import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<=n; i++) {
			 int value = Integer.parseInt(st.nextToken());
			arr[i] = value;
		}
		
		dp[1] = arr[1];
		for(int i=1; i<=k; i++) {
			dp[i] = dp[i-1] + arr[i];
		}
		
		for (int i=k+1; i<=n; i++) {
			dp[i] = dp[i-1] + arr[i] - arr[i-k];
		}
		
		int max = Integer.MIN_VALUE;
		for (int i=k; i<=n; i++) {
			if (dp[i] > max) {
				max = dp[i];
			}
		}
		
		sb.append(max);
		
		 
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}