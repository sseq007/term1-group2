package BAEKJOON;
/*
 * 알파벳
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1987 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int R, C, max = 1;
	static char[][] map;
	static boolean[] v; // [0]: 해당 문자가 사용 되었는지, [1]: 해당 알파벳이 나왔는지
	static boolean[][] mapV;
	static int count = 1; // 지나간 칸 수 이므로 초기값: 1
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		v = new boolean[26];
		mapV = new boolean[R][C];
		
		for(int i = 0; i < map.length; i++) {
			String input = br.readLine();
			for(int j = 0; j < map[i].length; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		v[map[0][0] - 'A'] = true; // 해당 알파벳 나왔다고 표시
		mapV[0][0] = true;
		
		dfs(0, 0);
		
		System.out.println(max);
	}

	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	private static void dfs(int r, int c) {

		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(!check(nr, nc)) continue;
			if(!v[map[nr][nc] - 'A'] && !mapV[nr][nc]) {
				v[map[nr][nc] - 'A'] = true;
				count++;
				max = Math.max(count, max);
				dfs(nr, nc);
				count--;
				mapV[nr][nc] = false;
				v[map[nr][nc] - 'A'] = false;
			}
		}
	}
	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < R && nc >= 0 && nc < C;
	}
}
