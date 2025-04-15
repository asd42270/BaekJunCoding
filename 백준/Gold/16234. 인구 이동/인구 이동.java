import java.io.*;
import java.util.*;

public class Main {

	static int[][] visited;
	static int[][] land;
	static int N, L, R, cnt;
	static Map<Integer, Integer> map;
	static boolean isValid;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		land = new int[N][N];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j=0; j<N; j++) {
				land[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		map = new HashMap<Integer, Integer>();
		int day = 0;
		while(true) {
			cnt = 1;
			isValid = false;
			visited = new int[N][N];
			for(int i=0; i<N; i++) {
				for (int j = 0; j<N; j++) {
					if (visited[i][j] == 0) {
						bfs(i, j);
					}
				}
			}
			
//			for (int[] v : visited) {
//				System.out.println(Arrays.toString(v));
//			}
//			
//			System.out.println("--------------------------------");
			
			if (!isValid) break;
			
			for(int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					land[i][j] = map.get(visited[i][j]);
				}
			}
			day++;
			
		}
		
		System.out.println(day);
		
	}

	private static void bfs(int x, int y) {

		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] {x, y});
		
		visited[x][y] = cnt;
		int sum = land[x][y];
		int area = 1;
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		while(!queue.isEmpty()) {
			int[] arr = queue.poll();
			
			for (int i=0; i<4; i++) {
				int nx = arr[0] + dx[i];
				int ny = arr[1] + dy[i];
				
				if (nx>=0 && nx < N && ny >= 0 && ny < N && visited[nx][ny]==0) {
					int diff = Math.abs(land[arr[0]][arr[1]] - land[nx][ny]);
					if (diff >= L && diff <= R) {
						visited[nx][ny] = cnt;
						sum += land[nx][ny];
						queue.add(new int[] {nx, ny});
						area++;
						isValid = true;
					}
				}
			}
		}
		map.put(cnt, sum/area);
		cnt++;
	}
}
