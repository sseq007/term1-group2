package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 색종이
 * N장의 색종이가 주어진 위치에 차례로 놓일 경우, 각 색종이가 보이는 부분의 면적
 * 입력
 * - N: 색종이의 장수
 * - 가장 왼쪽 아래 칸의 번호와 너비, 높이
 */
public class BOJ10163 {
	static class Paper {
		int r, c, w, h;

		public Paper(int r, int c, int w, int h) {
			super();
			this.r = r;
			this.c = c;
			this.h = h;
			this.w = w;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int N;
	static Paper[] papers;
	static int[][] map = new int[1001][1001];
	
	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		papers = new Paper[N];
		
		for(int t = 0; t < N; t++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int w =Integer.parseInt(st.nextToken());
			
			papers[t] = new Paper(r, c, h, w);
		}
		
		for(int i = 0; i < papers.length; i++) {
			func(papers[i], i + 1);
		}
		print(map);
	}
	
	static private void func(Paper p, int idx) {
		for(int i = p.c; i < p.c + p.w; i++) {
			for(int j = p.r; j < p.r + p.h; j++) {
				map[i][j] = idx;
			}
		}
	}
	
	static private void print(int[][] map) {
		for(int i = 0; i < papers.length; i++) {
			int count = 0;
			for(int r = 0; r < map.length; r++) {
				for(int c = 0; c < map[r].length; c++) {
					if(map[r][c] == i + 1) count++;
				}
			}
			System.out.println(count);
		}
	}
}
