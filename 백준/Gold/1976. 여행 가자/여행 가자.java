import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[] parent, plan, rank;
	static int N, M;
	static int[][] map;
	static List<Pair> list;

	static class Pair {
		int start, end;

		public Pair(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "Pair [start=" + start + ", end=" + end + "]";
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine()); // 도시 수
		M = Integer.parseInt(br.readLine()); // 여행 계획에 속한 도시들의 수

		parent = new int[N + 1];
		rank = new int[N + 1];
		list = new ArrayList<Pair>();
		for (int i = 1; i < N + 1; i++) {
			parent[i] = i;
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				int value = Integer.parseInt(st.nextToken());
				if (value == 0)
					continue;
				list.add(new Pair(i, j));
			}
		}

		plan = new int[M + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i < M + 1; i++) {
			plan[i] = Integer.parseInt(st.nextToken());
		}

			// 경로를 가지고 유니온 파인드를 한다.
			for (Pair pair : list) {
				union(pair.start, pair.end);
			}

			int a = find(plan[1]);
			boolean isValid = true;
			for (int i = 2; i <= M; i++) {
				int b = find(plan[i]);
				
				if(a!=b) {
					isValid=false;
					break;
				}
					
			}

			if (isValid)
				System.out.println("YES");
			else
				System.out.println("NO");

	}

	private static void union(int a, int b) {

		int rootA = find(a);
		int rootB = find(b);

		if (rank[rootA] > rank[rootB]) {
			parent[rootB] = rootA;
		} else {
			parent[rootA] = rootB;
			if (rank[rootA] == rank[rootB])
				rank[rootB]++;
		}
	}

	private static int find(int x) {

		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}

		return parent[x];
	}
}
