package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;

public class BOJ12933 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder input = new StringBuilder(br.readLine());

		int duckCount = 0;
		int minqIdx = 0;
		int minkIdx = 0;
		
		for (int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == 'q') {
				minqIdx = i;
				break;
			}
		}
		
		// 시작 단어가 q가 될 수 있도록
		input = new StringBuilder(input.toString().substring(minqIdx, input.length()));
		
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == 'k') {
				minkIdx = i;
				break;
			}
		}
		
		for(int i = minqIdx; i < minkIdx; i++) {
			if(input.charAt(i) == 'q') duckCount++;
		}
		
		int duckCountTmp = 0;
		while (true) {

			int qIdx = -1;
			int uIdx = -1;
			int aIdx = -1;
			int cIdx = -1;
			int kIdx = -1;
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
//				System.out.println(qIdx + " " + uIdx + " " + aIdx + " " + cIdx + " " +kIdx);
				duckCountTmp++;
				input.deleteCharAt(kIdx);
				input.deleteCharAt(cIdx);
				input.deleteCharAt(aIdx);
				input.deleteCharAt(uIdx);
				input.deleteCharAt(qIdx);

			} else break;
		}
		
		duckCount = Math.min(duckCount, duckCountTmp);
		if(duckCount == 0) System.out.println(-1);
		else System.out.println(duckCount);
//		System.out.println(Math.min(duckCount, duckCountTmp));
	}

}
