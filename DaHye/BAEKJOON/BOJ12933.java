package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;

public class BOJ12933 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder input = new StringBuilder(br.readLine());
		
		int duckminCount = 0;
		int duckCount = 0;
		int minqIdx = 0;
		int minkIdx = 0;
		
		while (true) {
			// 최소 오리 개수를 세기 위한 코드
			// input: quackqquuaacckk일 경우 생각해보기
			int duckmintmpCount = 0;
			for (int i = 0; i < input.length(); i++) {
				if(input.charAt(i) == 'q') {
					minqIdx = i;
					break;
				}
			}

			for(int i = minqIdx; i < input.indexOf("k"); i++) {
				if(input.charAt(i) == 'q') duckmintmpCount++;
			}
			
			duckminCount = Math.max(duckmintmpCount, duckminCount);
			
			int qIdx = -1;
			int uIdx = -1;
			int aIdx = -1;
			int cIdx = -1;
			int kIdx = -1;
			boolean flag = false;
			for (int i = 0; i < input.length(); i++) {
				if (input.toString().charAt(i) == 'q') {
					qIdx = i;
					break;
				}
			}
			for (int i = qIdx + 1; i < input.length(); i++) {
				if (input.toString().charAt(i) == 'u') {
					uIdx = i;
					break;
				}
			}
			for (int i = uIdx + 1; i < input.length(); i++) {
				if (input.toString().charAt(i) == 'a') {
					aIdx = i;
					break;
				}
			}
			for (int i = aIdx + 1; i < input.length(); i++) {
				if(input.toString().charAt(i) == 'c') {
					cIdx = i;
					break;
				}
			}
			for(int i = cIdx + 1; i < input.length(); i++) {
				if(input.toString().charAt(i) == 'k') {
					kIdx = i;
					break;
				}
			}
			
			if(qIdx != -1 && uIdx != -1 && aIdx != -1 && cIdx != -1 && kIdx != -1) {
				input.deleteCharAt(kIdx);
				input.deleteCharAt(cIdx);
				input.deleteCharAt(aIdx);
				input.deleteCharAt(uIdx);
				input.deleteCharAt(qIdx);
			} else break;
		}
		
		// duckminCount == 0: 엔터만 누른 경우
		if(input.toString().equals("") && duckminCount != 0) {
			System.out.println(duckminCount);
		} else {
			System.out.println(-1);
		}
	}

}
