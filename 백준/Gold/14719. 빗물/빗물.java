import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[h][w];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<w; i++) {
			int square = Integer.parseInt(st.nextToken());
			for (int j=h-1; j>=h-square; j--) {
				map[j][i] = 1;
			}
		}
		
		int ans = 0;
		for (int i=0; i<h; i++) {
			boolean isBlock = false;
			int cnt = 0;
			for (int j=0; j<w; j++) {
				if(map[i][j]==1 && !isBlock) { //블록이 아직 시작 안 했거나 초기화됐다면
					isBlock = true;
				} else if (map[i][j] == 1 && isBlock) { // 다시 블락을 만났으면
					// 인접해서 바로라면? 같은 걸로 치자
					if (map[i][j-1] != 1) {
						ans+=cnt;
						cnt = 0;
						if (j < w-1 && map[i][j+1] != 0) {
							isBlock = false;
						}
					}
					
				} else if (map[i][j] == 0 && isBlock) {
					cnt++;
				}
			}
		}
		
		System.out.println(ans);
	}
}
