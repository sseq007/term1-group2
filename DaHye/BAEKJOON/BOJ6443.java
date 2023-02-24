package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BOJ6443 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N;
	static char[] str;
	static char[] sel;
	static boolean[] v;
	static List<String> list;	// add한 대로 저장
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		
		for (int test_case = 0; test_case < N; test_case++) {

			String input = br.readLine();
			str = input.toCharArray();
			sel = new char[str.length];
			v = new boolean[str.length];
			list = new ArrayList<>();
			Arrays.sort(str);
			
			func(0);
			
			Collections.sort(list);
			for(int i = 0; i < list.size(); i++) {
				sb.append(list.get(i) + "\n");
			}
		}
		

		System.out.println(sb);
	}
		
	private static void func(int k) {
		if(k == str.length) {
			String tmp = "";
			for (int i = 0; i < sel.length; i++) {
				tmp += sel[i];
			}
			
			if(!list.contains(tmp)) {
				list.add(tmp);
			}
			return;
		}
		
		for(int i = 0; i < str.length; i++) {
			for(int j = 0; j < k; j++) {
				if(sel[j] == str[i]) break;
			}
			if(v[i]) continue;
			v[i] = true;
			sel[k] = str[i];
			func(k + 1);
			v[i] = false;
		}
	}
	
}