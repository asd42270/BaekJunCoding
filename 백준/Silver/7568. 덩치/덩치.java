import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());

		int[][] people = new int[N][2];
		int[] rank = new int[N];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			// 몸무게가 x kg이고 키가 y cm
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			// (x, y), (p, q)라고 할 때 x > p 그리고 y > q 이라면 우리는 A의 덩치가 B의 덩치보다 "더 크다"고 말한다.
			// 키도 크고, 몸무게도 더 나가면 덩치
					
			// 자신보다 더 큰 덩치의 사람이 k명이라면 그 사람의 덩치 등수는 k+1이 된다.
			people[i][0] = x;
			people[i][1] = y;
			
			// (45, 181), (55, 173)이라면 몸무게는 D가 C보다 더 무겁고, 키는 C가 더 크므로, 
			// "덩치"로만 볼 때 C와 D는 누구도 상대방보다 더 크다고 말할 수 없다.			
		}
		
		for (int i=0; i<N; i++) {
			int k = 0;
			for (int j = 0; j<N; j++) {
				if (j!=i && people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
					k++;
				}
			}
			
			rank[i] = k+1;
		}
		
		for (int num : rank) {
			System.out.print(num + " ");
		}
		

	}
}
