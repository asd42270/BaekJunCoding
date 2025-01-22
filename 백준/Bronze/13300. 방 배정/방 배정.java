import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nk = br.readLine().split(" ");
		
		int N = Integer.parseInt(nk[0]);
		int K = Integer.parseInt(nk[1]);
		
		int[] year = {0, 0, 0, 0, 0, 0};
		int[] maleYear = {0, 0, 0, 0, 0, 0};//year 에서 manYear 빼면 여자 학생 수
		
		int count=0;
		
		for (int i = 0; i < N; i++) {
			String[] sy = br.readLine().split(" ");
			
			int S = Integer.parseInt(sy[0]);
			int Y = Integer.parseInt(sy[1]);
			
			if (S==1) maleYear[Y-1]++;
			
			year[Y-1]++;
		}
		
		for (int i = 0; i < 6; i++) {
			
			int male = 0; int female = 0;
			if (maleYear[i] > 0 ) {
				male =  (maleYear[i]/K); //5명 최대 3명 1개 나머지 2명
				if(maleYear[i]%K > 0 ) {male++;}
			
			}
			
			if(year[i]-maleYear[i] > 0) {
				female = (year[i]-maleYear[i])/K;
				if(((year[i]-maleYear[i])%K > 0)) {female++;} 
			}

		
			count+=((male + female));
		}
		
		System.out.println(count);
		
	}
}
