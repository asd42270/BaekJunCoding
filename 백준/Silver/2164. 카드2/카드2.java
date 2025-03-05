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
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		// N=1 1, N=2 1버리고 2, N=3 123 -> 1버리고 32 -> 2, N=4 1234 -> 342 -> 24 -> 4
		// N=5 12345 -> 3452 -> 524 -> 42 -> 2, N=6 123456 -> 34562 -> 5624 -> 246 -> 64 -> 4 
		// N=7 1234567 -> 345672 -> 56724 -> 7246 -> 462 -> 62 -> 2
		// N=8 12345678 -> 3456782 -> 567824 -> 78246 -> 2468 -> 684 -> 48 -> 8
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		if (N%2==0) {
			for (int i=1; i<=N; i++) {
				if(i%2==0) {
					queue.add(i);
				}
			}
		} else {
			queue.add(N);
			for (int i=1; i<=N; i++) {
				if(i%2==0) {
					queue.add(i);
				}
			}
		}
		
		while(queue.size() > 1) {
			queue.poll();
			int num = queue.poll();
			queue.add(num);
		} 
		
		sb.append(queue.poll());
 		
		
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		

	}
}
