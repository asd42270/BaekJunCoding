import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
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
		
		Map<Integer, String> pocketmon = new HashMap<Integer, String>();
		for(int i=1; i<=N; i++) {
			pocketmon.put(i, br.readLine());
		}
		
		Map<String, Integer> reverse = new HashMap<String, Integer>();
		for(Entry<Integer, String> kv : pocketmon.entrySet()) {
			reverse.put(kv.getValue(), kv.getKey());
		}
		
		for(int i=0; i<M; i++) {
			String question = br.readLine();
			try {
				int number = Integer.parseInt(question);
				sb.append(pocketmon.get(number)).append("\n");
			}catch(NumberFormatException e) {
				sb.append(reverse.get(question)).append("\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}