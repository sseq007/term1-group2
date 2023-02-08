package SWEA;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA1954 {
	/*
	 * 달팽이 숫자
	 */
	static int[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();


		
		// 방향벡터 - dc: 가로, dr: 세로
		// 우, 하, 좌, 상
		int[] dr = new int[] { 0, 1, 0, -1 };
		int[] dc = new int[] { 1, 0, -1, 0 };
		
		for(int test_case = 1; test_case < T + 1; test_case++) {
			StringBuilder sb = new StringBuilder();
			int N = sc.nextInt();
			arr = new int[N][N];
			int initX = 0;
			int initY = 0;
			int dir = 0;
			int start = 1;
			while(true) {
				arr[initX][initY] = start;
				
				initX += dr[dir];
				initY += dc[dir];
				start++;
				
				if(initX < 0 || initX >= arr.length || initY < 0 || initY >= arr.length || arr[initX][initY] != 0) {
					if(start == N * N + 1) break;
					initX -= dr[dir];
					initY -= dc[dir];
					start--;
					dir = (dir + 1) % 4;
				}
			}
			
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr[i].length; j++) {
					sb.append(arr[i][j] + " ");
				} sb.append("\n");
			}
			System.out.print("#" + test_case + "\n" + sb);
		}

	}

}

