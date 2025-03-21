import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N]; // i번째까지 왔을 떄 가장 긴 증가하는 부분 수열의 수
		
		Arrays.fill(dp, 1);
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<i; j++) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		

		int max =Integer.MIN_VALUE;
		for (int i=0; i<N; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}
}
