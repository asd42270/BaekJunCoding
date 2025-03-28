import java.io.*;
import java.util.*;

public class Main {

	static List<Edge> edges;
	static boolean[] visited;
	static int[] parent, rank;
	
	static class Edge {
		int s, e;

		public Edge(int s, int e) {
			this.s = s;
			this.e = e;
		}
		
		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {

			st = new StringTokenizer(br.readLine() ," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			parent = new int[N+1];
			rank = new int[N+1];
			for (int i=1; i<=N; i++) {
				parent[i] = i;
			}
			
			edges = new ArrayList<Edge>();
			for (int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				edges.add(new Edge(a, b));
			}
			
			int k = 0;
			for (Edge edge : edges) {
				
				
				union(edge.s, edge.e); // 경로를 연결해줌
				k++;
				if (k>=N-1) break;
				
			}
			
			
			
			sb.append(k).append("\n");
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	private static void union(int a, int b) {

		int rootA = find(a);
		int rootB = find(b);
		
		if (rank[rootA] > rank[rootB]) {
			parent[rootB] = rootA;
		} else {
			parent[rootA] = rootB;
			if (rank[rootA] == rank[rootB]) {
				rank[rootB]++;
			}
		}
		
	}

	private static int find(int x) {

		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		
		
		return parent[x];
	}

}
