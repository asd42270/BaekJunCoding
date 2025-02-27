
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
	static boolean[] visited;
	static Queue<Integer> queue = new LinkedList<Integer>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			graph.put(i, new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		visited = new boolean[N + 1];
		dfs(graph.get(r), r);
		System.out.println();
		visited = new boolean[N + 1];
		bfs(r);
	
		
	}

	private static void bfs(int r) {
		
		visited[r] = true;
		queue.add(r);
		System.out.print(r + " ");
		
		while(!queue.isEmpty()) {
		
			int num = queue.poll();
			
			if(!isValid()) {
				return;
			}
			
			List<Integer> arr = graph.get(num);
			Collections.sort(arr);
			for(int vertex: arr) {
				if(!visited[vertex] && isValid()) {
					visited[vertex] = true;
					System.out.print(vertex + " ");
					queue.add(vertex);
				}
			}
			
		}
		
	}

	private static void dfs(List<Integer> list, int r) {
		
		visited[r] = true;
		System.out.print(r + " ");
		if(!isValid()) {
			return;
		}

		Collections.sort(list);
		for (int vertex : list) {
			if (!visited[vertex] && isValid()) {
				dfs(graph.get(vertex), vertex);
			}
		}

	}

	private static boolean isValid() {
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				return true;
			}
		}
		return false;
	}

}
