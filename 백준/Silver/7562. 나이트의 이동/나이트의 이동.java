
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	
	//나이트의 8방향을 저장한다. 
	static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
	static Queue<Integer> xQueue = new LinkedList<Integer>();
	static Queue<Integer> yQueue = new LinkedList<Integer>();
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		

		int T = Integer.parseInt(br.readLine());
		
		for (int testCase=1; testCase<=T; testCase++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			int[][] map = new int [N][N];
			boolean[][] visited = new boolean [N][N];
			
			recursive(x, y, map, visited, r, c);
			xQueue.clear();
			yQueue.clear();
			
			sb.append(map[r][c]).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

	private static void recursive(int x, int y, int[][] map, boolean[][] visited, int r, int c) {
		
		visited[x][y] = true;
		xQueue.add(x);
		yQueue.add(y);
		
		while(!xQueue.isEmpty() && !yQueue.isEmpty()) {
			
			int row = xQueue.poll();
			int col = yQueue.poll();
			
			if(row == r && col == c  ) {
				return;
			}
			
			for (int i=0; i<8; i++) {
				int sRow = row + dx[i];
				int sCol = col + dy[i];
				
				if(sRow >= 0 && sRow<N && sCol>=0 && sCol<N && !visited[sRow][sCol]) { 
						visited[sRow][sCol] = true;
						map[sRow][sCol] = map[row][col] + 1;
						xQueue.add(sRow);
						yQueue.add(sCol);				
				}
			}
			
		}
		
		
	}

}
