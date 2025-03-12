import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;
	static int[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static Deque<int[]> queue = new ArrayDeque<int[]>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new int[N][M];
		int x = 0;
		int y = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 2) {
					x = i;
					y = j;
				}
				map[i][j] = num;
			}
		}

		distance(x, y);
		visited[x][y] = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i == x && j == y)
					continue;

				if (map[i][j] == 1 && visited[i][j] == 0) {
					visited[i][j] = -1;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static void distance(int x, int y) {

		int[] arr = new int[2];
		arr[0] = x;
		arr[1] = y;

		queue.add(arr);

		while (!queue.isEmpty()) {
			int[] xy = queue.poll();
			int r = xy[0];
			int c = xy[1];

			for (int i = 0; i < 4; i++) {
				int nx = r + dx[i];
				int ny = c + dy[i];

				// 0이면 아직 방문하지 않음
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != 0 && visited[nx][ny] == 0) {
					visited[nx][ny] = visited[r][c] + 1;
					int[] nxny = new int[2];
					nxny[0] = nx;
					nxny[1] = ny;
					queue.add(nxny);
				}
			}
		}

	}

}
