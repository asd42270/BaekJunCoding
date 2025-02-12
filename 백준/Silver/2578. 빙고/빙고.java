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

		int[][] bingo = new int[5][5];
		boolean[][] check = new boolean[5][5];

		String[] index = new String[26];

		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				int value = Integer.parseInt(st.nextToken());
				bingo[i][j] = value;
				index[value] = i + " " + j;
			}
		}
		
		cnt = 0;
		int bingoCnt = 0;
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < 5; j++) {
				int num = Integer.parseInt(st.nextToken());
				String[] idx = index[num].split(" ");
				int row = Integer.parseInt(idx[0]);
				int col = Integer.parseInt(idx[1]);
				check[row][col] = true;
				cnt++;
				
				
							
				if(isRowBingo(check, row)) {
					bingoCnt++;
				}
				
				if (isColBingo(check, col)) {
					bingoCnt++;
				}
				
				if (isLeftCrossBingo(check) && row==col) {
					bingoCnt++;
				}
				
				if(isRightCrossBingo(check) && row+col==4) {
					bingoCnt++;
				}
				
				if(bingoCnt>=3) {
					sb.append(cnt).append("\n");
					bingoCnt = Integer.MIN_VALUE;
					break ;
				}	
 			}
			
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		

	}
	
	private static boolean isRowBingo(boolean[][] check, int row) {
		//가로
		for(int i=0; i<5; i++) {
			if(!(check[row][i])) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean isColBingo(boolean[][] check, int col) {
		//세로
		for(int i=0; i<5; i++) {
			if(!(check[i][col])) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean isLeftCrossBingo(boolean[][] check) {
		for (int i=0; i<5; i++) {
			if(!(check[i][i])) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean isRightCrossBingo(boolean[][] check) {
		for (int i=0; i<5; i++) {
			if(!(check[i][4-i])) {
				return false;
			}
		}
		
		return true;
	}


}
