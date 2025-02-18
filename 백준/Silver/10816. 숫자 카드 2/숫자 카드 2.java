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

		int N = Integer.parseInt(br.readLine());
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			int number = Integer.parseInt(st.nextToken());
			if(map.containsKey(number)) {
				int count = map.get(number);
				map.put(number, ++count);
			} else {
				map.put(number, 1);
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(map.containsKey(num)) {
				int cnt = map.get(num);
				sb.append(cnt).append(" ");
			} else {
				sb.append(0).append(" ");
			}

		}
		

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}