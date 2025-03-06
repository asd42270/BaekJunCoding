import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		
		for (int testCase=1; testCase<=T; testCase++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			// 몇 번째로 인쇄되었는지 궁금한 문서의 현재 위치 M
			// 맨 왼쪽은 0번째
			
			// 두 번째 줄에는 N개 문서의 중요도가 차례대로 주어진다.
			Queue<int[]> queue = new LinkedList<int[]>();
			
			st = new StringTokenizer(br.readLine(), " ");
			int number = 0;
			for (int i=0; i<N; i++) {
				int value = Integer.parseInt(st.nextToken());
				if (i==M) {
					number = value;
				}
				int[] arr = new int[2];
				arr[0] = i; arr[1] = value;
				
				queue.add(arr);
			}

			// 인덱스 관리를 어떻게 할 것인가??
			
			int priority = 1;
			while(!queue.isEmpty()) {
				int[] num = queue.poll();
				
				boolean isValid = true;
				
				for (int[] arr: queue) {
					if (num[1] < arr[1]) {
						isValid = false;
					}
				}
				
				if (!isValid) { // num보다 큰 게 있으면
					queue.add(num);
				} else {
					
					if(number== num[1] && num[0] == M) {
						sb.append(priority).append("\n");
						break;
					}
					priority++;
				}			
			}
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
		
		
		
	}
}
