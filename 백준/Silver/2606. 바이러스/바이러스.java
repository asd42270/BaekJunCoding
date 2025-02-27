
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
	static boolean[] visited;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		for (int i=1; i<=N; i++) {
			graph.put(i, new ArrayList<Integer>());
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		visited = new boolean[N+1];
		
		dfs(graph.get(1), 1);
		
		System.out.println(cnt);
		
		

	}

	private static void dfs(List<Integer> list, int r) {
		
		visited[r] = true;
		
		for(int vertex: list) {
			if(!visited[vertex]) {
				cnt++;
				dfs(graph.get(vertex), vertex);
			}
		}
		
		
	}

}
