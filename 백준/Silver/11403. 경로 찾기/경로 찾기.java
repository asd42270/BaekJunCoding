
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static Map<Integer, List<Integer>> graph;
	static int[][] map;
	static boolean[] visited;
	static boolean isValid;
	static int cnt, init;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		graph = new HashMap<Integer, List<Integer>>();

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			graph.put(i, new ArrayList<Integer>());
		}

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int value = Integer.parseInt(st.nextToken());
				if (value == 1) {
					graph.get(i).add(j);
				}
				map[i][j] = value;
			}
		}

		int[][] answer = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				isValid = false;
				visited = new boolean[N];
				init = i;
				dfs(i, j);

				if (isValid)
					answer[i][j] = 1;
			}
		}

		for (int[] arr : answer) {
			for (int num : arr) {
				System.out.print(num + " ");
			}
			System.out.println();
		}

	}

	private static void dfs(int start, int end) {
		visited[start] = true;

		if (graph.get(start).isEmpty()) {
			return;
		} else { // 하나라도 있다면 탐색이 가능함.

			for (int num : graph.get(start)) {
				if (visited[num]) {
					if (num == end && init == end) {
						isValid = true;
						return;
					} else {
						continue; // 방문한 곳을 재방문 다시 돌아서 올 수도 있어서
					}
				}

				if (num == end) {
					isValid = true;
					return;
				}

				dfs(num, end);
			}
		}
	}
}
