import java.io.*;
import java.util.*;

public class Main {

	static boolean[] visited;
	static int cnt;
	static int N;
	static int[][] inning;
	static int maxScore = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		inning = new int[N + 1][10];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= 9; j++) {
				inning[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 1-안타 2-2루타 3-3루타 4-홈런 0-아웃
		// 1번 선수는 4번타자
		// 선수들의 타순을 정해야 하는 문제
		// 야구 룰대로 -> 3아웃된 타자 다음 타자부터 시작
		// 안타: 타자와 모든 주자가 한 루씩 진루한다.
		// 2루타: 타자와 모든 주자가 두 루씩 진루한다.
		// 3루타: 타자와 모든 주자가 세 루씩 진루한다.
		// 홈런: 타자와 모든 주자가 홈까지 진루한다.

		// 첫 번째 타순만 정하면 나머지는 그대로

		// 타순을 지정해야 됨.
		int[] lineup = new int[10];
		lineup[4] = 1;
		visited = new boolean[10];
		visited[1] = true;
		permutaion(lineup, 1);
		System.out.println(maxScore);

	}

	static void permutaion(int[] lineup, int idx) {
		if (idx >= 9) {
			// 타격 로직을 실행
			int ans = 45;
			for (int i = 1; i <= 8; i++) {
				ans -= lineup[i];
			}
			lineup[9] = ans;

			int score = baseball(lineup);
			maxScore = Math.max(maxScore, score);
		}

		for (int i = 2; i <= 9; i++) { // i 는 선수
			if (!visited[i]) {
				visited[i] = true;
				if (idx != 4) {
					lineup[idx] = i;
				}
				permutaion(lineup, idx + 1);
				visited[i] = false;
			}
		}

	}

	private static int baseball(int[] lineup) {
		// 이닝은 n번이다.
		int score = 0;
		int start = 1; // 타자
		for (int i = 1; i <= N; i++) {
			int out = 0;
			int one = 0;
			int two = 0;
			int three = 0;
			while (out < 3) {
				if (inning[i][lineup[start]] == 1) {
					// 친 사람은 무조건 1루로(무조건 1루에 한명)
					if (three > 0) {
						three--;
						score++;
					}

					if (two > 0) {
						two--;
						three++;
					}

					if (one > 0) {
						one--;
						two++;
					}

					one++;

				} else if (inning[i][lineup[start]] == 2) {
					// 친 사람은 무조건 2루로(무조건 2루에 한명)
					if (three > 0) {
						three--;
						score++;
					}

					if (two > 0) {
						two--;
						score++;
					}

					if (one > 0) {
						one--;
						three++;
					}

					two++;

				} else if (inning[i][lineup[start]] == 3) {
					// 친 사람은 무조건 3루로(무조건 3루에 한명)
					if (three > 0) {
						three--;
						score++;
					}

					if (two > 0) {
						two--;
						score++;
					}

					if (one > 0) {
						one--;
						score++;
					}

					three++;
				} else if (inning[i][lineup[start]] == 4) {
					// 루에 있는 사람들 다 점수
					if (one > 0) {
						one--;
						score++;
					}

					if (two > 0) {
						two--;
						score++;
					}

					if (three > 0) {
						three--;
						score++;
					}

					score++;
				} else {
					out++;
				}
				
				start++;
				if (start > 9) {
					start = 1;
				}
			}
		}

		return score;

	}

}
