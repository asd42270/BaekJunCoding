import java.io.*;
import java.util.*;

public class Main {

	static int cnt;
	static List<Integer> list;
	static ArrayList<Long> answer;
	static int depth;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int N = Integer.parseInt(br.readLine());
		
		// 재귀로 해보자
		cnt = 0;
		list = new ArrayList<Integer>();
		answer = new ArrayList<Long>();
		depth = 1;
		while(depth<=10) {
			
			for (int i=0; i<=9; i++) {
				list.add(i);
				recur(i, 1);
				list.remove(list.size()-1);
			}
			
			depth++;
		}
		
		Collections.sort(answer);
		
		if (answer.size() <= N) {
			System.out.println(-1);
		} else System.out.println(answer.get(N));
		
		
	}

	private static void recur(int x, int d) {

		if (d == depth) {
			StringBuilder sb = new StringBuilder();
			for (int num : list) {
				sb.append(num);
			}
			
			answer.add(Long.parseLong(sb.toString()));
			return;
		}
		
		for (int i = x-1; i>=0; i--) {
			list.add(i);
			recur(i, d+1);
			list.remove(list.size()-1);
		}
		
	}

}
