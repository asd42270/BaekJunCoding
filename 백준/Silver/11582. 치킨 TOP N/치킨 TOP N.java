import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int len;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        K = Integer.parseInt(br.readLine());
        len = N;

        chickenSort(arr, N / 2);

        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void chickenSort(int[] chicken, int N) {
        if (N < K) {
            return;
        }

        for (int idx = 0; idx < N; idx++) {
            int startIdx = len / N * idx;
            int endIdx = Math.min(startIdx + (len / N), len); // 배열 크기 초과 방지
            
            Arrays.sort(chicken, startIdx, endIdx); // 더 효율적인 정렬 사용
        }

        chickenSort(chicken, N / 2);
    }
}
