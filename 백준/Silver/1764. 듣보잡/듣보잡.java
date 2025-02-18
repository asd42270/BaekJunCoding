
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
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
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Set<String> listen = new HashSet<String>();
		Map<String, String> never = new HashMap<String, String>();

		for (int i = 0; i < N; i++) {
			listen.add(br.readLine());
		}

		for (int i = 0; i < M; i++) {
			String name = br.readLine();
			if (listen.contains(name)) {
				never.put(name, " ");
			}
		}

		List<String> keys = new ArrayList<String>();
		for (String name : never.keySet()) {
			keys.add(name);
		}

		keys.sort((s1, s2) -> s1.compareTo(s2));
		sb.append(keys.size()).append("\n");
		for(int i=0; i<keys.size(); i++) {
			sb.append(keys.get(i)).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}