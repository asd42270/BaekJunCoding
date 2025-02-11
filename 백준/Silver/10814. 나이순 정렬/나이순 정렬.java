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

        String[][] memberInfo = new String[N][2];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            memberInfo[i][0] = st.nextToken();
            memberInfo[i][1] = st.nextToken();
        }

        //숫자를 기준으로 정렬
        Arrays.sort(memberInfo, ((o1, o2) -> Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]    ))));

        for (String[] i : memberInfo) {
            sb.append(i[0]).append(" ").append(i[1]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}
