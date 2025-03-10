import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int cnt;
	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase<=T; testCase++) {
			N = Integer.parseInt(br.readLine());
			
			cnt = 0;
			findSum(0);
			sb.append(cnt).append("\n");
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void findSum(int sum) {

		if (sum == N) {
			cnt++;
			return;
		} else if (sum > N) {
			return;
		}
		
		for(int i=1; i<=3; i++) {
			findSum(sum+i);
		}
		
	}
}
