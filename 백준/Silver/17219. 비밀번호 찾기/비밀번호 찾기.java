
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
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 둘째 줄에는 각 사람이 돈을 인출하는데 걸리는 시간 Pi가 주어진다.
		Map<String, String> map = new HashMap<String, String>();
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String url = st.nextToken();
			String pw = st.nextToken();
			
			map.put(url, pw);
		}
		
		for (int i=0; i<M; i++) {
			String url = br.readLine();
			sb.append(map.get(url)).append("\n");
		}
		
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
}
