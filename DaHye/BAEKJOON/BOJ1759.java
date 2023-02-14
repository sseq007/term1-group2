package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*
 * 암호 만들기 
 * 암호 구성: 서로 다른 L개의 알파벳 + 최소 한개의 모음 + 최소 두개 의 자음 + 정렬 
 * 입력 
 * - L: 암호의 길이 
 * - C: 서로 다른 알파벳의 개수
 */
public class BOJ1759 {

	static int L;
	static int C;
	static boolean[] v;
	static char[] arr;
	static char[] sel;
	static Character[] ch;
	static StringBuilder sb;
	static HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
	static TreeSet<String> stringSet;
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		v = new boolean[C];
		arr = new char[L];
		sel = new char[L];
		stringSet = new TreeSet<>();
		ch = new Character[C];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < ch.length; i++) {
			ch[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(ch);
		func(0, 0);
		
//		System.out.println(stringSet);
		while(!stringSet.isEmpty()) {
			sb.append(stringSet.pollFirst() + "\n");
		}
		System.out.println(sb);
	}

	static public void func(int k, int idx) {
		if (k == L) {
			boolean flag = true;
			int countVo = 0; // 모음 count
			int countCo = 0; // 자음 count
			for (int i = 0; i < sel.length - 1; i++) {
				if (!(sel[i] < sel[i + 1])) {
					flag = false;
					break;
				}
			}
			for (int i = 0; i < sel.length; i++) {
				if (set.contains(sel[i])) countVo++;
				else countCo++;
			}
			
			// 확실한게 아니라면 내 맘대로 조건 바꾸지 말기
//			if (flag == true && countVo >= 1 && sel.length > 2) {
			if (flag == true && countVo >= 1 && countCo >= 2) {
				String tmp = String.valueOf(sel);
				stringSet.add(tmp);
			}
			return;
		}
		
		// 6개 중에 중복되지 않고 순서대로 나열될 수 있도록
		if (idx == ch.length) return;

		sel[k] = ch[idx];
		func(k + 1, idx + 1);
		func(k, idx + 1);
	}
}
