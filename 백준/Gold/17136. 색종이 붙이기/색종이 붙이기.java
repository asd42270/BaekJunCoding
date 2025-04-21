import java.io.*;
import java.util.*;

public class Main {

	static int[][] paper;
	static int[] count;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		paper = new int[10][10];

		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 10; j++) {
				int value = Integer.parseInt(st.nextToken());
				paper[i][j] = value;
			}
		}

		count = new int[6];
		for (int i = 1; i <= 5; i++) {
			count[i] = 5;
		}

		cover(0, 0, 0);
		
		if (min == Integer.MAX_VALUE) min = -1;
		System.out.println(min);
	}

	private static void cover(int x, int y, int cnt) {

		// 1. 색종이가 다 덮힌 경우
		if(x==10) {
			min = Math.min(min, cnt);
			return;
		}
		
		
		if (y== 10) {
			cover(x+1, 0, cnt);
			return;
		}

		// 하나는 되니까 다음 재귀
		if (paper[x][y] == 1) {

			// 1*1은 가능하니까 바로 다음 재귀로
			if(count[1] > 0) {
				count[1]--;
				paper[x][y] = 6;
				cover(x, y + 1, cnt + 1);
				count[1]++;
				paper[x][y] = 1;
			}

			// 다음 재귀 2*2 가능하면 2*2
			if (count[2] > 0 && isValid(x, y, 2)) {
				for (int r = x; r <= x + 1; r++) {
					for (int c = y; c <= y + 1; c++) {
						paper[r][c] = 2;
					}
				}

				count[2]--;
				cover(x, y + 1, cnt + 1);
				count[2]++;

				for (int r = x; r <= x + 1; r++) {
					for (int c = y; c <= y + 1; c++) {
						paper[r][c] = 1;
					}
				}

			}

			if (count[3] > 0 && isValid(x, y, 3)) {
				for (int r = x; r <= x + 2; r++) {
					for (int c = y; c <= y + 2; c++) {
						paper[r][c] = 3;
					}
				}

				count[3]--;
				cover(x, y + 1, cnt + 1);
				count[3]++;

				for (int r = x; r <= x + 2; r++) {
					for (int c = y; c <= y + 2; c++) {
						paper[r][c] = 1;
					}
				}
			}

			if (count[4] > 0 && isValid(x, y, 4)) {
				for (int r = x; r <= x + 3; r++) {
					for (int c = y; c <= y + 3; c++) {
						paper[r][c] = 4;
					}
				}

				count[4]--;
				cover(x, y + 1, cnt + 1);
				count[4]++;

				for (int r = x; r <= x + 3; r++) {
					for (int c = y; c <= y + 3; c++) {
						paper[r][c] = 1;
					}
				}
			}

			if (count[5] > 0 && isValid(x, y, 5)) {
				for (int r = x; r <= x + 4; r++) {
					for (int c = y; c <= y + 4; c++) {
						paper[r][c] = 5;
					}
				}

				count[5]--;
				cover(x, y + 1, cnt + 1);
				count[5]++;

				for (int r = x; r <= x + 4; r++) {
					for (int c = y; c <= y + 4; c++) {
						paper[r][c] = 1;
					}
				}
			}
		}  else {
            cover(x, y + 1, cnt);
        }

	}

	private static boolean isValid(int i, int j, int cnt) {

		int idx = cnt - 1;
		if (i + idx >= 10 || j + idx >= 10) {
			return false;
		}

		for (int x = i; x <= i + idx; x++) {
			for (int y = j; y <= j + idx; y++) {
				if (paper[x][y] != 1) {
					return false;
				}
			}
		}

		return true;
	}
}
