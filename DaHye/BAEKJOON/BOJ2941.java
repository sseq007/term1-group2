package BAEKJOON;

import java.util.Scanner;

public class BOJ2941 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] croAl = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
		String input = sc.next();

		int count = 0;

		// 먼저 크로아티아 알파벳의 개수를 셈
		for (int i = 0; i < croAl.length; i++) {
			while (input.contains(croAl[i])) {
				// 문자열을 replace되면서 원래 크로아티아 문자가 아니었던 것이 크로아티아 문자로 식별될 수 있기 떄문에
				// 중간에 "_"으로 바꿔줌
				// cc==a -> c=a
				input = input.replaceFirst(croAl[i], "_");
				count++;
			}
		}

		input = input.replace("_", "");
		count = count + input.length();
		System.out.println(count);
	}

}
