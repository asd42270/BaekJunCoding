import java.io.*;
import java.util.*;

public class Main {
	
	static int S, time;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		S = Integer.parseInt(br.readLine());
		
		time = Integer.MAX_VALUE;
		
		Queue<int[]> queue = new ArrayDeque<int[]>();
		bfs(queue);
		
		
		
		System.out.println(time);
	}

	private static void bfs(Queue<int[]> queue) {
		
		boolean[][] visited = new boolean[1001][1001];
		queue.offer(new int[] {1, 0, 0});
		visited[1][0] = true;
		
		while(true) {
			int[] arr = queue.poll();
			
			// [0]은 이모지 개수, [1]은 클립보드 [2] 실행시간
			if (arr[0] == S) {
				time = arr[2];
				return;
			}
			
			// 복사
			if (arr[0] > 0 && arr[1] <=1000 && arr[0] <= 1000 && !visited[arr[0]][arr[0]]) {
				queue.offer(new int[] {arr[0], arr[0], arr[2]+1});
				visited[arr[0]][arr[0]] = true;
			}
			
			//붙여넣기
			if (arr[1] > 0 && arr[1] <=1000 && arr[0] + arr[1] <= 1000 && !visited[arr[0]+arr[1]][arr[1]] ) {
				queue.offer(new int[] {arr[0] + arr[1], arr[1], arr[2] + 1});
				visited[arr[0]+arr[1]][arr[1]] = true;
			}
			
			if (arr[0] > 0 && arr[1] <=1000 && arr[0] <= 1000  && !visited[arr[0]-1][arr[1]]) {
				queue.offer(new int[] {arr[0]-1, arr[1], arr[2] + 1});
				visited[arr[0]-1][arr[1]] = true;
			}
		}
		
	}
}
