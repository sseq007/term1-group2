package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*
 * 정사각형 방
 * 어떤 방에 있으면 상, 하, 좌, 우에 있는 다른 방으로 이동할 수 있음
 * 이동하려는 방에 적힌 숫자가 현재 방에 적힌 숫자보다 1 커야 함
 * 처음 어떤 수가 적힌 방에 있어야 가장 많은 개수의 방을 이동할 수 있는지
 *
 * 입력
 * - T: 테스트케이스
 * - N: 정수
 * - arr: 서로 다른 수의 배열
 * 
 *  출력
 *  - 처음에 출발해야 하는 방 번호와 최대 몇 개의 방을 이동할 수 있는지
 */
public class SWEA1861 {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;

	static int T;
	static int N;
	static int[][] arr;
	static boolean[][] v;
	static int count;
	static int idx, max;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case < T + 1; test_case++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			max = 1;
			idx = Integer.MAX_VALUE;
			
			for(int i = 0; i < arr.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int r = 0; r < arr.length; r++) {
				for (int c = 0; c < arr[r].length; c++) {
					count = 1;
					
					v = new boolean[N][N];
					
					v[r][c] = true;
					func(r, c);
					v[r][c] = false;
					
					if(max == count) {
						idx = Math.min(arr[r][c], idx);
						max = count;
						continue;
					}
					if(max < count) {
						idx = arr[r][c];
						max = count;
						continue;
					}
				}
			}
			sb.append("#" + test_case + " " + idx + " " + max + "\n");
		}
		System.out.println(sb);
	}
	
	// 상, 하, 좌, 우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static public void func(int r, int c) {
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr >= 0 && nr < N && nc >= 0 && nc < N && (arr[nr][nc] == (arr[r][c] + 1))) {
				if(v[nr][nc] == true) continue;
				count++;
				v[nr][nc] = true;
				func(nr, nc);
				v[nr][nc] = false;
			}
		}
	}
}
