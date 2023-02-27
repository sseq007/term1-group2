package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 치킨 배달
 * 0: 빈 칸, 1: 집, 2: 치킨 집
 * 일부 치킨집 폐업, 치킨집의 개수: 최대 M개
 * 도시의 치킨 거리가 가장 작게 될 수 있도록
 * 
 * 입력
 * - N: map의 크기, M: 최대 치킨 집 개수
 * 
 * 출력
 * - 도시 치킨 거리의 최소값
 */
public class BOJ15686 {
	static class Point {
		int r;
		int c;
		int l;

		public Point(int r, int c, int l) {
			super();
			this.r = r;
			this.c = c;
			this.l = l;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M;
	static int minDist;
	static int[][] map;
	static Point[] chi = new Point[13];
	static Point[] selChi;
	static int house; // 집의 개수
	static int count; // 치킨집의 개수
	static int dist, result;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		selChi = new Point[M];
		map = new int[N][N];
		result = Integer.MAX_VALUE;
		
		int k = 0;

		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					house++;
				if (map[i][j] == 2) {
					chi[k] = new Point(i, j, 1);
					count++;
					k++;
				}
			}
		}

		comb(0, 0);
		System.out.println(result);
	}

	// 치킨집을 M개 고르는 경우의 수(조합)
	static public void comb(int k, int idx) {
		if (k == M) {
			dist = 0;
			// 여기에서 bfs 돌려야 됨(치킨 집 동시에)
			bfs(selChi);
			result = Math.min(dist, result);
			return;
		}
		for (int i = idx; i < count; i++) {
			selChi[k] = chi[i];
			comb(k + 1, i + 1);
		}
	}

	// 방향벡터
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static public void bfs(Point[] selChi) {
		Queue<Point> queue = new LinkedList<>();
		boolean v[][] = new boolean[N][N];

		for (int i = 0; i < selChi.length; i++) {
			queue.offer(new Point(selChi[i].r, selChi[i].c, 0));
			v[selChi[i].r][selChi[i].c] = true;
		}

		while (!queue.isEmpty()) {
			Point point = queue.poll();
			if(map[point.r][point.c] == 1) dist += point.l;
			for (int i = 0; i < 4; i++) {
				int nr = point.r + dr[i];
				int nc = point.c + dc[i];
				int level = point.l;
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc]) {
					queue.add(new Point(nr, nc, level + 1));
					v[nr][nc] = true;
				}
			}

		}
	}
}
