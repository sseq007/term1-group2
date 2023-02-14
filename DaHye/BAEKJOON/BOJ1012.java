package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 유기농 배추
 * 배추 흰지렁이가 한 마리라도 살고 있으면 인접한 배추로 이동할 수 있음
 * 한 배추의 상, 하, 좌, 우로 이동할 수 있음
 * 입력
 * - T: 테스트케이스
 * - M, N, K: 가로길이, 세로길이, 배추 개수
 * - 배추의 위치
 */
public class BOJ1012 {
	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int T;
	static int M;
	static int N;
	static int K;
	static int[][] map;
	static int count; // 흰지렁이 개수
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());

		for (int test_case = 0; test_case < T; test_case++) {
			st = new StringTokenizer(br.readLine());
			count = 0;
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[M][N];
			
			// map에 배추 채우기
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				map[r][c] = 1;
			}
			
			for(int i = 0; i < map.length; i++) {
				for(int j = 0; j < map[i].length; j++) {
					if(map[i][j] == 1) {
						bfs(i, j);
						count++;
					}
				}
			}
			sb.append(count + "\n");
		}
		System.out.println(sb + "\n");
	}
	
	// 상, 하, 좌, 우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static public void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		
		boolean[][] v = new boolean[M][N];
		
		q.offer(new Point(r, c));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			map[p.r][p.c] = 0;
			
			for(int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr >= 0 && nr < M && nc >= 0 && nc < N && !v[nr][nc] && map[nr][nc] == 1) {
					v[nr][nc] = true;
					q.add(new Point(nr, nc));
				}
			}
		}
		
	}
}
