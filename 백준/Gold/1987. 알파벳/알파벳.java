import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static char[][] map;
	static boolean[] count;
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
		
		count = new boolean[26];
		
		// 이거는 dfs가 맞아요
		dfs(0, 0, 1);
		System.out.println(max);

	}

	private static void dfs(int x, int y, int depth) {

		count[map[x][y]- 65] = true;
		
		max = Math.max(depth, max);
		
		for (int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >=0 && nx < R && ny >=0 && ny < C && !count[map[nx][ny] - 65]) {
				dfs(nx, ny, depth+1);
				count[map[nx][ny] - 65] = false;
			}
		}
		
	}

}
