import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str= br.readLine();
    
        int idx = 0;
        
        List<Character> list = new ArrayList<Character>();
        Stack<Character> stack = new Stack<Character>();
        while(true) {

        	if(idx == str.length()) break;
        	
        	char ch = str.charAt(idx);
        	
        	if (ch=='<') {
        		
        		if (!stack.isEmpty()) {
        			while(!stack.isEmpty()) {
        				list.add(stack.pop());
        			}
        		}
        		
        		list.add(ch);
        		idx++;
        		while(true) {
        			char subCh = str.charAt(idx);
        			if (subCh == '>') {
        				list.add(subCh); // 우선 idx 증가하지 않고 나옴
        				break;
        			}
        			
        			list.add(subCh);
        			idx++;
        		}

        	} else if (ch==' ') {
        		if (!stack.isEmpty()) {
        			while(!stack.isEmpty()) {
        				list.add(stack.pop());
        			}
        		}
        		list.add(' ');
        	} else {
        		stack.add(ch);
        	}
        	
        	idx++;
        }
        
        if(!stack.isEmpty()) {
			while(!stack.isEmpty()) {
				list.add(stack.pop());
			}
        }
        
        for(Character ch : list) {
        	System.out.print(ch);
        }
        
    }
    
}
