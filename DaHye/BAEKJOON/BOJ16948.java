package BAEKJOON;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 데스 나이트
 */
public class BOJ16948 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int r1, c1, r2, c2;
	static int count = -1;
	
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		
		bfs();
		count = count != -1 ? count + 1 : count;
		System.out.println(count);
	}
	
	static int[] dr = {-2, -2, 0, 0, 2, 2};
	static int[] dc = {-1, 1, -2, 2, -1, 1};
	static public void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r1, c1, 0});
	
		boolean[][] v = new boolean[N][N];
		v[r1][c1] = true;
		
		while(!queue.isEmpty()) {
			int[] point = queue.poll();
			
			for(int i = 0; i < dr.length; i++) {
				int nr = point[0] + dr[i];
				int nc = point[1] + dc[i];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc]) {
					if(nr == r2 && nc == c2) {
						count = point[2];
					}
					queue.add(new int[] {nr, nc, point[2] + 1});
					v[nr][nc] = true;
				}
			}
		}
	}
}
