import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int R, C, N, idx;
	static int[][] cave;
	static int[][] visited;
	static List<int[]> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		cave = new int[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				if (str.charAt(j) == '.') {
					cave[i][j] = 0;
				} else
					cave[i][j] = 1;
			}
		}

		// 0은 점, 1은 미네랄
		N = Integer.parseInt(br.readLine());
		visited = new int[R][C];
		idx = 1;
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());

			boolean isBroke = false;
			if (i % 2 == 0) { // 왼 -> 오
				for (int j = 0; j < C; j++) {
					if (cave[R - n][j] == 1) {
						cave[R - n][j] = 0;
						isBroke = true;
						break;
					}
				}
			} else { // 오 -> 왼
				for (int j = C - 1; j >= 0; j--) {
					if (cave[R - n][j] == 1) {
						cave[R - n][j] = 0;
						isBroke = true;
						break;
					}
				}
			}

			// 떠 있는 클러스터 확인
			if (isBroke) {
				for(int j = 0; j<C; j++) {
					if (cave[R-1][j]==1 && visited[R-1][j]!= idx) {
						bfs(R-1, j);
					}
				}
								
				list = new ArrayList<int[]>();
				for (int x = 0; x < R; x++) {
					for (int y=0; y<C; y++) {
						if (cave[x][y]==1 && visited[x][y] != idx) {
							list.add(new int[] { x, y });
						}
					}
				}
				
				idx++;

				if(list.isEmpty()) continue;
				
				list.sort(new Comparator<int[]>() {

					@Override
					public int compare(int[] o1, int[] o2) {
						int num = Integer.compare(o1[1], o2[1]);

						if (num == 0)
							return o2[0] - o1[0];

						return num;
					}
				});

				// 내리기, 열을 기준으로 간다.
				a: while (true) {

					for (int[] arr : list) {
						int nx = arr[0] + 1;
						int ny = arr[1];
						if (nx>=R || (cave[nx][ny]==1 && !contains(nx, ny))) {
							break a;
						}
					}
					
					// 낙하 가능하면 한 칸 내리기
					for (int[] arr : list) {
						cave[arr[0]][arr[1]] = 0;
					}
					for (int[] arr : list) {
						arr[0]++;
					}
					for (int[] arr : list) {
						cave[arr[0]][arr[1]] = 1;
					}
				}

			} else
				continue;
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (cave[i][j] == 0) {
					System.out.print(".");
				} else {
					System.out.print("x");
				}
			}
			System.out.println();
		}

	}

	private static boolean contains(int x, int y) {
		for (int[] arr : list) {
			if (arr[0] == x && arr[1] == y) return true;
		}
		return false;
	}

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<int[]>();

		queue.add(new int[] { x, y });
		visited[x][y] = idx; // 행을 넣자.

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		while (!queue.isEmpty()) {
			int[] arr = queue.poll();

			int r = arr[0];
			int c = arr[1];
			for (int i = 0; i < 4; i++) {
				int nx = r + dx[i];
				int ny = c + dy[i];

				if (nx >= 0 && nx < R && ny >= 0 && ny < C && visited[nx][ny] != idx && cave[nx][ny] == 1) {
					queue.add(new int[] { nx, ny });
					visited[nx][ny] = idx;
				}
			}
		}

	}

}
