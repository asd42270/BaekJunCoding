
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		int[][] time = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int startTime = Integer.parseInt(st.nextToken());
			int endTime = Integer.parseInt(st.nextToken());

			time[i][0] = startTime;
			time[i][1] = endTime;
		}

		// 가장 빨리 끝나는 회의부터 배정해야 함.
		Arrays.sort(time, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				int num = Integer.compare(o1[1], o2[1]);
				
				if(num == 0) {
					return Integer.compare(o1[0], o2[0]);
				}
				
				return num;
			}
		});

		int cnt = 1;
		int end = time[0][1];
		int idx = 1;
		while (idx < N) {

			if (end <= time[idx][0]) {
				end = time[idx][1];
				cnt++;
			}

			idx++;
		}

		System.out.println(cnt);

	}
}
