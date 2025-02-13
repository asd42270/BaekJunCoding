
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		int[][] concert = new int[R][C];

		
		if (C*R < K) {
			sb.append(0);
		} else {
			int count = 0;
			int top=0; int bottom = R-1; int left=0; int right=C-1;
a:			while(count!=K && left<=right && top<=bottom) {
				
				//위로
				//행이
				for(int i=bottom; i>=top; i--) {
					count++;
					concert[i][left] = count;
					if (count==K) {
						sb.append(left+1).append(" ").append(R-i);
						break a ;
					}
				}
				left++;
				
				//오른쪽으로
				for(int i=left; i<=right; i++) {
					count++;
					concert[top][i] = count;
					if (count==K) {
						sb.append(i+1).append(" ").append(R-top);
						break a;
					}
				}
				top++;
				
				//아래로
				for(int i=top; i<=bottom; i++) {
					count++;
					concert[i][right] = count;
					if (count==K) {
						sb.append(right+1).append(" ").append(R-i);
						break a;
					}
				}
				right--;
				
				//왼쪽으로
				for(int i=right; i>=left; i--) {
					count++;
					concert[bottom][i] = count;
					if (count==K) {
						sb.append(i+1).append(" ").append(R-bottom);
						break a;
					}
				}
				bottom--;
			}
		}
		
		

		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
