import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        if( a+b+c != 180) {
            System.out.println("Error");
        } else {
            if (a==b && b==c) {
                System.out.println("Equilateral");
            } else if (a!=b && b!=c && a!=c) {
                System.out.println("Scalene");
            } else{
                System.out.println("Isosceles");
            }
        }
    }
}