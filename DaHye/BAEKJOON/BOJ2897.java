package BAEKJOON;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2897 {
	// 카드의 합이 21을 넘지 않는 한도 내에서 합을 최대한 크게 만들기
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 카드의 개수
		int N = Integer.parseInt(st.nextToken());
		// 넘지 말아야 할 수
		int M = Integer.parseInt(st.nextToken());
		int[] card = new int[N];
		int max = Integer.MIN_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < card.length; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < card.length - 2; i++) {
			for(int j = i + 1; j < card.length - 1; j++) {
				for(int k = j + 1; k < card.length; k++) {
					int sum = card[i] + card[j] + card[k];
					if(sum <= M) {
						max = Math.max(max, sum);
					}
				}
			}
		}
		System.out.println(max);
	}

}
