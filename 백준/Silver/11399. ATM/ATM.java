
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
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		// 둘째 줄에는 각 사람이 돈을 인출하는데 걸리는 시간 Pi가 주어진다.
		int[] time = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i=0; i<N; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		
		// i번 사람이 돈을 인출하는데 걸리는 시간은 Pi분이다.
		// 사람들이 줄을 서는 순서에 따라서, 돈을 인출하는데 필요한 시간의 합이 달라지게 된다.
		// 시간의 합이 최소가 되도록 줄을 세워보자
		// 빨리하는 사람이 먼저 돈을 인출해야 덜 기다려
		Arrays.sort(time);
		
		int sum = time[0];
		for (int i=1; i<N; i++) {
			time[i] += time[i-1];
			sum+=time[i];
		}
		
		sb.append(sum);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
}
