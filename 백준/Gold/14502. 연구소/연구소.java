
import java.util.*;
import java.io.*;

public class Main {

	static int N, M, maxVal;
	static int[][] lab, temp;
	static boolean[][] visited;
	static Queue<int[]> queue;
	static List<int[]> list;
	static int[] dx =  {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lab = new int[N][M];
		temp = new int[N][M];
		queue = new ArrayDeque<int[]>();
		list = new ArrayList<int[]>();
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine() ," ");
			for (int j=0; j<M; j++) {
				int value = Integer.parseInt(st.nextToken());
				if (value == 2) {
					list.add(new int[] {i, j});
				}
				lab[i][j] = value;
				temp[i][j] = value;
			}
		}
		
		maxVal = Integer.MIN_VALUE;
		comb(0);
		
		System.out.println(maxVal);
		
	}

	private static void comb(int idx) {

		if (idx == 3) {
			
			
			List<int[]> virus = new ArrayList<int[]>();
			
			visited = new boolean[N][M];
			for (int[] germ: list) {
				queue.add(germ);
				visited[germ[0]][germ[1]] = true;
				while(!queue.isEmpty()) {
					int[] arr = queue.poll();
					for (int i=0; i<4; i++) {
						int nx = arr[0] + dx[i];
						int ny = arr[1] + dy[i];
						if (nx>=0 && nx < N && ny >=0 && ny< M && !visited[nx][ny]
								&& lab[nx][ny] == 0) {
							visited[nx][ny] = true;
							lab[nx][ny] = 2;
							queue.add(new int[] {nx, ny});
							virus.add(new int[] {nx, ny});
						}
					}
				}
			}
			
			int safe = 0;
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					if (lab[i][j] == 0) safe++;
				}
			}
			
			maxVal = Math.max(safe, maxVal);
			
			// 세균으로 채워지는 부분을 지워야 됨.
			for (int[] arr: virus) {
				lab[arr[0]][arr[1]] = 0;
			}
			
			queue.clear();
			
			return;
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				
				if (lab[i][j] == 1 || lab[i][j] == 2) continue;
				
				lab[i][j] = 1;
				comb(idx+1);
				lab[i][j] = 0;
			}
		}
		
	}
}
