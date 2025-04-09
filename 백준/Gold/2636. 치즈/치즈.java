import java.io.*;
import java.util.*;

public class Main {

	static int[][] map;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		int cheese = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int v = Integer.parseInt(st.nextToken());
				map[i][j] = v;
				if (v == 1) {
					cheese++;
				}
			}
		}

		List<int[]> list = new ArrayList<int[]>();
		List<Integer> cheeseByTime = new ArrayList<Integer>();
		cheeseByTime.add(cheese);
		int time = 0;
		int temp = 0;
		while (cheese > 0) {
			temp = cheese;
			bfs(list);

			cheeseByTime.add(cheese);

			for (int[] arr : list) {
				map[arr[0]][arr[1]] = 0;
				cheese--;
			}

			time++;
			list.clear();
		}

		System.out.println(time);
		System.out.println(temp);

	}

	private static void bfs(List<int[]> list) {

		Queue<int[]> queue = new ArrayDeque<int[]>();
		boolean[][] visited = new boolean[N][M];
		queue.add(new int[] { 0, 0 });

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			int[] arr = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = arr[0] + dx[i];
				int ny = arr[1] + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
					if (map[nx][ny] == 0) {
						queue.offer(new int[] { nx, ny });
					} else {
						list.add(new int[] { nx, ny });
					}

					visited[nx][ny] = true;

				}
			}
		}
	}
}
