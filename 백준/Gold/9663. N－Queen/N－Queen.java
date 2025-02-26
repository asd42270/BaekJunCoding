
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int N;
	static int cnt;
	static boolean[][] chess;
	static boolean[] colCheck;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		chess = new boolean[N][N];
		// 열을 탐색하지 않도록 boolean 배열에 넣는다.
		colCheck = new boolean[N + 1];

		// 내가 두려는 위치에 못 놔요: 퀸의 공격로에 있기 떄문이죠
		// 이거는 지금 체스판의 첫 번째 위치에 놓았을 떄의 경우의 수임.
		// 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.
		// 위에만 확인해보면 된다.
		// 한 행에 하나만 둘 수 있음. 한 행에 하나를 배치하면? -> 다음 행으로 넘어가 ->
		// 이 행,열에 두는게 맞는지(유효성 검사) -> 위쪽만 보면됨.(백트래킹)

		// 첫번째 행만 보면 되잖아

		for (int i = 0; i < N; i++) {
			chess[0][i] = true;
			colCheck[i] = true;
			queen(1, 1);
			chess[0][i] = false;
			colCheck[i] = false;

		}
		bw.write(sb.append(cnt).toString());
		bw.flush();
		bw.close();
	}

	static void queen(int x, int k) {

		if (k == N) {
			cnt++;
			return;
		}

		// 탐색하는 횟수를 줄이는 것이 중요하다.
		for (int i = 0; i < N; i++) {
			if (!chess[x][i] && isValid(x, i) && !colCheck[i]) {
				chess[x][i] = true;
				colCheck[i] = true;
				queen(x + 1, k + 1);
				chess[x][i] = false;
				colCheck[i] = false;
			}

		}
	}

	static boolean isValid(int x, int y) {
		// 지금 위치가 체스판에 배치할 수 있는 위치인가?
		// 바로 위행만 보면 안된다.
		int leftCrossY = y - 1;
		int rightCrossY = y + 1;
		for (int i = x - 1; i >= 0; i--) {

			if (leftCrossY >= 0) {
				if (chess[i][leftCrossY]) {
					return false;
				}
			}
			leftCrossY--;

			if (rightCrossY < N) {
				if (chess[i][rightCrossY]) {
					return false;
				}
			}
			rightCrossY++;
		}

		return true;
	}

}
