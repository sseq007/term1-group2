package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 단지번호붙이기
 * 1: 집이 있는 곳
 * 0: 집이 없는 곳
 * 입력
 * - 지도
 * 출력
 * - 단지 수
 * - 단지 내 집의 수(오름차순)
 */

public class BOJ2667 {
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
	static StringBuilder sb;
	static int N; // 지도의 크기
	static int[][] map; // 지도
	static int count = 0;
	static ArrayList<Integer> countHouse;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		countHouse = new ArrayList<>();
		
		// map 입력정보 받기
		for (int i = 0; i < map.length; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}

		// 집이 있는 곳 탐색 시작
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 1) {
					bfs(i, j);
					count++;
				}
			}
		}
		
		sb.append(count + "\n");
		Collections.sort(countHouse);
		printHouse(countHouse);
		
		System.out.println(sb);
	}

	// 상, 하, 좌, 우
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static public void bfs(int r, int c) {
		int count = 0;
		Queue<Point> q = new LinkedList<>();
		boolean[][] v = new boolean[N][N];
		
		// 시작점
		q.offer(new Point(r, c));

		while(!q.isEmpty()) {
			Point p = q.poll();
			map[p.r][p.c] = 0;
			count++;
			for(int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc] && map[nr][nc] == 1) {
					q.add(new Point(nr, nc));
					// 방문배열 체크 잘 하기!
					v[nr][nc] = true;
				}
			}
		}
		countHouse.add(count);
	}
	
	static public void printHouse(ArrayList arrList) {
		for(int i = 0; i < arrList.size(); i++) {
			sb.append(arrList.get(i) + "\n");
		}
	}
}
