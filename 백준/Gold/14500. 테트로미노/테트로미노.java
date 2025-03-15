
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[][] square;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 

		square = new int[N][M];
		
		// i번째 줄의 j번째 수는 위에서부터 i번째 칸, 왼쪽에서부터 j번째 칸에 쓰여 있는 수이다.
		// 첫째 줄에 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값
		// 테트로미노 하나를 적절히 놓아서 테트로미노가 놓인 칸에 쓰여 있는 수들의 합을 최대
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j=0; j<M; j++) {
				square[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 완탐으로 ㄱㄱ -> 대칭이랑 회전 가능함 완탐 가능?
		// 1. 행에서 4개 추출한 누적합 -> 여기서 최대 이거는 n*n-4*2
		// 2. 2x2 배열 추출 -> 최대 -> n-2*n-2
		// 3. 3개2개 -> 최대 n-3*n-2 * 8 
		// 4. n-3*n-2 * 4
		// 5. 행 3개 가운데 1개 n-2*n-3 * 4
		int[] max = new int[5];
		Arrays.fill(max, 0);
		
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				//1번 (행 열 동시에)
				max[0] = Math.max(max[0], one(i, j));
				//2번
				max[1] = Math.max(max[1], two(i, j));
				//3번
				max[2] = Math.max(max[2], three(i, j));
				//4번
				max[3] = Math.max(max[3], four(i, j));
				//5번
				max[4] = Math.max(max[4], five(i, j));
			}
		}
		
		Arrays.sort(max);
		System.out.println(max[4]);
	}

	private static int one(int x, int y) {
		
		int colSum = 0; int rowSum = 0;
		
		for (int i=y; i<y+4; i++) {
			if (i >= M) {
				colSum = 0; 
				break; // 테트로미노 아님
			}
			colSum += square[x][i];
		}
		
		for (int i=x; i<x+4; i++) {
			if(i>=N) {
				rowSum = 0;
				break; // 테트로미노 아님
			}
			rowSum += square[i][y];
		}
		
		return Math.max(colSum, rowSum);
	}

	private static int two(int x, int y) {
		
		int sum = 0;
		
		for (int i=x; i<x+2; i++) {
			for (int j=y; j<y+2; j++) {
				if(i >= N || j >= M) {
					sum = 0; // 테트로미노 아님
					break;
				}
				sum += square[i][j];
			}
		}
		
		return sum;
	}

	private static int three(int x, int y) {
		
		int sumA = 0;
		for (int i=x; i<x+3; i++) {
			if(i >= N) {
				sumA = 0; 
				break; // 테트로미노 아님
			}
			sumA+=square[i][y];
		}
		
		int sum1 = 0; int sum2 = 0; 
		if (y+1 < M && x+2 < N && sumA!=0) {
			sum1 = Math.max(sumA+square[x][y+1], sumA + square[x+2][y+1]);
		}
		
		if (y-1 >= 0 && x+2 < N && sumA!=0) {
			sum2 = Math.max(sumA+square[x][y-1], sumA+square[x+2][y-1]);
		}
		
		int sum3=0; int sum4=0; int sumB = 0;
		for (int i=y; i<y+3; i++) {
			if (i >= M) {
				sumB = 0; 
				break; // 테트로미노 아님
			}
			sumB += square[x][i];
		}
		
		if(x-1>=0 && y+2 < M && sumB != 0) {
			sum3 = Math.max(sumB+square[x-1][y], sumB+square[x-1][y+2]);
		}
		
		if (x+1 < N && y+2 < M && sumB != 0) {
			sum4 = Math.max(sumB+square[x+1][y], sumB + square[x+1][y+2]);
		}
		
		
		return Math.max(Math.max(sum1, sum2), Math.max(sum3, sum4));
	}

	private static int four(int x, int y) {
		
		int sum = 0;
		for (int i=x; i<x+3; i++) {
			for (int j=y; j<y+2; j++) {
				if(i >= N || j >= M) {
					sum = 0; 
					break;
				}
				sum+=square[i][j];
			}
		}
		// [x][y+1] + [x+2][y] or [x][y] + [x+2][y+1]
		int sumA = 0;
		if (x+2 < N && y+1 < M && sum!=0) {
			sumA = Math.max(sum - (square[x][y+1] + square[x+2][y]), sum - (square[x][y] + square[x+2][y+1]));		
		}
		
		int sum1 = 0;
		for (int i=x; i<x+2; i++) {
			for (int j=y; j<y+3; j++) {
				if(i >= N || j >= M) {
					sum1 = 0; 
					break;
				}
				sum1+=square[i][j];
			}
		}
		
		// [x][y+2] + [x+1][y] or [x][y] + [x+1][y+2]
		int sumB = 0;
		if(x+1 < N && y+2 < M && sum1!=0) {
			sumB = Math.max(sum1 - (square[x][y+2] + square[x+1][y]), sum1 - square[x][y] - square[x+1][y+2]);
		}
		
		return Math.max(sumA, sumB);
	}

	private static int five(int x, int y) {

		int sum = 0;
		for (int i=y; i<y+3; i++) {
			if (i >= M) {
				sum = 0; 
				break; // 테트로미노 아님
			}
			sum += square[x][i];
		}
		
		int sum1 = 0;
		if (y+2 < M && x-1 >=0 && sum != 0) {
			sum1 = sum + square[x-1][y+1]; 
		}
		
		int sum2 = 0;
		if (y+2 < M && x+1 < N && sum != 0) {
			sum2 = sum + square[x+1][y+1]; 
		}
		
		int sumA = 0;
		for (int i=x; i<x+3; i++) {
			if (i >= N) {
				sumA = 0; 
				break; // 테트로미노 아님
			}
			sumA += square[i][y];
		}
		
		int sum3 = 0;
		if (x+2 < N && y-1 >=0 && sumA != 0) {
			sum3 = sumA + square[x+1][y-1];
		}
		int sum4 = 0;
		if (x+2 < N && y+1 < M && sumA != 0) {
			sum4 = sumA + square[x+1][y+1];
		}
		
		return Math.max(Math.max(sum1, sum2), Math.max(sum3, sum4));
	}
}
