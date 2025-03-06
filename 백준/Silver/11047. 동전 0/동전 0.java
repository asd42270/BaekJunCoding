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
		
		st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[N];
		int maxIdx = 0;
		for (int i=0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			coin[i] = num;
			if (num <= K) {
				maxIdx = i;
			}
		}
		
		// K보다 큰 거면 안 해도 됨. 뒤에서부터 탐색해서
		int cnt = 0;
		for (int i= maxIdx; i>=0; i--) {
			int number = K / coin[i];
			
			if (number!=0) {
				int rest = K % coin[i];
				cnt+=number;
				K = rest;
			}				
		}
		
		System.out.println(cnt);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
		
	}
}
