import java.io.*;
import java.util.*;

public class Main {

	static Edge[] edges;
	static boolean[] visited;
	static int[] parent, rank;

	static class Edge implements Comparable<Edge> {
		int s, e, v;

		public Edge(int s, int e, int v) {
			this.s = s;
			this.e = e;
			this.v = v;
		}

		@Override
		public int compareTo(Edge edge) {
			// TODO Auto-generated method stub
			return Integer.compare(v, edge.v);
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		rank = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		edges = new Edge[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(a, b, v);
		}

		Arrays.sort(edges);

		int sum = 0;
		for (Edge edge : edges) {

			if (find(edge.s) != find(edge.e)) {
				union(edge.s, edge.e); // 경로를 연결해줌
				sum += edge.v;
			}

		}

		sb.append(sum).append("\n");

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
