import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        
        // 빼기가 나오면 괄호를 친다 -> 다음 뺴기 나오기 전 or 끝까지 더함
        String[] arr = str.split("-");
        if(arr.length == 1) {
        	// 더하기만 있어요
        	String[] plus = str.replace("+", " ").split(" ");
        	int sum = 0;
        	for (int i=0; i<plus.length; i++) {
        		sum += Integer.parseInt(plus[i]);
        	}
        	
        	System.out.println(sum);
        } else {
        	int sum = 0;
        	for (int i=0; i<arr.length; i++) {
        		String[] plus = arr[i].replace("+", " ").split(" ");
        		int a = 0;
        		for (int j=0; j<plus.length; j++) {
        			a += Integer.parseInt(plus[j]);
        		}
        		if (i==0) sum+=a;
        		else sum-=a;       		
        	}       	
        	System.out.println(sum);
        }
        
    }
}