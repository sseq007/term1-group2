package 알고리즘스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

//점프 사방
public class Problem32 {

	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			int y = sc.nextInt(); // 배열크기 Y
			int x = sc.nextInt(); // 배열크기 X
			int n = sc.nextInt(); // 참가자수
			String[][] board = new String[y][x];
			//숫자판 정보 입력
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					board[i][j]=sc.next();
				}
			}
			
			int[] player_x = new int[n]; // 참가자 시작 x 좌표
			int[] player_y = new int[n]; // 참가자 시작 y 좌표
			int[] player_n = new int[n];; // 참가자 참여 횟수
			
			//참가자 정보 입력
			for (int i = 0; i <n; i++) {
				int a=sc.nextInt();
				int b=sc.nextInt();
				player_y[i]=a-1;
				player_x[i]=b-1;
				player_n[i]=sc.nextInt();
			}
			
			
			int trap_n = sc.nextInt(); //함정 개수
			int[] trap_info = new int[trap_n*2];
			//함정 정보 입력
			for (int i = 0; i < trap_info.length; i++) {
				trap_info[i]=sc.nextInt();
			}
			//board에 함정 위치 0으로 설정
			for (int i = 0; i < trap_info.length; i+=2) {
				int trap_y = trap_info[i];
				int trap_x = trap_info[i+1];		
				board[trap_y-1][trap_x-1]="0";

			}
			int money =0; //상금
			
			for (int i = 0; i < n; i++) {
				int jump_n = player_n[i];
				boolean flag = true;
				for(int j =0; j<jump_n;j++) {
					char dir = board[player_y[i]][player_x[i]].charAt(0); //이동 방향
					int jump_len=board[player_y[i]][player_x[i]].charAt(1)-'0'; //이동 칸수
//					System.out.println(dir);
//					System.out.println(jump_len);
					//방향이 오른쪽이고 점프 했을떄 범위에 안 벗어난 경우
					if(dir=='1') {
						if(player_x[i]+jump_len<x) {
							player_x[i]+=jump_len;
						}
						//범위를 벗어난 경우
						else {
							flag=false;
							break;
						}
					}
					//방향이 아래쪽이고 점프 했을떄 범위에 안 벗어난 경우
					else if (dir=='2') {
						if(player_y[i]+jump_len<x) {
							player_y[i]+=jump_len;
						}
						//범위를 벗어난 경우
						else {
							flag =false;
							break;
						}
						
//						System.out.println(player_y[i]);
						
					}
					//방향이 왼쪽이고 점프 했을떄 범위에 안 벗어난 경우
					else if (dir=='3') {
						if(player_x[i]-jump_len>=0) {
							player_x[i]-=jump_len;
						}
						//범위를 벗어난 경우
						else {
							flag =false;
							break;
						}
					}
					else if(dir=='4') {
					//방향이 위쪽이고 점프 했을떄 범위에 안 벗어난 경우
						if(player_y[i]-jump_len>=0) {
							player_y[i]-=jump_len;
						}
						//범위를 벗어난 경우
						else {
							flag=false;
							break;
						}
					}
					
					//함정으로 점프한 경우
					if(board[player_y[i]][player_x[i]]=="0") {
						flag=false;
						break;
					}
				
				}
				//상금 획득
				if(flag) {
				int val = Integer.parseInt(board[player_y[i]][player_x[i]]);
				//System.out.println(val);
				money+=(val*100)-1000;
				
				}
				//상금 획득 x
				else {
					
					money-=1000;
					//System.out.println(money);
				}
				
			}
			System.out.println("#"+tc+" "+money);
			
//			for (int i = 0; i < board.length; i++) {
//				for (int j = 0; j < board.length; j++) {
//					System.out.print(board[i][j]);
//					System.out.print(" ");
//				}
//				System.out.println();
//			}
 		}
	}
}
