
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int original;
	static String[][] starArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		original = (N-1)*4+1;
		starArr = new String[(N-1)*4+1][(N-1)*4+1];
		
		star(N, 0);

		for (int i=0; i<(N-1)*4+1; i++) {
			for (int j=0; j<(N-1)*4+1; j++) {

				if (starArr[i][j] == null) {
					starArr[i][j] = " ";
				}
				
				System.out.print(starArr[i][j]);
			}
			System.out.println();
		}
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void star(int n, int startIdx) {
		if (n==1) {
			starArr[original/2][original/2] = "*";
			return;
		}
		
		//반복은 가로 세로 (n-1)*4 + 1만큼 행은 n-2씩 아래로
		int lastIdx = startIdx + (n-1)*4;
		for (int i=startIdx; i<lastIdx + 1; i++) {
			starArr[startIdx][i] = "*"; starArr[i][startIdx] = "*";
			starArr[lastIdx][i] = "*"; starArr[i][lastIdx]="*";
		}
		
		star(n-1, startIdx+2);
		
		
	}

}
