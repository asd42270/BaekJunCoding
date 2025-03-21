import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		List<Integer> list = new ArrayList<Integer>(); //지금까지 만들 수 있는 가장 짧은 증가 수열
		for (int num : arr) {
			int idx = Collections.binarySearch(list, num);
			
			if (idx < 0) idx = -idx - 1;
			
			if (idx == list.size()) list.add(num); // 더 크면 뒤에 추가
			else list.set(idx, num);
		}
		
		System.out.println(list.size());
	}
}
