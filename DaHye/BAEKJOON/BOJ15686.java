package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
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

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
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
	static int count;	// 치킨집의 개수

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		selChi = new Point[M];
		map = new int[N][N];
		
		int k = 0;
		
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					chi[k] = new Point(i, j);
					count++;
					k++;
				}
			}
		}
		
		for (int i = 0; i < count; i++) {
			System.out.println(chi[i].toString());
		}
	}

	// 치킨집을 M개 고르는 경우의 수(조합)
	static public void comb(int k) {

	}
}
