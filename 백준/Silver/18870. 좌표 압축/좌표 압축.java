import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


//11560 11651 1181 02.12에 다시 풀어보기
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[][] numberIndex = new int[N][2];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i=0; i<N; i++) {
            numberIndex[i][0] = Integer.parseInt(st.nextToken());
            numberIndex[i][1] = i;
        }

        //숫자를 기준으로 정렬
        Arrays.sort(numberIndex, ((o1, o2) -> Integer.compare(o1[0], o2[0])));

        //개수를 담을 배열을 생성
        int[][] numberCount = new int[N][2];
        int count = 0;
        for(int i=0; i<N-1; i++) {
            if (numberIndex[i][0] != numberIndex[i+1][0]) {
                numberCount[i][0] = numberIndex[i][0];
                numberCount[i][1] = count;
                count++;
            } else {
                numberCount[i][0] = numberIndex[i][0];
                numberCount[i][1] = count;
            }
        }

        //마지막 값까지
        numberCount[N-1][0] = numberIndex[N-1][0];
        numberCount[N-1][1] = count;

        //배열을 순회하며 값을 교체한다.
        int[] answer = new int[N];
        for(int i=0; i<N; i++) {
            answer[numberIndex[i][1]] = numberCount[i][1];
        }

        for (int i : answer) {
            sb.append(i).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}