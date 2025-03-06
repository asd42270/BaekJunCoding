
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

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			// 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해서 출력한다.
			int[] zero = new int [41]; // i 번쨰 피보를 했을 때의 0
			int[] one = new int [41]; // i 번쨰 피보를 했을 때의 1의 개수
			
			zero[0] = 1; zero[1] = 0; zero[2] = 1;
			one[0] = 0; one[1] = 1;  one[2] = 1;
			
			for (int i=3; i<41; i++) {
				zero[i] = zero[i-1] + zero[i-2];
				one[i] = one[i-1] + one[i-2];
			}
			
			sb.append(zero[N]).append(" ").append(one[N]).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
}
