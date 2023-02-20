package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 파핑파핑 지뢰찾기
 */
public class BOJ1868 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int T, N;
	static char[][] map;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < map.length; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j] == '.') {
					boolean flag = true;
					for(int k = 0; k < 4; k++) {
						int nr = i + dr[i];
						int nc = j + dc[i];
						
						if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
							if(map[nr][nc] != '.') {
								flag = false;
								break;
							}
						}
					}
				}
			}
		}
		
	}
}
