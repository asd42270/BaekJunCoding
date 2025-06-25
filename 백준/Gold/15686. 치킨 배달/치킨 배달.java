import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int dist, N;
	static List<int[]> chickenStore, removeStore, house;
	static boolean[][] opened;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		

		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		opened = new boolean[N][N];
		chickenStore = new ArrayList<int[]>();
		house = new ArrayList<int[]>();

		int chicken = 0;
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				if (num==2) {
					opened[i][j] = true;
					chickenStore.add(new int[] {i, j});
					chicken++;
				}
				
				if (num==1) {
					house.add(new int[] {i, j});
				}
			}
		}
		
		chickenStore.sort(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {

				int num = Integer.compare(o1[0], o2[0]);
				
				if (num == 0) return Integer.compare(o1[1], o2[1]);
				
				return num;
			}
		});
		
		// 현재 치킨집의 개수가 M보다는 많이 있다.
		int diff = chicken - M;
		
		// diff 개수만큼 폐업시키고 계산
		dist = Integer.MAX_VALUE;
		removeStore = new ArrayList<int[]>();
		getChickenDistance(diff, map, 0);
		
		System.out.println(dist);

	}

	private static void getChickenDistance(int diff, int[][] map, int start) {
		
		if(removeStore.size() == diff) {
			for (int[] arr : removeStore) {
				if (opened[arr[0]][arr[1]]) {
					opened[arr[0]][arr[1]] = false;
				}
			}
			
			// 가까운 녀석을 계산해요
			int result = 0;
			for (int[] arr : house) {
				int min = Integer.MAX_VALUE;
				for (int [] chicken : chickenStore) {
					if(!opened[chicken[0]][chicken[1]]) continue;
					
					min = Math.min(min, Math.abs(arr[0]-chicken[0]) + Math.abs(arr[1] - chicken[1]));
				}
				
				result += min;
			}
			
			dist = Math.min(result, dist);
			
			// 계산을 마치면?opened를 초기화 해줘요
			for (int[] arr : removeStore) {
				if (!opened[arr[0]][arr[1]]) {
					opened[arr[0]][arr[1]] = true;
				}
			}
			
			return;
		}

		for (int i=start; i<chickenStore.size(); i++) {
			int[] arr = chickenStore.get(i);
			if (opened[arr[0]][arr[1]]) {
				removeStore.add(arr);
				getChickenDistance(diff, map, i+1);
				removeStore.remove(removeStore.size()-1);
			}
		}
		
	}

}
