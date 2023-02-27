package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2529 {
	/*
	 * 부등호 문자열 A: '<'와 '>'가 k개 나열 부등호 앞뒤에 넣을 수 있는 숫자: 0~9까지 순열 입력 
	 * - k: 부등호의 개수 
	 * - k개의 부등호 기호 출력 
	 * - k+1자리의 최대, 최소 정수
	 */
	static int[] arr; // 숫자 나열의 모든 경우의 수
	static boolean[] v; // 방문 배열
	static int K;
	static StringBuilder sb;
	static ArrayList<String> strList;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		K = Integer.parseInt(br.readLine());
		arr = new int[K + 1];
		v = new boolean[10];
		strList = new ArrayList<>();
		char[] inputArr = new char[K];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < K; i++)
			inputArr[i] = st.nextToken().charAt(0);

		func(0, inputArr);
		
		System.out.println(strList.get(strList.size() - 1));
		System.out.println(strList.get(0));
	}

	public static void func(int k, char[] inputArr) {
		if (k == arr.length) {
			boolean flag = true;
			for (int i = 0; i < arr.length - 1; i++) {
				if (compare(arr[i], arr[i + 1], inputArr[i]) == false) {
					flag = false;
					break;
				}
			}
			if (flag == true) {
				sb.setLength(0); // sb 초기화
				for (int i = 0; i < arr.length; i++) {
					sb.append(arr[i]);
				}
				// strList에 부등호 조건에 맞는 배열을 sb.toString()으로
				// 문자열로 바꿔서 add해줌
				strList.add(sb.toString());
			}
			return;
		}

		for (int i = 0; i < 10; i++) {
			if (!v[i]) {
				v[i] = true;
				arr[k] = i;
				func(k + 1, inputArr);
				v[i] = false;
			}
		}
	}

	public static boolean compare(int a, int b, char c) {
		if (c == '<') {
			if (a < b)
				return true;
			else
				return false;
		} else {
			if (a > b)
				return true;
			else
				return false;
		}
	}
}
