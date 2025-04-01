
import java.io.*;
import java.util.*;

public class Main {

	static Node[] nodes;
	static List<Edge> edges;
	static int[] parent, rank;
	
	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static class Edge implements Comparable<Edge> {
		int s, e;
		double cost;

		public Edge(int s, int e, double cost) {
			this.s = s;
			this.e = e;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Double.compare(cost, o.cost);
		}

		@Override
		public String toString() {
			return "Edge [s=" + s + ", e=" + e + ", cost=" + cost + "]";
		}
		
		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		nodes = new Node[N + 1];
		
		parent = new int[N+1];
		rank = new int[N+1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			nodes[i] = new Node(x, y);
			parent[i] = i;
			rank[i] = 1;
		}

		for (int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		
		edges = new ArrayList<Edge>();
		for (int i=1; i<=N-1; i++) {
			for (int j=i+1; j<=N; j++) {
				double dist = Math.sqrt(Math.pow(nodes[i].x - nodes[j].x, 2) + Math.pow(nodes[i].y - nodes[j].y, 2));
				edges.add(new Edge(i, j, dist));
			}
		}
		
		Collections.sort(edges);
		
//		for (Edge edge : edges) {
//			System.out.println(edge.toString());
//		}
		
		int k=M;
		double sum = 0;
		for(Edge e : edges) {
			
			if (find(e.s) == find(e.e)) continue;
			
			union(e.s, e.e);
			sum+=e.cost;
			
			if(k==N-1) {
				break;
			} else k++;
			
		}
		
		if (sum > 0) System.out.printf("%.2f",sum);
		else System.out.println(0);

	}

	private static void union(int a, int b) {

		int rootA = find(a);
		int rootB = find(b);
		
		if(rank[rootA] > rank[rootB]) {
			parent[rootB] = rootA;
		} else {
			parent[rootA] = rootB;
			if(rank[rootA] == rank[rootB]) {
				rank[rootB]++;
			}
		}
		
	}

	private static int find(int x) {

		if(parent[x]!=x) {
			parent[x] = find(parent[x]);
		}
		
		return parent[x];
	}
}
