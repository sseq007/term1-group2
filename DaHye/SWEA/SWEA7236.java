package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 저수지 물의 총 깊이 구하기
 * 입력
 * T: 테스트 케이스
 * N: 저수지 크기
 * arr[]: 저수지 정보
 */
public class SWEA7236 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int T;
	static int N;
	static char[][] arr;
	
	// 팔방탐색을 하기 위해 필요한 배열(상을 기준으로 시계방향)
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case < T + 1; test_case++) {
			N = Integer.parseInt(br.readLine());
			arr = new char[N][N];
			int max = 0;
			for(int i = 0; i < arr.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = st.nextToken().charAt(0);
				}
			}
			
			for(int r = 0; r < arr.length; r++) {
				for(int c = 0; c < arr[r].length; c++) {
					if(arr[r][c] == 'W') {
						max = Math.max(max, func(r, c));
					}
				}
			}
			sb.append("#" + test_case + " " + max + " \n");
		} 
		System.out.println(sb);
	}
	
	static public int func(int r, int c) {
		int count = 0;
		for(int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
				if(arr[nr][nc] == 'W') count++;
			}
		}
		return count == 0 ? 1 : count;
	}
}
