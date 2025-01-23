import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nb = br.readLine().split(" ");
        int n = Integer.parseInt(nb[0]);
        int b = Integer.parseInt(nb[1]);

        StringBuilder answer = new StringBuilder();

        // A= 65이니까 -55 해야됨.
        // 0=48, 9=57 이니까 0 ~ 9까지는 -48해야됨.
        int share = n;
        int remain = 0;

        while (share>0) {
            share = n/b;
            remain = n%b;
            if(remain <=9) {
                answer.append(((char) (remain + 48)));
            } else{
                answer.append(((char)(remain + 55)));}

            n = share;
        }


        bw.write(answer.reverse()+"\n");
        bw.flush();
        bw.close();
    }
}