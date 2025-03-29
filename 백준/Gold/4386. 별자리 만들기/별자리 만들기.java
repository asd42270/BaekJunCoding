
import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static boolean[] visited;
	static PriorityQueue<Edge> pq;
	
	static class Edge implements Comparable<Edge>{
		int start, end;
		double dist;

		public Edge(int start, int end, double dist) {
			this.start = start;
			this.end = end;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", dist=" + dist + "]";
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Double.compare(dist, o.dist);
		}

	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		visited = new boolean[N];
		pq = new PriorityQueue<Edge>();
		
		double[][] star = new double[N][2];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			star[i][0] = Double.parseDouble(st.nextToken());
			star[i][1] = Double.parseDouble(st.nextToken());
		}
		
		
		for(Edge edge : pq) {
			System.out.println(edge.toString());
		}
		
		visited[0] = true;
		for (int i=1; i<N; i++) {
			Edge edge = new Edge(0, i, Math.sqrt(Math.pow(star[0][0]-star[i][0], 2)+Math.pow(star[0][1]-star[i][1], 2)));
			pq.add(edge);
		}
		
		double sum = 0;
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			int end = edge.end;
			
			if (visited[end]) continue;
			
			visited[end] = true;
			sum+=edge.dist;
			
			for (int i=0; i<N; i++) {
				if (visited[i]) continue;
				Edge nEdge = new Edge(end, i, Math.sqrt(Math.pow(star[end][0]-star[i][0], 2)+Math.pow(star[end][1]-star[i][1], 2)));
				pq.offer(nEdge);
			}
			
		}
		
		System.out.printf("%.2f", sum);
	}
}
