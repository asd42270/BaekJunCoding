import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static boolean[] checked;
	static Map<Integer, Set<Integer>> graph;
	static int N, cnt, count;
	static Queue<Integer> queue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// A와 B는 친구다
		graph = new HashMap<Integer, Set<Integer>>();
		for (int i = 1; i <= N; i++) {
			graph.put(i, new HashSet<Integer>());
		}
		

		

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		// 나오는 단계의 총 합이 가장 적은 사람
		int[] result = new int[N+1];
		
		queue = new ArrayDeque<Integer>();

		// 그래프를 모든 노드에서 시작해서 다 탐색할 때까지 보면 됨.
		for (int i=1; i<=N; i++) {
			cnt = 0;
			for (int j = 1; j<=N; j++) {
				checked = new boolean[N+1];
				if(i==j) continue;
				
				count = 0;
				queue.add(i);
				checked[i] = true;
				bfs(j);
				checked[i] = false;
				queue.clear();
				cnt+=count;
			}
			result[i] = cnt;
			

		}

		int minCnt = Integer.MAX_VALUE; int minIdx = -1;
		for (int i=N; i>=1; i--) {
			if(minCnt >= result[i]) {
				minCnt = result[i];
				minIdx = i;
			}
		}
		
		
		System.out.println(minIdx);
		
	}

	private static void bfs(int last) {
		int level = 0;
		while(!queue.isEmpty()) {
			
			//현재 지점에서 탐색해야할 것들
			int size = queue.size();
			
			for (int i=0; i<size; i++) {
				int number = queue.poll();
				
				for (int num : graph.get(number)) {
					if (checked[num]) continue;
					

					if(num==last) {
						count = level+1;
						return;
					}
					
					queue.add(num);
					checked[num] = true;
				}
				
			}
		
			level++;
			
		}				
		
		
	}

}
