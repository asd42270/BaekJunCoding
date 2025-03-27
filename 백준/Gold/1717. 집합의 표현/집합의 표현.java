import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] parent;
	static int[] rank;
	static int N, M;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		rank = new int[N+1];
		for (int i=1; i<N+1; i++) {
			parent[i] = i;
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int c = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (c == 0) {
				union(a, b);
			} else {
				if(isContain(a, b)) {
					sb.append("YES").append("\n");
				} else sb.append("NO").append("\n");
			}
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
			
	}


	private static boolean isContain(int a, int b) {

		if (find(a) == find(b)) return true;
		
		return false;
	}


	private static void union(int a, int b) {

		int rootA = find(a);
		int rootB = find(b);
		
		if (rank[rootA] > rank[rootB]) {
			parent[rootB] = rootA;
		} else {
			parent[rootA] = rootB;
			if(rank[rootA] == rank[rootB]) rank[rootB]++; 
		}
	}


	private static int find(int x) {

		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		
		return parent[x];
	}
}
