import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int num = 0;

		char[][] arr = new char[T][T];
		for (int q = 0; q < getPowerofThree(T); q++) {
			for (int i = 0; i < T; i++) {
				for (int j = 0; j < T; j++) {
					if(arr[i][j]==' ') continue;
					if ((i /(int) Math.pow(3, q)) % 3 == 1 && (j / (int) Math.pow(3, q)) % 3 == 1) { // 3x3 중간 부분을 비움
	                    arr[i][j] = ' ';
					}
				}
			}
		}
		for (int i = 0; i < T; i++) {
			for (int j = 0; j < T; j++) {
				if(!(arr[i][j]==' ')) {
					arr[i][j]='*';
				}
				sb.append(arr[i][j]);
			}
			
			sb.append("\n");
		}
		System.out.print(sb);
	}

	public static int getPowerofThree(int T) {
		int power = 0;
		while (T > 1) {
			T /= 3;
			power++;
		}
		return power;
	}
}