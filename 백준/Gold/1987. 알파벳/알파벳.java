import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static char[][] map;
	static boolean[][] visited;
	static int[] count;
	static int R, C, max;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for (int i=0; i<R; i++) {
			String str = br.readLine();
			for (int j=0; j<C; j++) {
				char ch = str.charAt(j);
				map[i][j] = ch;
			}
		}
		
		visited = new boolean[R][C];
		count = new int[91];
		
		// 이거는 dfs가 맞아요
		int[] start = new int[] {0, 0};
		dfs(start, 1);
		System.out.println(max);

	}

	private static void dfs(int[] start, int depth) {

		visited[start[0]][start[1]] = true;
		count[map[start[0]][start[1]]]++;
		
		max = Math.max(depth, max);
		
		for (int i=0; i<4; i++) {
			int nx = start[0] + dx[i];
			int ny = start[1] + dy[i];
			
			if(nx >=0 && nx < R && ny >=0 && ny < C && !visited[nx][ny] && count[map[nx][ny]] == 0) {
				dfs(new int[] {nx, ny}, depth+1);
				visited[nx][ny] = false;
				count[map[nx][ny]]--;
			}
				
		}
		
	}

}
