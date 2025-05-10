import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str= br.readLine();
    
        Stack<Character> stack = new Stack<Character>();
        
        int cnt = 0;
        for (int i=0; i<str.length(); i++) {
        	char ch = str.charAt(i);
        	
        	if (ch=='(') {
        		stack.add(ch);
        	} else {
        		stack.pop();
        		if (i-1 >= 0 && str.charAt(i-1) == '(') {
        			cnt += stack.size();
        		} else {
        			cnt++;
        		}
        	}
        }
        
        System.out.println(cnt);
        
    }
    
}
