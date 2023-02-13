package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2493 {
	/*
	 * 탑 
	 * 입력 
	 * - N: 탑의 수 - 탑들의 높이가 직선상에 놓인 순서대로 출력 
	 * - 각각의 탑들에서 발사한 레이저 신호를 수신한 탑들의 번호
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
//			int N = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int max = 0;

		Stack<Integer> stack = new Stack<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			ArrayList<Integer> copyStack = new ArrayList<>();
			boolean flag = false;

			stack.add(tmp);
			copyStack.addAll(0, stack);

			while (!copyStack.isEmpty()) {
				if (copyStack.get(copyStack.size() - 1) > tmp) {
					sb.append((copyStack.size() + 1) + " ");
					flag = true;
					break;
				}
			}
			if (flag == false)
				sb.append(0 + " ");
		}

		System.out.println(sb);
	}
}