import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		
		// 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자.
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i=1; i<=n; i++) {
			arr[i-1] = Integer.parseInt(br.readLine());
		}
		
		
		// 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다.
		// 스택에 오름차순으로 넣는다. 스택	
		Stack<Integer> stack = new Stack<Integer>();
		int[] result = new int[n];
		
		String answer = "YES";
		int num = 1;
		int idx = 0;
		while(num <= n) {
			
			if(num  <= arr[idx]) {
				stack.add(num);
				num++;
				sb.append("+").append("\n");
			} else  {
				int number = stack.pop();
				sb.append("-").append("\n");
				result[idx] = number;
				idx++;
			}					
		}
		
		while(!stack.isEmpty()) {
			int number = stack.pop();
			result[idx] = number;
			sb.append("-").append("\n");
			idx++;
		}
		
		for (int i=0; i<n; i++) {
			if (result[i]!= arr[i]) {
				answer = "NO";
				break;
			}
		}
		
		if (answer.equals("YES")) {
			bw.write(sb.toString());
			bw.flush();
			bw.close();				
			
		} else System.out.println("NO");
	}
}
