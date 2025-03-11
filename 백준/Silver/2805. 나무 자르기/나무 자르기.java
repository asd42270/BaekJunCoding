import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] tree = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(tree);

		int result = 1;
		int left = 0, right = tree[N - 1]; // 최대 나무 높이를 right로 설정

		while (left <= right) { // ✅ 종료 조건 수정
			int mid = (left + right) / 2;
			long diff = 0; // ✅ diff가 int 범위를 초과할 가능성이 있으므로 long으로 변경

			for (int i = 0; i < N; i++) {
				if (tree[i] > mid) { // ✅ 불필요한 연산 제거
					diff += tree[i] - mid;
				}
			}

			if (diff < M) { 
				right = mid - 1; // ✅ 높이를 낮춰서 더 많은 나무를 얻도록 조정
			} else {
				result = mid;  // ✅ 최적의 높이를 저장
				left = mid + 1; // ✅ 높이를 높여서 최적의 값을 찾기
			}
		}

		System.out.println(result);
	}
}
