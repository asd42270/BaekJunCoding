import java.util.*;
import java.io.*;

public class Main {

	static int N, M, cnt;
	static Map<Integer, Integer> map;
	static Queue<Integer> queue;
	static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new HashMap<Integer, Integer>();
		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			map.put(u, v);
		}

		queue = new ArrayDeque<Integer>();
		visited = new int[101];
		bfs(1);

//		System.out.println(Arrays.toString(visited));
		System.out.println(visited[100]);

	}

	private static void bfs(int x) {

		queue.add(x); // 시작점

		while (!queue.isEmpty()) {
			int cur = queue.poll();
//			System.out.println(cur + " " + visited[cur]);
			for (int i = 1; i <= 6; i++) {
				int num = cur + i;

				
				int next = map.getOrDefault(num, num);
				if(visited[next] != 0) continue;
				
				visited[next] = visited[cur] + 1;
				
				if (next >= 100) return;
				
				queue.add(next);
			}
		}

	}
}
