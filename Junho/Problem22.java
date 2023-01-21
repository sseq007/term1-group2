package 알고리즘스터디;

import java.util.Scanner;

//소금쟁이 합계
public class Problem22 {

	//상:1 하:2 좌:3 우:4
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
			int result = salt_n; //결과
				for(int i=0;i<salt_n;i++) {
					int start_x =order[i][0] ;
					int start_y = order[i][1];
					int dir = order[i][2];
					//상일떄
					if(dir ==1) {
						//시작위치에 이미 다른 소금쟁이가 있다면
						if(lake[start_x][start_y]==1) {
							result--;
							continue;
						}
						for(int a=3;a>=1;a--) {
							start_x=jump_up(start_x,start_y,a,n,lake);
							//범위를 벗어나면
							if(start_x==-1) {
								result--;
								break;
							}
							//다른 소금쟁이가 머물러 있던 곳으로 뛴 경우
							if(lake[start_x][start_y]==2) {
								result--;
								break;
							}
						}
					}
					//하일떄
					else if(dir==2) {
						//시작위치에 이미 다른 소금쟁이가 있다면
						if(lake[start_x][start_y]==1) {
							result--;
							continue;
						}
						for(int a=3;a>=1;a--) {
							start_x=jump_down(start_x,start_y,a,n,lake);
							//범위를 벗어나면
							if(start_x==-1) {
								result--;
								break;
							}
							//다른 소금쟁이가 머물러 있던 곳으로 뛴 경우
							if(lake[start_x][start_y]==2) {
								result--;
								break;
							}
						}
				}
					else if(dir ==3) {
						//시작위치에 이미 다른 소금쟁이가 있다면
						if(lake[start_x][start_y]==1) {
							result--;
							continue;
						}
						for(int a=3;a>=1;a--) {
							start_y=jump_left(start_x,start_y,a,n,lake);
							//범위를 벗어나면
							if(start_y==-1) {
								result--;
								break;
							}
							//다른 소금쟁이가 머물러 있던 곳으로 뛴 경우
							if(lake[start_x][start_y]==2) {
								result--;
								break;
							}
						}
					}else {
						//시작위치에 이미 다른 소금쟁이가 있다면
						if(lake[start_x][start_y]==1) {
							result--;
							continue;
						}
						for(int a=3;a>=1;a--) {
							start_y=jump_right(start_x,start_y,a,n,lake);
							//범위를 벗어나면
							if(start_y==-1) {
								result--;
								break;
							}
							//다른 소금쟁이가 머물러 있던 곳으로 뛴 경우
							if(lake[start_x][start_y]==2) {
								result--;
								break;
							}
						}
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

	private static int jump_left(int start_x, int start_y, int a, int n, int[][] lake) {
		int ny = start_y;
		ny-=a;
		if(ny>=0&&a==1) {
			lake[start_x][ny]+=1;
		}else if(ny<0) return -1;
		return ny;
	}

	private static int jump_up(int start_x, int start_y, int a, int n, int[][] lake) {
		int nx = start_x;
		nx-=a;
		if(nx>=0 && a==1) {
			lake[nx][start_y]+=1;
		}
		else if (nx<0) return -1;
		return nx;
	}

	private static int jump_right(int start_x, int start_y, int a, int n, int[][] lake) {
		int ny = start_y;
		ny+=a;
//		System.out.println(ny);
		
		if(ny<n && a==1)  {
			lake[start_x][ny]+=1;
		}
		else if(ny>=n) return -1;
		return ny;
	}

	private static int jump_down(int start_x, int start_y,int a, int n, int[][] lake) {
		
		int nx = start_x;
		nx+=a;
		if(nx<n && a==1) {
			lake[nx][start_y]+=1;
		}
		
		else if(nx>=n) return -1;
		
		return nx;
	}
}
