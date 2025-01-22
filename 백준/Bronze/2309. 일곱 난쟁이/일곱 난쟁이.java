import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;




public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dwarfs = new int[9];
		
		for (int i = 0; i < dwarfs.length; i++) {
			dwarfs[i] = Integer.parseInt(br.readLine());
		}
		
		int sum = Arrays.stream(dwarfs).sum();
		
		for (int i = 0; i < dwarfs.length-1; i++) {
			for (int j = i+1; j < dwarfs.length; j++) {
				if (sum - (dwarfs[i]+dwarfs[j]) == 100) {
					dwarfs[i] = 0;
					dwarfs[j] = 0;
					
					break;
				}
			}
			
			if(dwarfs[i]==0) {break;}
		}
		
		Arrays.sort(dwarfs);
		
		for (int i = 2; i < dwarfs.length; i++) {
			System.out.println(dwarfs[i]);
		}
	}
}