import java.io.*;
import java.util.*;

public class Main {

	static int ans, N, babySize;
	static int[][] space;
	static int[] baby;
	static int eat;
	static boolean isValid;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		baby = new int[2];
		babySize = 2;
		space = new int[N][N];
		ans = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int v = Integer.parseInt(st.nextToken());
				space[i][j] = v;
				if (v == 9) {
					baby[0] = i;
					baby[1] = j;
					space[i][j] = 0;
				}
			}
		}

		eat = 0;
		isValid = true;
		while (true) {
			// 0. 있는 지를 먼저 구한다.

			if (!isValid) break;
			
			bfs();
			
			if (eat == babySize) {
				eat = 0;
				babySize++;
			}
		}

		System.out.println(ans);
	}
	
	private static boolean isValid() {
		
		List<int[]> dots = new ArrayList<int[]>();

		// 1. 작은 놈이 있으면
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (space[i][j] < babySize && space[i][j] != 0) {
					dots.add(new int[] { i, j });
				}
			}
		}

		if (dots.isEmpty())
			return false;

		return true;
	}

	private static void bfs() {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		boolean[][] visited = new boolean[N][N];
		int[] dx = { -1, 0, 0, 1 };
		int[] dy = { 0, -1, 1, 0 };
		List<int[]> list = new ArrayList<int[]>();

		queue.offer(new int[] {baby[0], baby[1], 0});
		visited[baby[0]][baby[1]] = true;

		while (!queue.isEmpty()) {
			
			int size = queue.size();
			
			for (int j=0; j<size; j++) {
				int[] arr = queue.poll();

				for (int i = 0; i < 4; i++) {
					int nx = arr[0] + dx[i];
					int ny = arr[1] + dy[i];

					// 나보다 크면 못 가요
					if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]
							&& space[nx][ny] <= babySize) {
						visited[nx][ny] = true;
						queue.offer(new int[] {nx, ny, arr[2]+1});
												
						if (space[nx][ny] < babySize && space[nx][ny]!=0) {
							list.add(new int[] {nx, ny, arr[2]+1});
						}
					}
				}
			}
		}
		
		if (!list.isEmpty()) goTo(list);
		else isValid = false;
	}

	private static void goTo(List<int[]> list) {
		
		Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {

				int num = Integer.compare(o1[2], o2[2]);
				
				if (num ==0) {
					int n = Integer.compare(o1[0], o2[0]);
					
					if(n == 0) return Integer.compare(o1[1], o2[1]);
					else return n;
				}
				
				return num;
			}
			
		});
		
		int[] arr = list.get(0);
		eat++;
		ans += arr[2];
		baby[0] = arr[0];
		baby[1] = arr[1];
		space[arr[0]][arr[1]] = 0;
		
		return;
	}

}
