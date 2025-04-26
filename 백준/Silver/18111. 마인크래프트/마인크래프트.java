import java.io.*;
import java.util.StringTokenizer;

class Main {

    static int[][] map;
    static int N, M, B;

    public static void main(String[] args) throws Exception, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        int minHeight = 256;
        int maxHeight = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                minHeight = Math.min(minHeight, value);
                maxHeight = Math.max(maxHeight, value);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int resultHeight = -1;
        for (int targetHeight = minHeight; targetHeight <= maxHeight; targetHeight++) {
            int time = 0;
            int inventory = B;

            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    int diff = map[x][y] - targetHeight;
                    if (diff > 0) { // 블록 제거
                        inventory += diff;
                        time += (diff*2);
                    } else if (diff < 0) { // 블록 추가
                        inventory -= (-diff); // 수정된 부분
                        time += (-diff);
                    }
                }
            }

            if (inventory < 0) continue;

            if (time < minTime || (time == minTime && resultHeight < targetHeight)) {
                minTime = time;
                resultHeight = targetHeight;
            }
        }

        System.out.println(minTime + " " + resultHeight);

    }
}