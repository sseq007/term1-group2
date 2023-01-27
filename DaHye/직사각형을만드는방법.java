import java.util.Scanner;

public class 직사각형을만드는방법 {

	public static void main(String[] args) {
		// n = 6일 때
		// 1x1 1x2 1x3 1x4 1x5 1x6
		//     2x2 2x3
		
		// n = 7일 때
		// 1x1 1x2 1x3 1x4 1x5 1x6 1x7
		//     2x2 2x3
		
		// n = 9일 때
		// 1x1 1x2 ...
		//     2x2 ...
		//     3x3
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		for(int i = 1; i < (int)Math.sqrt(n) + 1; i++) {
			for(int j = i; i * j <= n; j++) {
				count++;
			}
		}
		System.out.println(count);
	}
}
