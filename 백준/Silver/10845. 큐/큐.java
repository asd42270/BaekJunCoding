import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		LinkedList<Integer> queue = new LinkedList<Integer>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String order = st.nextToken();

			if (order.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				queue.addLast(num);

			} else if (order.equals("pop")) {
				if (!queue.isEmpty()) {
					int num = queue.pop();
					sb.append(num).append("\n");				
				}
				else {
					sb.append(-1).append("\n");
				}
			} else if (order.equals("front")) {
				if (!queue.isEmpty()) {
					int num = queue.peekFirst();
					sb.append(num).append("\n");					
				}
				else {
					sb.append(-1).append("\n");
				}
					

			} else if (order.equals("back")) {
				if (!queue.isEmpty()) {
					int num = queue.peekLast();
					sb.append(num).append("\n");					
				}
				else {
					sb.append(-1).append("\n");
				}
					

			}  else if (order.equals("size")) {
				sb.append(queue.size()).append("\n");

			} else if (order.equals("empty")) {
				if (!queue.isEmpty())
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
