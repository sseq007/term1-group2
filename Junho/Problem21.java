package 알고리즘스터디;

import java.util.Scanner;

//소금쟁이 중첩
public class Problem21 {

	//하:1 우:2
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt(); // 연못의 크기
			int salt_n = sc.nextInt(); // 소금쟁이 수
			int[][] lake = new int[n][n]; // 호수 2차원 배열
			
			int[][] order = new int[salt_n][3]; // 지시 배열
			//지시 배열에 담기
			for (int i = 0; i < order.length; i++) {
				for (int j = 0; j < 3; j++) {
					order[i][j]=sc.nextInt();
				}
			}
			int result=0; //결과
			int state=0; 
			
				for(int i=0;i<salt_n;i++) {
					int start_x =order[i][0] ;
					int start_y = order[i][1];
					int dir = order[i][2];
					//하일떄
					if(dir ==1) {
						for(int a=3;a>=1;a--) {
			
							start_x=jump_down(start_x,start_y,a,n,lake);
							//범위를 벗어나면
							if(start_x==-1) {
								break;
							}
							//같은 영역을 두번 점프할떄
							if(lake[start_x][start_y]==2) {
								result=i+1;
								state=1;
								break;
							}	
						}
					}else {
						for(int a=3;a>=1;a--) {
							start_y=jump_right(start_x,start_y,a,n,lake);
//							System.out.println(start_y);
							//범위를 벗어 날떄
							if(start_y==-1) {
								break;
							}
							//같은 범위를 두번 점프할때
							if(lake[start_x][start_y]==2) {
								result=i+1;
								state=1;
								break;
							}
					}
				}
			//같은 범위를 두번 점프하면 break를 통해서 for문 탈출
			if(state==1) {
				break;
			}
				}
//				for (int i = 0; i < lake.length; i++) {
//					for (int j = 0; j < lake.length; j++) {
//						System.out.print(lake[i][j]);
//					}
//					System.out.println();
//				}
				System.out.println("#"+tc+" "+result);
		}
		
	}

	private static int jump_right(int start_x, int start_y, int a, int n, int[][] lake) {
		int ny = start_y;
		ny+=a;
//		System.out.println(ny);
		
		if(ny<n) {
			lake[start_x][ny]+=1;
		}
		else return -1;
		return ny;
	}

	private static int jump_down(int start_x, int start_y,int a, int n, int[][] lake) {
		
		int nx = start_x;
		nx+=a;
		if(nx<n) {
			lake[nx][start_y]+=1;
		}
		
		else return -1;
		return nx;
	}
}
