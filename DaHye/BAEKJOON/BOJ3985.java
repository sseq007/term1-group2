package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ3985 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();
		Boolean[] cake = new Boolean[L];
		Arrays.fill(cake, false);
		
		int N = sc.nextInt();
		int[] people = new int[N];
		
		// 예상 방청객 번호
		int idx1 = 0;
		int tmp1 = 0;
		
		// 실제 방청객
		int idx2 = 0;
		int tmp2 = Integer.MIN_VALUE;
		
		for(int i = 0; i < people.length; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			// 예상 방청객 
			// 부등호를 >=가 아닌, >로 하면 최대 길이인 사람이 많아도 
			// idx가 가장 작은 사람만 저장됨
			if((b - a + 1) > tmp1) {
				idx1 = i + 1;
				tmp1 = b - a + 1;
			}
			
			for(int j = a - 1; j < b; j++) {
				if(cake[j] == false) {
					cake[j] = true;
					people[i]++;
				}
			}
			
			// 실제로 많이 받은 사람
			if(tmp2 < people[i]) {
				tmp2 = people[i];
				idx2 = i + 1;
			}
		}
		
		System.out.println(idx1 + "\n" + idx2);
	}
}
