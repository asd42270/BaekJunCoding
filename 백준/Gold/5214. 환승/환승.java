import java.io.*;
import java.util.*;

public class Main {
	

	static class HyperTube {
		int idx;
		Set<Integer> count;
		int depth;
		
		public HyperTube(int idx, Set<Integer> count, int depth) {
			this.idx = idx;
			this.count = count;
			this.depth = depth;
		}
		
		public void setDepth(int depth) {
			this.depth = depth;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		// 각 번호가 연결되어 있는 튜브를 관리하는 맵
		Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
		
		List<HyperTube> tubes = new ArrayList<HyperTube>();
		Queue<HyperTube> queue = new ArrayDeque<HyperTube>();
		boolean[] visited = new boolean[M+1];
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			Set<Integer> set = new HashSet<Integer>();
			
			boolean hasN = false;
			for (int j=0; j<K; j++) {
				int n = Integer.parseInt(st.nextToken());
				set.add(n);
				
				map.putIfAbsent(n, new HashSet<>());
				map.get(n).add(i + 1);
				
				if (n==N) hasN = true;
			}
			HyperTube hyperTube = new HyperTube(i+1, set, 1);
			tubes.add(hyperTube);
			
			if (hasN) {
				queue.add(hyperTube);
				visited[hyperTube.idx] = true;
			}
		}
		
		int answer = Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			HyperTube hyperTube = queue.poll();
			
			if (hyperTube.count.contains(1)) {
				
				if (N==1) {
					answer = 1;
				} else {
					answer = Math.min(answer, hyperTube.depth+1);
				}
				
				break;
			} else {
				for (Integer num : hyperTube.count) {
					Set<Integer> set = map.get(num);
					
					if (set != null) {
						for (Integer number : set) {
							if (!visited[number]) {
								HyperTube tube = tubes.get(number-1);
								tube.setDepth(hyperTube.depth + 1);
								visited[number] = true;
					            queue.add(tube);
							}
						}
					}
				}
						
			}
			
		}
		
		
		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
		

	}

}
