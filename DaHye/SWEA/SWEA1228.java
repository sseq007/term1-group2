package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA1228 {
	/*
	 * 암호문 | x, y, s: 앞에서부터 x의 위치 바로 다음에 y개의 숫자를 삽입 (s: 덧붙일 숫자들) 입력 - N: 원본 암호문의 길이
	 * - ori: 원본 암호문 - M: 명령어의 개수 - 명령어
	 */
	static LinkedList<Integer> sub;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		StringTokenizer st;
		
		for(int test_case = 1; test_case < 11; test_case++) {
			int N = Integer.parseInt(br.readLine());
			LinkedList<Integer> ori = new LinkedList<>();

			st = new StringTokenizer(br.readLine());
			sb = new StringBuilder();
			
			for(int i = 0; i < N; i++) ori.add(Integer.parseInt(st.nextToken()));
			
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			int start = 0;
			int num = 0;
			while (st.hasMoreTokens()) {
				if (st.nextToken().charAt(0) == 'I')
					sub = new LinkedList<>();
				start = Integer.parseInt(st.nextToken());
				num = Integer.parseInt(st.nextToken());
				for (int i = 0; i < num; i++) {
					sub.add(Integer.parseInt(st.nextToken()));
				}

				ori.addAll(start, sub);
			}
			for(int i = 0; i < 10; i++) sb.append(ori.get(i) + " ");
			System.out.println("#" + test_case + " " + sb);
		}

	}
}
