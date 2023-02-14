package BAEKJOON;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576 {
/*
 * 토마토
 * 입력
 * -M: 가로 칸의 수, N: 상자 세로 칸의 수
 * - 1: 익은 토마토, 0: 익지 않은 토마토, -1: 토마토가 들어 있지 않은 칸 
 */
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
	}
	
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int[][] map;
	static int M;
	static int N;
	static int level = 0;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		
		if(fullTomato(map) == false) sb.append(-1);
		else sb.append(level);
		
		System.out.println(sb);
	}
	
	// 상, 하, 좌, 우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static public void bfs() {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] v = new boolean[N][M];
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(map[i][j] == 1) {
					queue.offer(new Point(i, j, 0));
					v[i][j] = true;
				}
			}
		}
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			map[p.r][p.c] = -1;

			for(int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc] && map[nr][nc] == 0) {
					v[nr][nc] = true;
					queue.add(new Point(nr, nc, p.l + 1));
					level = Math.max(level, p.l + 1);
				}
			}
		}
	}
	
	static public boolean fullTomato(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] == 0) return false;
			}
		}
		return true;
	}
}
