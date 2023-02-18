package BAEKJOON;

/*
 * 그림
 * 그림의 총 개수, 넓이가 가장 넓은 것의 넓이
 * n: 세로 길이, m: 가로 길이
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1926 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static int n;
	static int m;
	static int count;
	static int max;
	static int area;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		for (int r = 0; r < map.length; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < map[r].length; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				if (map[r][c] == 1) {
					count++;
					area = 0;
					bfs(r, c);
					max = Math.max(max, area);
				}
			}
		}
		System.out.println(count + "\n" + max);
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static public void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();

		queue.offer(new int[] { r, c });
		map[r][c] = 0;

		while (!queue.isEmpty()) {
			area++;
			int[] point = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = point[0] + dr[i];
				int nc = point[1] + dc[i];

				if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] == 1) {
					map[nr][nc] = 0;
					queue.add(new int[] { nr, nc });
				}
			}
		}

	}
}