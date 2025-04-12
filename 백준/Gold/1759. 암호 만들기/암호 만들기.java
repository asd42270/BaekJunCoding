import java.io.*;
import java.util.*;

public class Main {

	static int cnt, L, C;
	static char[] arr;
	static List<Character> list;
	static List<String> ans;
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		// L만큼
		arr = new char[C];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i=0; i<C; i++) {
			char ch = st.nextToken().charAt(0);
			arr[i] = ch;
		}
		
		Arrays.sort(arr);
		list = new ArrayList<Character>();
		ans = new ArrayList<String>();
		for (int i=0; i<C; i++) {
			list.add(arr[i]);
			perm(i, 1);
			list.remove(list.size()-1);
		}
		
		Collections.sort(ans);
		for (String answer :ans) {
			System.out.println(answer);
		}
		
	}


	private static void perm(int x, int depth) {
		if (depth == L) {
			
			int vowel = 0;
			for (char ch : list ) {
				if (ch=='a' || ch=='e' || ch=='i' || 
						ch=='o' || ch=='u') {
					vowel++;
				}
			}
			
			int cons = list.size() - vowel;
			
			if (vowel < 1 || cons < 2) return;
			
			StringBuilder sb = new StringBuilder();
			for (char ch : list) {
				sb.append(ch);
			}
			
			ans.add(sb.toString());
			return;
		}
		
		for (int i=x+1; i<C; i++) {
			list.add(arr[i]);
			perm(i, depth+1);
			list.remove(list.size()-1);
		}
	}

}
