import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int F;
	static int[] parent;
	static int[] rank;
	static Set<String> set;
	static Map<String, Integer> map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {

			F = Integer.parseInt(br.readLine());
			map = new HashMap<String, Integer>();
			parent = new int[F*2+1];
			rank = new int[F*2+1];
			
			for (int i = 1; i<F*2+1; i++) {
				parent[i] = i;
				rank[i] = 1;
			}
			
			for (int i = 0; i < F; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				String name = st.nextToken();
				String friend = st.nextToken();
				
				map.putIfAbsent(name, map.size()+1);
				map.putIfAbsent(friend, map.size()+1);
				
				int cnt = union(map.get(name), map.get(friend));
				sb.append(cnt).append("\n");
			}

		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
	// rank를 현재 가지고 있는 인원 수로 둔다.
	private static int union (int a, int b) {

		int rootA = find(a); // 부모노드
		int rootB = find(b); // 부모 노드
		
		if (rootA == rootB) {
			return rank[rootA]; 
		}
		
		if (rank[rootA] > rank[rootB]) {
			parent[rootB] = rootA;
			return rank[rootA] += rank[rootB];
		} else if (rank[rootA] < rank[rootB]) {
			
			parent[rootA] = rootB;
			return rank[rootB] += rank[rootA];
			
		} else  {
			parent[rootA] = rootB;
			return rank[rootB]+=rank[rootA];
		}
		
	}
	
	// 현재 위치에서의 부모 노드의 부모노드 최상위 부모 노드(루트 노드)를 찾는다.
	private static int find(int x) {

		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		
		return parent[x];
	}

}
