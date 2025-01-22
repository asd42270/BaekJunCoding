import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;




public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] number = br.readLine().split(" ");
		
		int[] lines = new int[N];
		
		for (int i = 0; i < number.length; i++) {
			int num = Integer.parseInt(number[i]);
			lines[i] = i+1;
		
			for(int j = i; j>i-num; j--) {
				int temp = lines[j];
				lines[j] = lines[j-1]; 
				lines[j-1] = temp;
			}
			
			
		}
		
		for (int i = 0; i < lines.length; i++) {
			System.out.print(lines[i] + " ");
		}
		System.out.println();
	}
}