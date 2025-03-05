import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String order = st.nextToken();

			if (order.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				stack.add(num);

			} else if (order.equals("pop")) {
				if (!stack.isEmpty()) {
					int num = stack.pop();
					sb.append(num).append("\n");				
				}
				else {
					sb.append(-1).append("\n");
				}
			} else if (order.equals("top")) {
				if (!stack.isEmpty()) {
					int num = stack.peek();
					sb.append(num).append("\n");					
				}
				else {
					sb.append(-1).append("\n");
				}
					

			} else if (order.equals("size")) {
				sb.append(stack.size()).append("\n");

			} else if (order.equals("empty")) {
				if (!stack.isEmpty())
					sb.append(0).append("\n");
				else
					sb.append(1).append("\n");

			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
}
