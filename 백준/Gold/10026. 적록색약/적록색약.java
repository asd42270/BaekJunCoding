import java.util.*;
import java.io.*;

public class Main {

	static int acnt, bcnt, N;
	static char[][] paint;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		paint = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				paint[i][j] = str.charAt(j);
			}
		}

		// 각 구역을 찾아야 함
		// 상하좌우로 돌면서 구역을 찾는다.(4방탐색)
		// 0,0부터 시작해서 탐색 방문여부 체크 ->
		// 적록색약은 빨간색과 초록색의 차이를 거의 느끼지 못한다.-> 파랑만
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j]) continue;
				findArea(i, j); // 
				acnt++;
				
			}
		}
		
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j]) continue;
				findAreaB(i, j); // 
				bcnt++;
				
			}
		}

		System.out.println(acnt + " " + bcnt);

	}

	private static void findAreaB(int x, int y) {
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };

		visited[x][y] = true;
		for (int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx>=0 && nx<N && ny >= 0 && ny <N && !visited[nx][ny]) {
				if ((paint[x][y] == 'R' || paint[x][y] == 'G') && (paint[nx][ny]=='R' || paint[nx][ny]=='G')
						|| (paint[x][y] == 'B' && paint[nx][ny] == 'B')) {
					visited[nx][ny] = true;
					findAreaB(nx, ny);	
				}
				
			}
		}
		
	}

	private static void findArea(int x, int y) {

		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };

		visited[x][y] = true;
		for (int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx>=0 && nx<N && ny >= 0 && ny <N && !visited[nx][ny]
					&& paint[nx][ny] == paint[x][y]) {
				visited[nx][ny] = true;
				findArea(nx, ny);
			}
		}

	}

}
