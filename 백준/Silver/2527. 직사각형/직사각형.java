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
		// 왼쪽 아래(x, y) 오른쪽 위 (p,q) 가로 (p-x) 세로 (q-y)
		// 한 줄에 8개 줄 4개, 4개는 첫 번째 직사각형, 나머지 4개는 두 번째

		for (int i = 1; i <= 4; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// 첫 번째
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());

			// 두 번째
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());

			// 두 번째 사각형이 첫 번째 사각형에 ~~ 하면
			// 점인 경우
			if ((x2 == p1 && q2 == y1) || (x2 == p1 && y2 == q1) || (p2 == x1 && y2 == q1) || (p2 == x1 && q2 == y1)) {
				bw.append("c").append("\n");
				// 선분인 경우
			} else if (p2 < x1 || x2 > p1 || y2 > q1 || q2 < y1){
				bw.append("d").append("\n");
			} else if (x2==p1 || p2==x1 || q2==y1|| y2==q1) {
				bw.append("b").append("\n");

			}  else {
				bw.append("a").append("\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
