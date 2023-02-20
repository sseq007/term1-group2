package BAEKJOON;
import java.util.Scanner;

/*
 * 투에-모스 문자열
 */
public class BOJ18222 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long k = sc.nextLong();
		String x = "01";
		int count = 0;
		
		while(k > 2) {
			// pow 함수의 배신
			k = k - (long)pow(2, func(k));
			count++;
		}
		
		int result = x.charAt((int) (k - 1)) -'0';
		
		if(count % 2 == 1) result = Math.abs(result - 1);
		
		System.out.println(result);
	}
	
	public static long func(long k) {
		long i = 1;
		int count = 0;
		while(true) {
			i *= 2;
			if(i >= k) break;
			count++;
		}
		return count;
	}
	
	public static long pow(int a, long b) {
		long result = 1;
		for(int i = 0; i < b; i++) {
			result *= a;
		}
		return result;
	}
}
