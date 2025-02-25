
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	// 결과를 담을 배열
	static List<String> arr = new ArrayList<String>();
	static int N;
	static int M;
	static boolean[] check;
	static int[] selected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// N까지의 자연수에서 길이가 M인 수열 -> 수가 열거된 거 규칙 필요 X
		// 무조건 M개를 고른다
		// M개를 고른다 -> 이게 이미 골라졌는지? 
		// M번 재귀를 돌린다 -> 얼마나 돌리냐 M개 고를 때까지
		// 종료 조건은 뭐냐 -> M번 돌리면서 
		check = new boolean[N+1];
		selected = new int[M];
		recursive(0);
		
		for(String str : arr) {
			sb.append(str).append("\n");
		}
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void recursive(int cnt) {
		if (cnt==M) {
			//종료조건 -> 이떄까지의 수열이 존재하지 않으면 결과 담을 배열에 넣는다.
			StringBuilder sb = new StringBuilder();
			for (int i=0; i<M; i++) {
				sb.append(selected[i]).append(" ");
			}
			arr.add(sb.toString());
			return;
		}

		for(int i=1; i<=N; i++) {
			//선택해서 배열에 넣는다. 이미 선택된 곳이라면 넣을 수 없음
			if (check[i]) continue; //같은 수는 넣을 수 없으니 다음 숫자로
			else {
				check[i] = true;
				selected[cnt] = i;
				recursive(cnt+1);
				check[i] = false; // 재귀에서 돌아오면 그 숫자는 다시 사용 가능
			}
		}	
	}

}
