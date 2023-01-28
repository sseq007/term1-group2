package BAEKJOON;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2991 {
	/*
	 * 개 한마리:  A분 동안 공격, B분 동안 조용
	 * 다른 개: C분 동안 공격, D 분 동안 조용
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] worker = new int[3];
		
		for(int i = 0; i < 3; i++) worker[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < 3; i++) {
			int result = 0;
			result += dog(a, b, worker[i]);
			result += dog(c, d, worker[i]);	
			sb.append(result + "\n");
		}
		System.out.println(sb);
	}
	// 강아지에 대한 시간: a, b
	public static int dog(int a, int b, int time) {
		time %= (a + b);
		// 0: 공격 받음!
		if(time == 0) return 0;
		if(time <= a) return 1;
		// 1: 공격 안받음!
		else return 0;
	}
}
