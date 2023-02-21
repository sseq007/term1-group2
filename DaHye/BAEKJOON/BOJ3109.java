package BAEKJOON;
/*
 *  빵집
 *  첫째 열: 빵집의 가스관
 *  마지막 열: 원웅이의 빵집
 *  가스관과 빵집을 연결하는 파이프 설치, 빵집과 가스관 사이에는 건물이 있을 수 있음
 *  건물이 있는 경우 파이프 설치 X
 *  
 *  파이프라인: 첫째 열에서 시작, 마지막 열에서 끝
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3109 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int R, C;
	static int ans;
	static char[][] map;
	static boolean flag;
	
	// 우상, 우, 우하
	static int[] dr = new int[] {-1, 0, 1};
	static int[] dc = new int[] {1, 1, 1};
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for (int i = 0; i < map.length; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		
//		print(map);
		for(int r = 0; r < R; r++) {
			// 시작할 때마다 flag
			flag = false;
			solve(r, 0);
		}
		
		System.out.println(ans);
	}
	
	private static void print(char[][] map) {
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				System.out.print(map[r][c]);
			}System.out.println();
		}
	}

	static void solve(int r, int c) {
		// 속도향상에 대한 코드
		if(flag) return;
		// c -> C까지 가보자
		if(c == C - 1) {
			ans++;
			flag = true;
			return;
		}
		// basis part
		
		// inductive part
		for (int d = 0; d < 3; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == '.' && !flag) {
				map[nr][nc] = 'x';
				solve(nr, nc);
			}
		}
	}
}
