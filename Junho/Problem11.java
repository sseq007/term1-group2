package 알고리즘스터디;

import java.util.ArrayList;
import java.util.Scanner;

//로봇 이동거리
public class Problem11 {
	
	//x방향
	static int[] dx = {-1,0,1,0};
	//y방향
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt();
			
			String[][] board = new String[n][n];
			
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					board[i][j]=sc.next();
				}
			}
			//전체 합계 변수
			int cnt=0;
			
			ArrayList<Integer> result= new ArrayList<>();
			
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					//A일 경우 오른쪽
					if (board[i][j].equals("A")) {
						cnt=move_right(i,j+1,board,n,cnt);
						
					}
					else if (board[i][j].equals("B")) {
					//B일 경우 왼쪽 오른쪽
						cnt = move_right(i,j+1,board,n,cnt);
						cnt=move_left(i,j-1,board,n,cnt);
							
					}
					else if (board[i][j].equals("C")) {
					//C일 경우 왼쪽 오른쪽 위 아래
						cnt = move_right(i, j+1, board, n, cnt);
						cnt = move_left(i, j-1, board, n, cnt);
						cnt = move_up(i-1, j, board, n, cnt);
						cnt = move_down(i+1, j, board, n, cnt);
					}
				}
			}
			System.out.println("#"+tc+" "+cnt);
			
			
			
			
		}
		
	}
	private static int move_down(int i, int j, String[][] board, int n, int cnt) {
		if ( i<n &&  j<n) {
			while (board[i][j].equals("S")) {
				cnt += 1;
				int nx = i;
				int ny = j;

				nx += dx[2];
				ny += dy[2];
				if (n > nx && ny < n) {

					i = nx;
					j = ny;

				} else
					return cnt;

			}

		}
		return cnt;
	
	}
	private static int move_up(int i, int j, String[][] board, int n, int cnt) {
		if (0 <= i && 0 <= j ) {

			while (board[i][j].equals("S")) {
				cnt += 1;
				int nx = i;
				int ny = j;

				nx += dx[0];
				ny += dy[0];

				if (0 <= nx &&0 <= ny) {
					i = nx;
					j = ny;
					

				} else
					return cnt;

			}
		}
		return cnt;
		
	}
	private static int move_left(int i, int j, String[][] board, int n, int cnt) {		
		
		if (0 <= i && 0 <= j ) {

			while (board[i][j].equals("S")) {
				cnt += 1;
				int nx = i;
				int ny = j;

				nx += dx[3];
				ny += dy[3];

				if (0 <= nx &&0 <= ny) {
					i = nx;
					j = ny;
					

				} else
					return cnt;

			}
		}
		return cnt;
	}

	private static int move_right(int i, int j, String[][] board,int n, int cnt) {

		if ( i<n &&  j<n) {
			while (board[i][j].equals("S")) {
				cnt += 1;
				int nx = i;
				int ny = j;

				nx += dx[1];
				ny += dy[1];
				if (n > nx && ny < n) {

					i = nx;
					j = ny;

				} else
					return cnt;

			}

		}
		return cnt;
	}

}
