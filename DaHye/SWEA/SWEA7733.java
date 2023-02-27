package SWEA;
/*
 * 치즈 도둑
 * X번째 날에는 맛있는 정도가 X인 칸을 먹음
 * 치즈 덩어리 개수가 가장 많을 때의 개수
 * 입력
 * - T: 테스트 케이스 개수
 * - N: 치즈 한 변의 길이
 * - 맛있는 정도
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA7733 {
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
	static int N;
	static int[][] cheese;
	static int[][] cheeseCopy;
	static int count;
	static int max;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case < T + 1; test_case++) {
			N = Integer.parseInt(br.readLine());
			cheese = new int[N][N];
			cheeseCopy = new int[N][N];
			max = 1;
			
			// 치즈 arr 입력 받기
			for (int i = 0; i < cheese.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < cheese[i].length; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 1; i <= 100; i++) {
				
				for (int r = 0; r < cheese.length; r++) {
					for (int c = 0; c < cheese[r].length; c++) {
						if (cheese[r][c] == i) {
							cheese[r][c] = 0;
						}
					}
				}

				count = 0;
				copyArr(cheese, cheeseCopy);
				
				for (int r = 0; r < cheese.length; r++) {
					for (int c = 0; c < cheese[r].length; c++) {
						if (cheeseCopy[r][c] != 0) {
							Point p = new Point(r, c);
							bfs(p);
							count++;
							max = Math.max(count, max);
						}
					}
				}
			}
			sb.append("#" + test_case + " " + max + "\n");
		}
		System.out.println(sb);
	}

	// 상, 하, 좌, 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static public void bfs(Point p) {		
		
		Queue<Point> queue = new LinkedList<>();

		boolean[][] v = new boolean[N][N];
		v[p.r][p.c] = true;
		queue.offer(new Point(p.r, p.c));
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			cheeseCopy[point.r][point.c] = 0;
			
			for (int i = 0; i < 4; i++) {
				int nr = point.r + dr[i];
				int nc = point.c + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc] && cheeseCopy[nr][nc] != 0) {
					v[nr][nc] = true;
					queue.add(new Point(nr, nc));
				}
			}
		}
	}
	
	static public void copyArr(int[][] arr, int[][] copyArr) {
		for(int i = 0; i < arr.length; i++) {
			copyArr[i] = Arrays.copyOf(arr[i], arr[i].length);
		}
	}
}
