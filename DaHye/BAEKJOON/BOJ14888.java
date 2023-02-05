package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14888 {
	/*
	 연산자 끼워넣기
	 */
	static int N;
	static int M;
	static int[] arr;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static boolean[] isused;
	static ArrayList<Character> oper;
	static char[] operArr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
//		nums = new int[N];
		// 연산자를 담을 배열
		// N(숫자의 개수) - 1개 만큼 필요
		oper = new ArrayList<>();
		operArr = new char[N - 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 4; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			for (int j = 0; j < tmp; j++) {
				if (i == 0)
					oper.add('+');
				else if (i == 1)
					oper.add('-');
				else if (i == 2)
					oper.add('×');
				else if (i == 3)
					oper.add('÷');
			}
		}
		isused = new boolean[oper.size()];
//		System.out.println(oper);
		func(0);
		System.out.println(max + "\n" + min);
	}

//	연산자들을 배열하기 위한 함수
	public static void func(int k) {
		
		if (k == N - 1) {
			int[] copyArr = new int[N];
			for(int i = 0; i < N; i++) {
				copyArr[i] = arr[i];
			}
			int tmp = 0;
			for (int i = 0; i < N - 1; i++) {
				copyArr[i + 1] = operate(copyArr[i], copyArr[i + 1], operArr[i]);
				tmp = copyArr[i + 1];
			}
			max = Math.max(tmp, max);
			min = Math.min(tmp, min);
			return;
		}

		for (int i = 0; i < oper.size(); i++) {
			if (!isused[i]) {
				operArr[k] = oper.get(i);
				isused[i] = true;
				func(k + 1);
				isused[i] = false;
			}
		}
	}

	public static int operate(int a, int b, char c) {
		int result = 0;
		switch (c) {
		case '+':
			result = a + b;
			break;
		case '-':
			result = a - b;
			break;
		case '×':
			result = a * b;
			break;
		case '÷':
			result = a / b;
			break;
		}
		return result;
	}
}
