import java.util.*;
import java.io.*;

public class Main {

	static int[] count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// 삽입 삭제

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			int k = Integer.parseInt(br.readLine());

			TreeSet<Integer> set = new TreeSet<Integer>();
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				char ch = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());

				if (ch == 'I') {

					set.add(num);

					if (map.containsKey(num)) {
						int value = map.get(num) + 1;
						map.put(num, value);
					} else
						map.put(num, 1);

				} else {
					if (set.isEmpty())
						continue;

					if (num == -1) {
						int number = set.first();
						int value = map.get(number) - 1;
						map.put(number, value);
						
						if (map.get(number) == 0) {
							set.pollFirst();
						}
					} else {
						int number = set.last();
						int value = map.get(number) - 1;
						map.put(number, value);
						
						if (map.get(number) == 0) {
							set.pollLast();
						}
					}
				}
			}

			if (set.isEmpty())
				sb.append("EMPTY").append("\n");
			else{
				sb.append(set.last()).append(" ").append(set.first()).append("\n");
			}

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
