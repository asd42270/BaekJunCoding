import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int[] arr;
	static List<Integer> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		list = new ArrayList<Integer>();
		perm(0, 0);

	}

	private static void perm(int start, int k) {

		if (k==M) {

			for (int i=0; i<M; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i=start; i<N; i++) {
			if(list.contains(arr[i])) continue;
			list.add(arr[i]);
			perm(start, k+1);
			list.remove(list.size()-1);
		}
	}

}
