import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			String command = br.readLine();
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();

			String[] strArr = str.replace("[", "").replace("]", "").split(",");
			Deque<Integer> list = new ArrayDeque<Integer>();
			if (N > 0) {
				for (int i = 0; i < strArr.length; i++) {
					list.add(Integer.parseInt(strArr[i]));
				}
			}

			// R(뒤집기)과 D(버리기)가 있다.
			// 함수 R은 배열에 있는 수의 순서를 뒤집는 함수이고, D는 첫 번째 수를 버리는 함수이다.
			// 배열이 비어있는데 D를 사용한 경우에는 에러가 발생한다.
			boolean isError = false;
			boolean reversed = false;
			for (int i = 0; i < command.length(); i++) {
				if (command.charAt(i) == 'R') {
					if (!reversed)
						reversed = true;
					else
						reversed = false;
				} else {
					if (list.size() > 0) {
						if (reversed) {
							list.pollLast();
						} else
							list.pollFirst();
					} else {
						sb.append("error").append("\n");
						isError = true;
						break;
					}
				}
			}

			if (!isError) {
				StringBuilder sb1 = new StringBuilder();

				if (list.isEmpty()) {
					sb.append("[]").append("\n");
				} else {

					sb.append("[");
					if (reversed) {

						while (list.size() > 1) {
							sb.append(list.pollLast()).append(",");
						}

						sb.append(list.poll()).append("]");

					} else {
						while (list.size() > 1) {
							sb.append(list.poll()).append(",");
						}

						sb.append(list.poll()).append("]");

					}

					sb.append(sb1.toString()).append("\n");
				}
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
