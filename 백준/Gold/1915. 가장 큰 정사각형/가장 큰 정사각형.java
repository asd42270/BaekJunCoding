import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, M, max, cnt;
	static int[][] map;
	static int[][] visited;
	static int[] dx = { 0, 1, 1 };
	static int[] dy = { 1, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				String num = Character.toString(str.charAt(j));
				map[i][j] = Integer.parseInt(num);
			}
		}

		max = Integer.MIN_VALUE;
		visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					continue;

				if (i-1 >= 0 && j-1 >= 0) {
					visited[i][j] = Math.min(visited[i-1][j-1], Math.min(visited[i-1][j], visited[i][j-1])) + 1;
				} else {
					visited[i][j] = 1;
				}
				max = Math.max(visited[i][j], max);
			}
		}

		System.out.println(max*max);

	}

}
