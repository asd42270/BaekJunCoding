import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int minX = 10001; int minY = 10001;
        int maxX = -10001; int maxY = -10001;
        for (int i = 0; i < n; i++) {

            String[] nums = br.readLine().split(" ");

            minX = Math.min(minX, Integer.parseInt(nums[0]));
            minY = Math.min(minY, Integer.parseInt(nums[1]));
            maxX = Math.max(maxX, Integer.parseInt(nums[0]));
            maxY = Math.max(maxY, Integer.parseInt(nums[1]));
        }

        int width = (maxX-minX) * (maxY-minY);
        System.out.println(width);

    }
}