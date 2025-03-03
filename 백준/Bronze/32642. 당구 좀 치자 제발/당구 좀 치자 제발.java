
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		long[] arr = new long[N];
		long[] anger = new long[N];
		
		long angry = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if (arr[0]==1) {
			anger[0] = 1;
		}
		
		if (arr[0]==0) {
			anger[0] = -1;
		}
		
		for (int i=1; i<N; i++) {
			if(arr[i] == 1) {
				anger[i] = anger[i-1] + 1;
			} else if(arr[i] == 0) {
				anger[i] = anger[i-1] - 1;
			}
		}

		

		for (int i=0; i<N; i++) {
			angry += anger[i];
		}
		
		System.out.println(angry);
	}


}