import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dwarfs = new int[9];
        for (int i = 0; i < 9; i++) {
            dwarfs[i] = sc.nextInt();
        }

        int sum = Arrays.stream(dwarfs).sum();
        Arrays.sort(dwarfs);

        // 두 명의 난쟁이를 찾음
        outerLoop:
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - dwarfs[i] - dwarfs[j] == 100) {
                    for (int k = 0; k < 9; k++) {
                        if (k != i && k != j) { // 제외된 두 명을 건너뜀
                            System.out.println(dwarfs[k]);
                        }
                    }
                    break outerLoop; // 정답을 찾으면 종료
                }
            }
        }
    }
}
