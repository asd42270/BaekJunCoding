import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


//11560 11651 1181 02.12에 다시 풀어보기
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[][] arr = new String[N][3];


        for (int i = 0; i < N; i++) {
            String[] ageName = br.readLine().split(" ");
            arr[i][0] = ageName[0];
            arr[i][1] = ageName[1];
            arr[i][2] = String.valueOf(i);

        }

        Arrays.sort(arr, ((o1, o2) -> {
            int num = Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]));

            if (num != 0) {
                return num;
            } else {
                return Integer.compare(Integer.parseInt(o1[2]), Integer.parseInt(o2[2]));
            }
        }));

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }

}