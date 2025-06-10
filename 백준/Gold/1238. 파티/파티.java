import java.io.*;
import java.util.*;

public class Main {
	
	static Map<Integer, List<Node>> map;

	static class Node implements Comparable<Node> {

		int to, weight;
		
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}

		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		map = new HashMap<Integer, List<Node>>();
		
		for (int i=1; i<=N; i++) {
			map.put(i, new ArrayList<Node>());
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			map.get(from).add(new Node(to, weight));
		}
		
		int max = Integer.MIN_VALUE;
		
		for (int i = 1; i <= N; i++) {
		    int[] distance = dijkstra(i, N);
		    int[] reverse = dijkstra(X, N);
		    
		    int dist = distance[X] + reverse[i];
		    max = Math.max(max, dist);
		}
		
		System.out.println(max);
		
	}

	private static int[] dijkstra(int start, int N) {
	    PriorityQueue<Node> pq = new PriorityQueue<>();
	    int[] dist = new int[N + 1];
	    Arrays.fill(dist, Integer.MAX_VALUE);
	    dist[start] = 0;
	    pq.offer(new Node(start, 0));
	    
	    while (!pq.isEmpty()) {
	        Node current = pq.poll();
	        if (dist[current.to] < current.weight) continue;
	        
	        for (Node next : map.get(current.to)) {
	            int cost = dist[current.to] + next.weight;
	            if (cost < dist[next.to]) {
	                dist[next.to] = cost;
	                pq.offer(new Node(next.to, cost));
	            }
	        }
	    }
	    return dist;
	}
}
