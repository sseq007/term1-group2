package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 적록색약
 * 적록색약: 빨간색과 초록색 차이를 거의 느끼지 못함
 * 출력: 적록색약이 아닌 사람이 봤을 떄의 구역, 적록색약인 사람이 봤을 때 구역
 */
public class BOJ10026 {
	static class Point{
		int r;
		int c;
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		char[][] arr = new char[N][N];
		char[][] arr2 = new char[N][N];
		
		int count1 = 0;
		int count2 = 0;
		
		for(int i = 0; i < arr.length; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = tmp.charAt(j);
				if(tmp.charAt(j) == 'R') arr2[i][j] = 'G';
				else arr2[i][j] = tmp.charAt(j);
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] == 'R' || arr[i][j] == 'G' || arr[i][j] == 'B') {
					bfs(new Point(i, j), arr, arr[i][j]);
					count1++;
				}
				
				if(arr2[i][j] == 'G' || arr2[i][j] == 'B') {
					bfs(new Point(i, j), arr2, arr2[i][j]);
					count2++;
				}
			}
		}
		
		System.out.println(count1 + " " + count2);
	}
	
	// 상, 하, 좌, 우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void bfs(Point p, char[][] input, char c) {
		Queue<Point> queue = new LinkedList<>();
		
		boolean[][] v = new boolean[N][N];
		
		queue.offer(new Point(p.r, p.c));
		v[p.r][p.c] = true;
		
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			input[point.r][point.c] = ' ';
			for(int i = 0; i < 4; i++) {
				int nr = point.r + dr[i];
				int nc = point.c + dc[i];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc] && input[nr][nc] == c) {
					v[nr][nc] = true;
					queue.add(new Point(nr, nc));
				}
			}
		}
		
	}
}
