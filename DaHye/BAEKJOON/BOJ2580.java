package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 스도쿠
 */
public class BOJ2580 {
	static class Point {
		int r;
		int x;
		public Point(int r, int x) {
			super();
			this.r = r;
			this.x = x;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map = new int[9][9];
	static ArrayList<Point> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		for(int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) list.add(new Point(i, j));
			}
		}
		
	}
}
