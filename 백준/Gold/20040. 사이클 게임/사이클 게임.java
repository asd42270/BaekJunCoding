
import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static int[] parent;
	static int[] rank;
	static int[] edgeCnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 매 차례 마다 플레이어는 두 점을 선택해서 이를 연결하는 선분을 긋는데
		// 이미 그린 다른 선분과 교차하는 것은 가능하다.
		// 처음으로 사이클을 완성하는 순간 게임이 종료된다.
		// 사이클 C는 플레이어가 그린 선분들의 부분집합으로, 다음 조건을 만족한다.
		// C에 속한 임의의 선분의 한 끝점에서 출발하여 모든 선분을 한 번씩만 지나서 출발점으로 되돌아올 수 있다.
		// 게임의 진행 상황이 주어지면 몇 번째 차례에서 사이클이 완성되었는지, 
		// 혹은 아직 게임이 진행 중인지를 판단하는 프로그램을 작성하려 한다.
		// 입력으로 점의 개수 n과 m 번째 차례까지의 게임 진행 상황이 주어지면 사이클이 완성 되었는지를 판단
		// 완성되었다면 몇 번째 차례에서 처음으로 사이클이 완성된 것인지를 출력하는 프로그램을 작성하시오.
		parent = new int[N];
		rank = new int[N];
		edgeCnt = new int[N]; // 이 점에서 이어지는 간선의 수
		
		for (int i=0; i<N; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
		
		int ans = 0;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (find(a) == find(b)) {
				ans = i+1;
				break;
			}
			
			union(a, b);
		}
		
		System.out.println(ans);
	}

	private static void union(int a, int b) {

		int rootA = find(a);
		int rootB = find(b);
		
		if (rank[rootA] > rank[rootB]) {
			parent[rootB] = rootA;

		} else {
				parent[rootA] = rootB;
				if (rank[rootA] == rank[rootB]) rank[rootB]++;
		}
		
	}

	private static int find(int x) {

		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		
		return parent[x];
	} 
}
