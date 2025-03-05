import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i=0; i<N; i++) {
			map.put(Integer.parseInt(st.nextToken()), 1);
		}
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(map.get(num) == null) {
				sb.append(0).append("\n");
			} else {
				sb.append(1).append("\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		

	}
}
