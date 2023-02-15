package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
 * 수지의 수지 맞는 여행
 * 명물을 최대한 많이 보되, 요금을 지급하지 않는 방법
 * 같은 알파벳 명물을 두 번 이상 보지 않도록 여행
 */
public class SWEA7699 {
	static int count;
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static char[][] map;
	static boolean[][] v;
	static int T;
	static int R;
	static int C;
	static int max;
	static HashSet<Character> set;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case < T + 1; test_case++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			max = 1;
			map = new char[R][C];
			v = new boolean[R][C];
			set = new HashSet<>();
			
			// 지도에 대한 입력받기
			for (int i = 0; i < map.length; i++) {
				String input = br.readLine();
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = input.charAt(j);
				}
			}
			
			v[0][0] = true;
			dfs(0, 0);
			
			sb.append("#" + test_case + " " + max + "\n");

		}
		System.out.println(sb);
	}

	// 상, 하, 좌, 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static public void dfs(int r, int c) {
		set.add(map[r][c]);
		max = Math.max(max, set.size());
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr >= 0 && nr < R && nc >= 0 && nc < C && !set.contains(map[nr][nc])) {
				if (!v[nr][nc]) {
					v[nr][nc] = true;
					dfs(nr, nc);
					v[nr][nc] = false;
					set.remove(map[nr][nc]);
				}
			}
		}
	}
}
