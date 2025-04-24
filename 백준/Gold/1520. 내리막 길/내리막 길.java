import java.io.*;
import java.util.*;

public class Main {

	static int[][] map, memo;
	static int[] count;
	static int M, N , cnt;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static Queue<int[]> queue;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		memo = new int[M][N];
		map = new int[M][N];
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				memo[i][j] = -1; // i, j에서 목적지까지 가는 경로의 수
			}
		}

		visited = new boolean[M][N];
		System.out.println(dfs(0, 0));
		
//		for (int[] arr : memo) {
//			System.out.println(Arrays.toString(arr));
//		}
		

			
	}

	
	private static int dfs(int x, int y) {

		if (x==M-1 && y == N-1) {
			return 1;
		}
		
		if (memo[x][y] != -1) return memo[x][y];
		
		memo[x][y] = 0;
		
		for (int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && nx < M && ny>=0 && ny < N && map[nx][ny] < map[x][y]) {
				memo[x][y] += dfs(nx, ny);
			}
		}
		
		return memo[x][y];
		
	}

}
