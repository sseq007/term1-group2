package SWEA;
/*
 * 한빈이와 Spot Mart
 * N개의 과자 봉지, 각 과자봉지는 ai의 무게, M 그램을 초과하면 들 수 없음
 * 한빈이가 들고 다닐 수 최대 무게 합 - 과자는 정확히 두 봉지 사야됨
 * 입력
 * - T: 테스트케이스 개수
 * - N, M: 과자 봉지 개수, 무게 합 제한
 * 출력
 * - total: 과자 봉지 무게 수
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA9229 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int T, N, M, total;
	static int[] arr;
	static int[] sel;
	
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case < T + 1; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N];
			sel = new int[2];
			total = -1;
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
			
			func(0, 0);
			
			sb.append("#" + test_case + " " + total + "\n");
		}
		System.out.println(sb);
	}
	
	static public void func(int k, int idx) {
		if(k == 2) {
			int sum = sel[0] + sel[1];
			if(sum <= M) total = Math.max(total, sum);
			return;
		}
		
		for(int i = idx; i < N; i++) {
			sel[k] = arr[i];
			func(k + 1, i + 1);
		}
	}
}
