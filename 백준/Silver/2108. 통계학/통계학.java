import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[] nums = new int[N];
		int[] count = new int[8001];
		
		double sum = 0;
		for (int i=0; i<N; i++) {
			int value = Integer.parseInt(br.readLine());
			nums[i] = value;
			sum += value;
			count[value+4000]++;
		}
		
		Arrays.sort(nums);
		
		// 1. 평균
		System.out.println(Math.round(sum/N));
		
		// 2. 중앙값
		if(N%2!=0) {
			System.out.println(nums[N/2]);
		} else {
			System.out.println(nums[N/2]);			
		}
		
		// 3. 최빈값
		int maxIdx = 0;
		int max = Integer.MIN_VALUE;
		for (int i=0; i<8001; i++) {
			if (count[i] > max) {
				max = count[i];
				maxIdx = i;
			}
		}
		
		int cnt = 0;
		for (int i=0; i<8001; i++) {
			if (count[i] == max && i != maxIdx) { //
				cnt++;
				System.out.println(i-4000);
				break;
			}
		
		}
		if(cnt==0) System.out.println(maxIdx-4000);
		
		
		// 4. 범위
		System.out.println(nums[N-1] - nums[0]);
		
		

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
}
