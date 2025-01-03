import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[][] students = new int [N][2];
		
		for (int i=0; i<N; i++) {
			int S = sc.nextInt();
			int Y = sc.nextInt();
				
			students[i][0] = S;
			students[i][1] = Y;
		}
		
		Arrays.sort(students, (a,b) -> {
			if(a[0]==b[0]) {
				return Integer.compare(a[1], b[1]);
			}
			return Integer.compare(a[0], b[0]);
		});
		
		System.out.println(assignRoom(K, students));
			
	}
	
	public static int assignRoom(int K, int[][] students) {
		int count = 0;
		int studentCount = 1;
		for (int i=0; i<students.length-1; i++) {
			
			if (students[i][0] == students[i+1][0] && students[i][1] == students[i+1][1]) {
				studentCount++;
			} else {
				count += (studentCount / K);
				if (studentCount % K != 0) count++; // 나머지가 있으면 방 하나 추가
				studentCount = 1;
			}
		}
		// 마지막 그룹 처리
		count += (studentCount / K);
		if (studentCount % K != 0) count++;
		
		return count;
	}
		
}
