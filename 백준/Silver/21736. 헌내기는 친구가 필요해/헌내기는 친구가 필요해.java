import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static Queue<int[]> queue = new ArrayDeque<int[]>();
	static int cnt;
	static char[][] campus;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// O는 빈 공간, X는 벽, I는 도연이, P는 사람이다. I가 한 번만 주어짐이 보장된다.
		// 도연이가 만날 수 있는 사람의 수를 출력하는 프로그램
		campus = new char[N][M];
		visited = new boolean[N][M];
		int[] xy = new int[2];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				char ch = str.charAt(j);
				campus[i][j] = ch;
				if (ch=='I') {
					xy[0] = i;
					xy[1] = j;
				}
			}
		}
		
		
		queue.add(xy);
		visited[xy[0]][xy[1]] = true;
		bfs();
		if(cnt==0) {
			System.out.println("TT");
		} else System.out.println(cnt);

	}

	private static void bfs() {

		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		while (!queue.isEmpty()) {
			int[] xy = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = xy[0] + dx[i];
				int ny = xy[1] + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && campus[nx][ny]!='X') {
					int[] arr = new int[2];
					arr[0] = nx; arr[1] = ny;
					queue.add(arr);
					visited[nx][ny] = true;
					if(campus[nx][ny]=='P') {
						cnt++;
					}
				}
			}
		}
	}

}
