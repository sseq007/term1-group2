package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class BOJ1874 {
	/*
	 * 스택 수열 
	 * 스택에 push 하는 순서: 반드시 오름차순을 지킴 
	 * 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있느지 없는지
	 * 입력 
	 * - n: n개의 줄에는 수열을 이루는 1 이상 n 이하의 정수가 하나씩 순서대로 주어짐 
	 * 출력 
	 * - push연산은 +로, pop 연산은 -로 표현 
	 * - 불가능한 경우 NO를 출력
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		ArrayList<Integer> popList = new ArrayList<>();
		
		Stack<Integer> stack = new Stack<>();

		int num = 1;
		for(int i = 0; i < arr.length; i++) {
			while(num <= arr[i]) {
				stack.add(num);
				num++;
				sb.append("+\n");
			}
			popList.add(stack.peek());
			stack.pop();
			sb.append("-\n");
		}
		
		for(int i = 0; i < popList.size(); i++) {
			if(popList.get(i) != arr[i]) {
				sb.setLength(0);
				sb.append("NO");
				break;
			}
		}
		System.out.println(sb);
	}
}
