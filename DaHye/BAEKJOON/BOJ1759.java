package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ1759 {
	/* 
	 * 암호 만들기
	 * 암호 구성: 서로 다른 L개의 알파벳 + 최소 한개의 모음 + 최소 두개 의 자음 + 정렬
	 * 입력
	 * - L: 암호의 길이
	 * - C: 서로 다른 알파벳의 개수
	 */
	static int L;
	static int C;
	static boolean[] v;
	static char[] arr;
	static char[] sel;
	static StringBuilder sb;
	static HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
	static TreeSet<String> stringSet;
	
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
		Character[] ch = new Character[C];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < ch.length; i++) {
			ch[i] = st.nextToken().charAt(0);
		}
		
		func(0, ch);
		
		while(!stringSet.isEmpty()) {
			sb.append(stringSet.pollFirst() + "\n");
		}
		System.out.println(sb);
	}
	static public void func(int k, Character[] ch) {
		if(k == L) {
			boolean flag = true;
			int count = 0;
			for(int i = 0; i < sel.length - 1; i++) {
				if(!(sel[i] < sel[i + 1])) {
					flag = false;
					break;
				}
			}
			for(int i = 0; i < sel.length; i++) {
				if(set.contains(sel[i])) count++;
			}
			
			sb.setLength(0);
			
			if(flag == true && count >= 1 && sel.length > 2) {
				for(int i = 0; i < sel.length; i++) sb.append(sel[i]);
				stringSet.add(sb.toString());
//				System.out.println(sb.toString());
			}
//			stringSet.add(sb.toString());
			return;
		}
		
		for(int i = 0; i < C; i++) {
			if(!v[i]) {
				v[i] = true;
				sel[k] = ch[i];
				func(k + 1, ch);
				v[i] = false;
			}
		}
	}
}
