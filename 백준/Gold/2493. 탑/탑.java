import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		List<Integer> list = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			list.add(num);
			map.put(num, i);
		}

		List<Integer> result = new ArrayList<Integer>();

		for (int num : list) {
			while (!stack.isEmpty() && stack.peek() < num) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				result.add(0);
			} else {
				result.add(map.get(stack.peek()) + 1);
			}

			stack.push(num);
		}

		for (int num : result) {
			sb.append(num).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}
