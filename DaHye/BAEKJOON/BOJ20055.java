package BAEKJOON;
/*
 * 컨베이어 벨트 위의 로봇
 * ~10:30
 * 길이가 2N인 벨트가 컨베이어 벨트를 위아래로 감싸며 돌고있음
 * 1번 칸이 있는 위치: 올리는 위치
 * N번 칸이 있는 위치: 내리는 위치
 * 로봇: 올리는 위치에만 올릴 수 있음, 내리는 위치에 도달하면 즉시 내림
 * 로봇이 어떤 칸으로 이동하면 내구도는 즉시 1만큼 감소
 * 입력
 * - N, K: N: 열의 개수, K: 내구도가 0인 칸의 개수가 K개 이상일 때 종료
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ20055 {
	class Robote {
		int r, c;

		public Robote(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, K, arr[][];
	static boolean v[][]; // 로봇이 있는지 없는지
	static int[] dr = { 0, 1, 0, -1 }; // 우, 하, 좌, 상
	static int[] dc = { 1, 0, -1, 0 };
	static int count;
	static Queue<Robote> queue = new LinkedList<>();
	static Queue<Robote> moveRobote;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		arr = new int[2][N];
		v = new boolean[2][N];

		// 내구도 입력
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < N; j++) {
				if (i == 0) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
				if (i == 1) {
					arr[i][N - 1 - j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		// 배열 돌리기
		arr = rotate();

		// 로봇 올리기
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		
		while(true) {
			count++;
			
			// 1. 올리는 위치에 있는 칸의 내구도가 0이 아니면 로봇 올리기
			if(arr[0][0] != 0) {
				v[0][0] = true;
				arr[0][0]--;
			}
			
			// 2. 
			
			// 내려주기
			v[0][N - 1] = false;
			
			// 로봇과 함께 칸 회전
			arr = rotate();
			v = rotateV();
			roateRobotes();
			
			if(moveRobote.peek().r)
			moveRobote();
			
			if(!check()) break;
		}
		

	}

	private static void roateRobotes() {
		moveRobote = new LinkedList<>();
		while(!queue.isEmpty()) {
			Robote ro = queue.poll();
			if(ro.r == 1 && ro.c == 0) {
				moveRobote.add(new Robote(0, 0));
			} 
			if(ro.r == 0 && ro.c == N - 1) {
				moveRobote.add(new Robote(1, N-1));
			}
			if (ro.r == 1 && ro.c != 0) {
				moveRobote.add(new Robote(1, ro.c - 1));
			}
			if (ro.r == 0 && ro.c != N - 1) {
				moveRobote.add(new Robote(0, ro.c + 1));
			}
		}
	}

	private static void moveRobote() {
		// 00 -> 01 -> 02
		
	}

	// 내구도가 0인 칸의 개수가 K개 이상인지 check 하는 함수
	private static boolean check() {
		int count = 0;
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[0].length; c++) {
				if(arr[r][c] == 0) count++;
			}
		}
		if(count >= K) return false;
		return true;
	}

	private static int[][] rotate() {
		int[][] tmp = new int[arr.length][arr[0].length];

		for (int r = 0; r < tmp.length; r++) {
			for (int c = 0; c < tmp[0].length; c++) {
				if (r == 0 && c == 0) {
					tmp[r][c] = arr[1][0];
				}
				if (r == 1 && c == N - 1) {
					tmp[r][c] = arr[0][N - 1];
				}
				if (r == 0 && c != 0) {
					tmp[r][c] = arr[r][c - 1];
				}
				if (r == 1 && c != N - 1) {
					tmp[r][c] = arr[r][c + 1];
				}
			}
		}
		return tmp;
	}
	
	private static boolean[][] rotateV() {
		boolean[][] tmp = new boolean[arr.length][arr[0].length];

		for (int r = 0; r < tmp.length; r++) {
			for (int c = 0; c < tmp[0].length; c++) {
				if (r == 0 && c == 0) {
					tmp[r][c] = v[1][0];
				}
				if (r == 1 && c == N - 1) {
					tmp[r][c] = v[0][N - 1];
				}
				if (r == 0 && c != 0) {
					tmp[r][c] = v[r][c - 1];
				}
				if (r == 1 && c != N - 1) {
					tmp[r][c] = v[r][c + 1];
				}
			}
		}
		return tmp;
	}
}
