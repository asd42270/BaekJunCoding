import java.io.*;
import java.util.*;

public class Main {

	static char[][] map;
	static int N, M, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		for (int i=0; i<N; i++) {
			String str = br.readLine();
			for (int j=0; j<M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		//최단거리라고 하지만 가장 먼 거리
		cnt = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j <M; j++) {
				if (map[i][j] == 'W') continue;
				bfs(i, j);
			}
		}
		
		System.out.println(cnt);

	}

	private static void bfs(int x, int y) {
		
		Queue<int[]> queue = new ArrayDeque<int[]>();
		boolean[][] visited = new boolean[N][M];
		queue.add(new int[] {x, y});
		visited[x][y] = true;
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		int num = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for (int k = 0; k < size; k++) {
				int[] arr = queue.poll();
				
				for (int i=0; i<4; i++) {
					int nx = arr[0] + dx[i];
					int ny = arr[1] + dy[i];
					
					if (nx >= 0 && nx < N && ny >=0 && ny < M 
							&& !visited[nx][ny] && map[nx][ny]=='L') {
						queue.offer(new int[] {nx, ny});
						visited[nx][ny] = true;
					}
				}
			}
			num++;
		}
		
		cnt = Math.max(cnt, num-1);
		
		
	}
}
