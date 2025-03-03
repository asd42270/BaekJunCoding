
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int min = Integer.MAX_VALUE;
	static int N;
	static int M;	
	static int[][] farm;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static Queue<Integer> xQueue = new LinkedList<Integer>();
	static Queue<Integer> yQueue = new LinkedList<Integer>();
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		farm = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j=0; j<M; j++) {
				farm[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// bfs 탐색을 동시에 해야 함.
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if(farm[i][j] == 1) {
					//bfs 할 곳을 미리 저장한다.
					xQueue.add(i);
					yQueue.add(j);
				}
			}
		}
		
		min = Math.min(min, bfs());

		for(int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if(farm[i][j] == 0 && !visited[i][j]) {
					min = -1;
					break;
				}
			}
		}

		sb.append(min);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static int bfs() {
		
		int max = 0;
		
		while(!xQueue.isEmpty() && !yQueue.isEmpty()) {
			
			int row = xQueue.poll();
			int col = yQueue.poll();
			
			for (int i=0; i<4; i++) {
				int r = row + dx[i]; 
				int c = col + dy[i];
				
				// 방문한 적이 없다면
				if (r>=0 && r<N && c>=0 && c<M && !visited[r][c]) {
					// farm의 원소가 -1이면? 거기로 못 감 1이면? 가지만 더하지는 않아요.
					if(farm[r][c] == -1) {
						visited[r][c] = true;
						continue;
					} else if (farm[r][c] == 0) {
						visited[r][c] = true;
						farm[r][c] = farm[row][col] + 1;
						max = Math.max(max, farm[r][c]-1);
						xQueue.add(r);
						yQueue.add(c);
					}
				}
			}
		}
		return max;
		
	}

}