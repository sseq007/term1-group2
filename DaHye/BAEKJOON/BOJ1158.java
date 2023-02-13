package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1158 {
	/* 
	 * 요세푸스 문제
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		sb.append("<");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		for(int i = 1; i < N + 1; i++) queue.add(i);
		
		int i = 1;
		while(!queue.isEmpty()) {
			int tmp = queue.peek();
			if(i % K == 0) {
				if(queue.size() != 1) {
					sb.append(tmp + ", ");
				} else {
					sb.append(tmp);
				}
				queue.poll();
			}
			else {
				queue.poll();
				queue.add(tmp);
			}
			i++;
		}
		sb.append(">");
		System.out.println(sb);
	}
}
