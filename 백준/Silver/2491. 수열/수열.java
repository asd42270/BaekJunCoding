import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		// 길이가 가장 긴 수열 : 값이 연속해서 커지는 것 or 연속해서 작아지는 것 같은 수 포함
		// while 문으로 배열을 탐색하면서 다음 같으면?
		// 둘 다 가능, 크면? 커지는 것만 판단, 작으면? 작아지는 것만 판단
		// 크다? 작아지는 것은 안되니까 작아지는 것을 다시해야됨 count를 0, 시작인덱스를 지정
		// 작다? 커지는 것은 안되니까 커지는 것을 다시, count를 0, 시작 인덱스 지정

		int N = Integer.parseInt(br.readLine()); 
		
		int[] arr = new int[N];
		int[] plusDp = new int[N];
		int[] minusDp = new int[N];
		
		//배열에 값을 넣는다.
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		plusDp[0] = 1;
		minusDp[0] = 1;
		

		for(int i=1; i<N; i++) {
				//증가 or 감소 or 같은 거
				if (arr[i] > arr[i-1]) {
					plusDp[i] = plusDp[i-1] + 1;
					minusDp[i] = 1;
				} else if (arr[i] < arr[i-1]) {
					plusDp[i] = 1;
					minusDp[i] = minusDp[i-1] + 1;
				} else {
					minusDp[i] = minusDp[i-1] + 1;
					plusDp[i] = plusDp[i-1] + 1;
				}
			}
		
		int max = Integer.MIN_VALUE;
		for (int i=0; i<N; i++) {
			if (minusDp[i] > max) {
				max = Math.max(max, minusDp[i]);
			}
			
			if(plusDp[i]>max) {
				max = Math.max(max, plusDp[i]);
			}
		}
		
		sb.append(max);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}		

	}
