import java.util.*;
import java.io.*;

public class Main {

	static String[] cmds;
	static Queue<Integer> queue;
	static boolean[] ch;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		// 삽입 삭제가 빈번하다 -> LinkedList
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine(), " ");
			String a = st.nextToken();
			String b = st.nextToken();

			queue = new ArrayDeque<Integer>();
			ch = new boolean[10000];
			cmds = new String[10000];
			Arrays.fill(cmds, "");
			bfs(a, b);
		}
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void bfs(String a, String b) {
		
		queue.add(Integer.parseInt(a));

		int idx = Integer.parseInt(a);
		ch[idx] = true;
		cmds[idx] = "";
		int bNum = Integer.parseInt(b);

		while (!queue.isEmpty()) {
			int n = queue.poll();

			// D 실행
			int d = 0;
			if (n * 2 >= 10000)
				d = (n * 2) % 10000;
			else
				d = n * 2;

			if (d == bNum) {
				sb.append(cmds[n]).append("D").append("\n");
				return;
			}

			if (!ch[d]) {
				ch[d] = true;
				cmds[d] = cmds[n] + "D";
				queue.add(d);
			}

			// S 실행
			int s;
			if (n == 0) {
			    s = 9999;
			} else {
			    s = n - 1;
			}
			
			if (s == bNum) {
				sb.append(cmds[n]).append("S").append("\n");
				return;
			}
			if (!ch[s]) {
				ch[s] = true;
				cmds[s] = cmds[n] + "S";
				queue.add(s);
			}

			// L 실행
			int lNum = (n%1000)*10 + (n/1000);
			
			if (lNum == bNum) {
				sb.append(cmds[n]).append("L").append("\n");
				return;
			}

			if (!ch[lNum]) {
				ch[lNum] = true;
				cmds[lNum] = cmds[n] + "L";
				queue.add(lNum);
			}

			// R 실행
			int rNum = (n%10)*1000 + (n/10);
			if (rNum == bNum) {
				sb.append(cmds[n]).append("R").append("\n");
				return;
			}

			if (!ch[rNum]) {
				ch[rNum] = true;
				cmds[rNum] = cmds[n] + "R";
				queue.add(rNum);
			}
		}

	}
}
