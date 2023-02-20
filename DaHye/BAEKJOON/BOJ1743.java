package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 음식물 피하기
 */
public class BOJ1743 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, food, tmp, max;
	static int[][] arr; 
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		food = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		max = 1;
		
		for(int i = 0; i < food; i++) {
			st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
		}
		
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[0].length; c++) {
				if(arr[r][c] == 1) { 
					tmp = 0;
					bfs(r, c);
					max = Math.max(max, tmp);
				}
			}
		}
		System.out.println(max);
	}
	
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static public void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		
		queue.offer(new int[] {r, c});
		arr[r][c] = 0;
		
		while(!queue.isEmpty()) {
			int[] point = queue.poll();
			tmp++;
			
			for(int i = 0; i < 4; i++) {
				int nr = point[0] + dr[i];
				int nc = point[1] + dc[i];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && arr[nr][nc] == 1) {
					arr[nr][nc] = 0;
					queue.add(new int[] {nr, nc});
				}
			}
		}
	}
}
