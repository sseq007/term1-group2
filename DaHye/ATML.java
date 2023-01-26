import java.util.Arrays;
import java.util.Scanner;

public class ATML {
	// 정렬 후 차례로 더하기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Integer[] arr = new Integer[N];
		
		for(int i = 0; i < arr.length; i++) arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < i + 1; j++) {
				sum += arr[j];
			}
		}
		System.out.println(sum);
	}

}
