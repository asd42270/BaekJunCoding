import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		if (N == 0) {
			System.out.println(0);
		} else if (N<=2) {
			
			double sum = 0.0;
			
			for (int i = 0; i<N; i++) {
				sum += Integer.parseInt(br.readLine());
			}
			
			System.out.println(Math.round(sum/N));
		} else {

			int[] solved = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				solved[i] = Integer.parseInt(br.readLine());
			}

			int cut = (int) Math.round(N * 0.15);
			
			Arrays.sort(solved);;
			
			double cnt = 0.0;
			double sum = 0.0;
			for (int i = cut + 1; i <= N - cut; i++) {
				sum += solved[i];
				cnt++;
			}
			
			System.out.println(Math.round(sum / cnt));
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
}
