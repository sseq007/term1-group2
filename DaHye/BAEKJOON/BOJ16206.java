package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ16206 {
	// 길이가 22인거 두 번 자르는 것보다는 길이가 20인거 한 번 자르는게 이득
	// 60을 5번 자르는 것 보다는 10, 20, 30이 있을 때 3번 자르는게 이득 -> 10으로 나누어지는거는 정렬
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int cakeCount = 0;
		
		ArrayList<Integer> cake = new ArrayList<>();
		ArrayList<Integer> cake2 = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp % 10 == 0) cake.add(tmp);
			else cake2.add(tmp);
		}
		
		Collections.sort(cake);
		cake.addAll(cake2);
		
		for (int i = 0; i < cake.size(); i++) {
			if (cake.get(i) < 10)
				continue;
			else if (cake.get(i) == 10)
				cakeCount++;
			else if (cake.get(i) > 10) {
				while (cake.get(i) > 10 && M > 0) {
					cake.set(i, cake.get(i) - 10);
					cakeCount++;
					M--;
				}
				// 케이크를 다 자랐는데 남은 케이크의 길이가 10일때
				if (cake.get(i) == 10)
					cakeCount++;
			}
		}
		System.out.println(cakeCount);
	}

}
