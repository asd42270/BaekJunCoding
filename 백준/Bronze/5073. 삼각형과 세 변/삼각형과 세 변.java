import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String[] nums = br.readLine().split(" ");

            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);
            int c = Integer.parseInt(nums[2]);

            if (a==0 && b==0 && c==0) {
                break;
            }

            if (a == b && b == c) {
                bw.write("Equilateral\n");
            } else if (a != b && b != c && a != c) {
                int max = Math.max(a,Math.max(b, c));
                if(a+b+c - max > max) {
                    bw.write("Scalene\n");
                } else{bw.write("Invalid\n");}
            } else {
                int max = Math.max(a,Math.max(b, c));
                if(a+b+c - max > max) {
                    bw.write("Isosceles\n");
                } else{bw.write("Invalid\n");}
            }
        }

        bw.flush();
        bw.close();
    }
}

