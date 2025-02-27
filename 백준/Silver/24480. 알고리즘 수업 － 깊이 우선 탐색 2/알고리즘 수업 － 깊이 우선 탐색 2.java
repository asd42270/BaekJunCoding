
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
	static boolean[] visited;
	static int[] sequence;
	static int rank = 1;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
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
		sequence = new int [N+1];
		dfs(graph.get(R), R);
		
		for(int i=1; i<=N; i++) {
			System.out.println(sequence[i]);
		}

	}

	private static void dfs(List<Integer> list, int r) {
		
		
		visited[r] = true;
		sequence[r] = rank;
		rank++;
		
		Collections.sort(list);
		Collections.reverse(list);
		
		for (int value: list) {
			if(!visited[value]) {
				dfs(graph.get(value), value);
			}
		}
		
	}

}
