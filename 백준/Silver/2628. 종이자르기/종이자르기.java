
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

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		int N = Integer.parseInt(br.readLine());

		int[] row = new int[N + 2];
		int[] col = new int[N + 2];
		row[0] = 0;
		col[0] = 0;
		row[1] = y;
		col[1] = x;

		int rIdx = 2;
		int cIdx = 2;
		for (int i = 0; i < N; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
			int isCol = Integer.parseInt(st1.nextToken());
			int num = Integer.parseInt(st1.nextToken());

			if (isCol == 0) {
				row[rIdx] = num;
				rIdx++;
			} else {
				col[cIdx] = num;
				cIdx++;
			}

		}

		Arrays.sort(row);
		Arrays.sort(col);

		int wMax = Integer.MIN_VALUE;
		int hMax = Integer.MIN_VALUE;
		for (int i = 1; i < N + 2; i++) {
			wMax = Math.max(wMax, (row[i] - row[i - 1]));
			hMax = Math.max(hMax, (col[i] - col[i - 1]));
		}

		System.out.println(wMax * hMax);

	}
}
