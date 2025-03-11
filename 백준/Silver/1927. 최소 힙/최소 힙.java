import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        
        for (int i=0; i<N; i++) {
        	int cmd = Integer.parseInt(br.readLine());
        	if (cmd== 0) {
        		if(heap.isEmpty()) sb.append(0).append("\n");
        		else sb.append(heap.poll()).append("\n");
        	} else {
        		heap.add(cmd);
        	}
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        
        
    }
}