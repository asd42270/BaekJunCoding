
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		

		Queue<Integer> queue = new LinkedList<Integer>();
		List<Integer> list = new ArrayList<Integer>();
 		for (int i=1; i<=N; i++) {
			queue.add(i);
		}
		
		while(queue.size() > 1) {
			
			//k-1동안 poll해서 뒤로 넘겨줌
			for(int i=1; i<=K-1; i++) {
				int num = queue.poll();
				queue.add(num);
			}
			
			int num = queue.poll();
			list.add(num);
			
		}
		
		//마지막
		list.add(queue.poll());
		
		sb.append("<");
		for (int i=0; i<list.size(); i++) {
			if (i==list.size()-1) {
				sb.append(list.get(i)).append(">");
			} else {
				sb.append(list.get(i)).append(", ");
			}
		}
		
				
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
}
