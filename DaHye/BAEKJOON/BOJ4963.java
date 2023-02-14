package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 섬의 개수
 * 섬의 개수를 세는 프로그램
 * 1: 땅, 0: 바다
 * 입력
 * - w: 너비, h: 높이
 * 출력
 * - 섬의 개수
 */

class Point {
	int r;
	int c;
	public Point(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}

public class BOJ4963 {
	static BufferedReader br;
	static StringTokenizer st;
	static int w;
	static int h;
	static int[][] map;
	static int count;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) break;
			
			count = 0;
			
			map = new int[h][w];
			
			// map 정보 입력 받기
			for(int i = 0; i < map.length; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < map[i].length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i = 0; i < map.length; i++) {
				for(int j = 0; j < map[i].length; j++) {
					if(map[i][j] == 1) {
						bfs(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
	
	// 상, 우, 하, 좌
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	static public void bfs(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] v = new boolean[h][w];
		
		v[r][c] = true;
		
		queue.offer(new Point(r, c));
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			map[p.r][p.c] = 0;
			
			for(int i = 0; i < 8; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr >= 0 && nr < h && nc >= 0 && nc < w && !v[nr][nc] && map[nr][nc] == 1) {
					v[nr][nc] = true;
					queue.add(new Point(nr, nc));
				}
			}
		}
	}
}
