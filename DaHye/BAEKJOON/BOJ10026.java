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
	static BufferedReader br;
	static StringBuilder sb;
	static int N;
	static Character[][] arr;
	static Character[][] copyArr; // 적록색약이 아닌 사람
	static Character[][] copyArr2; // 적록색약인 사람
	static int count1; // 적록색약이 아닌 사람
	static int count2; // 적록색약인 사람
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new Character[N][N];
		copyArr = new Character[N][N];
		copyArr2 = new Character[N][N];		
		
		for(int i = 0; i < arr.length; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = tmp.charAt(j);
			}
		}
		
		// 입력 배열을 적록색약이 아닌 사람, 적록색약인 사람 구분해서 배열에 저장함
		arrayCopy(arr, copyArr, copyArr2);
		
		// 적록색약이 아닌 사람
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(copyArr[i][j] == 'R' || copyArr[i][j] == 'G' || copyArr[i][j] == 'B') {
					bfs(new Point(i, j), copyArr, copyArr[i][j]);
					count1++;
				}
				
				if(copyArr2[i][j] == 'G' || copyArr2[i][j] == 'B') {
					bfs(new Point(i, j), copyArr2, copyArr2[i][j]);
					count2++;
				}
			}
		}
		
		System.out.println(count1 + " " + count2);
	}
	
	// 상, 하, 좌, 우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void bfs(Point p, Character[][] input, char c) {
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
	
	public static void arrayCopy(Character[][] arr, Character[][] copy, Character[][] copy2) {
		for(int i = 0; i < arr.length; i++) {
			copy[i] = Arrays.copyOf(arr[i], arr[i].length);
			for(int j = 0; j < arr[i].length; j++) {
				if(copy[i][j] == 'R') {
					copy2[i][j] = 'G';
					continue;
				} else {
					copy2[i][j] = copy[i][j];
				}
			}
		}
	}
	
}
