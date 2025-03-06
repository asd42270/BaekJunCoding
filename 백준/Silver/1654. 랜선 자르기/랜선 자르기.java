import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long mid = 0;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		
		st = new StringTokenizer(br.readLine(), " ");
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] wire = new int[K+1];
		for (int i=1; i<=K; i++) {
			wire[i] = Integer.parseInt(br.readLine());
		}
		
		//N개보다 많이 만드는 것도 N개를 만드는 것에 포함된다.

		//이분 탐색으로 반복의 범위를 줄여 나감 -> 개수로 범위를 줄이는데, N보다 크면 왼쪽으로, N보다 작으면 오른쪽
		
		long left = 1; long right = 2147483647; //랜선 길이
		while(left <= right) {
			mid = (left+right)/2;
			
			long sum = 0;
			for (int i=1; i<=K; i++) {
				sum+=(wire[i] / mid);
			}
						
			if (sum < N) { // N이 더 크면? -> N이 오른쪽에 있다.  
				right = mid-1;
			} else if (sum >= N) { // N이 더 작으면?
				left = mid+1;
				mid = left;
			}
			
		}
		
		System.out.println(mid-1);
		
		
	}
}
