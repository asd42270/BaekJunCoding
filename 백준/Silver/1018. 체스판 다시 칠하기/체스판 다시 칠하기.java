import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int getCurrent(int startRow, int startCol, String[] chess) {

        String[] board = {"WBWBWBWB", "BWBWBWBW"};
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int row = startRow + i;
            for (int j = 0; j < 8; j++) {
                int col = startCol + j;
                if (chess[row].charAt(col) != board[row % 2].charAt(j)) {
                    count++;
                }
            }
        }
        return Math.min(count, 64 - count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] chess = new String[n];
        for (int i = 0; i < n; i++) {
            chess[i] = br.readLine();
        }

        int min = Integer.MAX_VALUE;
        for (int row = 0; row <= n - 8; row++) {
            for (int col = 0; col <= m - 8; col++) {
                int current = getCurrent(row, col, chess);
                if (min > current) min = current;
            }
        }

        System.out.println(min);
    }


}