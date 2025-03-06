import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		
		int M = Integer.parseInt(br.readLine());
		
		Set<Byte> set = new HashSet<Byte>();
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String order = st.nextToken();
			if (order.equals("add")) {
				set.add(Byte.parseByte(st.nextToken()));
				
			} else if (order.equals("remove")) {
				set.remove(Byte.parseByte(st.nextToken()));
				
			} else if (order.equals("check")) {
				if(set.contains(Byte.parseByte(st.nextToken())) ) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
				
			} else if (order.equals("toggle")) {
				byte number = Byte.parseByte(st.nextToken());
				if(set.contains(number)) {
					set.remove(number);
				} else {
					set.add(number);
				}
				
			} else if (order.equals("all")) {
				
				for (int k=1; k<=20; k++) {
					byte number= Byte.parseByte(String.valueOf(k));
					set.add(number);
				}
				
			} else {
				set.clear();
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
		
	}
}
