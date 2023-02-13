package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1225 {
	/*
	 * 암호생성 첫 번째 숫자를 1 감소한 뒤, 맨 뒤로 그 다음 수는 2 감소한 뒤 맨 뒤로, ... 숫자가 감소할 때, 0보다 작아지는 경우
	 * 0으로 유지 -> 0이 되는 숫자가 생기면 프로그램 종료
	 * 
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case < 11; test_case++) {
			int num = Integer.parseInt(br.readLine());
			int[] arr = new int[8];
			StringBuilder sb = new StringBuilder();
			Queue<Integer> queue = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < arr.length; i++)
				queue.add(Integer.parseInt(st.nextToken()));

			int sub = 1;
			while (true) {
				int k = queue.peek();
				int addK = 0;

				if (k - sub < 0)
					addK = 0;
				else
					addK = k - sub;

				queue.poll();
				queue.add(addK);
				
				sub += 1;
				if(sub == 6) sub %= 5;
				
				if (addK == 0)
					break;
			}
			
			while(!queue.isEmpty()) {
				sb.append(queue.poll() + " ");
			}
			
			System.out.println("#" + test_case + " " + sb);
		}

	}
}
