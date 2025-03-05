import java.util.Scanner;
public class Main {
	public static int num=0;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		long n = sc.nextLong();
		System.out.println(cal(n));
	}
	public static long cal(long n) {
		if(n==1) {
			if(num%2==1) return 1;
			return 0;
		}
		if(n==0) {
			num--;
			if(num>0&&num%2==1) return 0;
			return 1;
		}
		String str = Long.toBinaryString(n);
		long k=n>>str.length()-1;
		k=k<<str.length()-1;
		if(k==n) {
			k=k>>1;
		}
		num++;
		return cal(n-k);
	}
}