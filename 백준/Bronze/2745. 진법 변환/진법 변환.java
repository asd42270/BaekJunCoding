import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nb = br.readLine().split(" ");
        String n = nb[0];
        int b = Integer.parseInt(nb[1]);

        int answer = 0;

        // A= 65이니까 -55 해야됨.
        // 0=48, 9=57 이니까 0 ~ 9까지는 -48해야됨.
        int cnt = 0;
        for (int i=n.length()-1; i>=0; i--) {
            if(n.charAt(i) < 65) {
                answer += ((int)Math.pow(b, cnt) * (n.charAt(i)-48));
                cnt++;
            } else {
                answer += ((int)Math.pow(b, cnt) * (n.charAt(i)-55));
                cnt++;
            }
        }

        System.out.println(answer);
    }
}
