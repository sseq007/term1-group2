package 알고리즘스터디;

import java.util.Scanner;

//미로 도착지점
public class Problem42 {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt(); //배열크기
			int start_x=sc.nextInt(); // 출발점x좌표
			int start_y=sc.nextInt(); // 출발점 y좌표
			int jumper_n = sc.nextInt(); // 점퍼 개수
			int[][] map= new int[n][n];
			int[] jumper_idx =new int[jumper_n*2];
			
			//점퍼의 좌표 
			for (int i = 0; i < jumper_idx.length; i++) {
				jumper_idx[i]=sc.nextInt();
			}
			
			for (int i = 0; i < jumper_idx.length; i+=2) {
				int jumper_x=jumper_idx[i]-1;
				int jumper_y=jumper_idx[i+1]-1;
				map[jumper_x][jumper_y]=1;
			}
			
			
			int order_n = sc.nextInt(); //이동 지수 개수
			int[] order= new int[order_n*2];
			
			for (int i = 0; i < order.length; i++) {
				order[i]=sc.nextInt();
			}
			for (int i = 0; i < order.length; i+=2) {
				int dir = order[i];
				int move_n = order[i+1];
				
				//1일 경우 위
				if(dir ==1) {
					if(move_up(map,start_x,start_y,move_n,n)==0) {
						start_x=0;
						start_y=0;
						break;
					}
					else {
						start_x=move_up(map,start_x,start_y,move_n,n);
					}
					
				//2일 경우 오른쪽
				}else if(dir==2) {
					if(move_right(map,start_x,start_y,move_n,n)==0) {
						start_x=0;
						start_y=0;
						break;
					}
					else {
						start_y=move_right(map,start_x,start_y,move_n,n);
					}
				}
				//3일경우 아래
				else if(dir==3) {
					System.out.println("move down 값"+move_down(map,start_x,start_y,move_n,n));
					if(move_down(map,start_x,start_y,move_n,n)==0) {
						start_x=0;
						start_y=0;
						break;
					}
					else {
						start_x=move_down(map,start_x,start_y,move_n,n);
					}
				}
				//4일경우 왼쪽
				else  {
					if(move_left(map,start_x,start_y,move_n,n)==0) {
						start_x=0;
						start_y=0;
						break;
					}
					else {
						start_y=move_left(map,start_x,start_y,move_n,n);
					}
				}
				
			}
			
			System.out.printf("#%d %d %d",tc,start_x,start_y);
			System.out.println();
//			System.out.println(start_x);
//			System.out.println(start_y);
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
		
		
	}
	private static int move_left(int[][] map, int start_x, int start_y, int move_n, int n) {
		int ny = start_y;
		ny-=move_n;
		if(ny>=0) {
			if(map[start_x][ny]==1) {
				
				return 0;
			}
			else {
				return ny;
			}
		}
		else {
			return 0;
		}
	}
	private static int move_down(int[][] map, int start_x, int start_y, int move_n, int n) {
		int nx = start_x;
		nx+=move_n;
		if(nx<n) {
			if(map[nx][start_y]==1) {
				
				return 0;
			}
			else {
				return nx;
			}
		}
		else {
			return 0;
		}
	}
	private static int move_right(int[][] map, int start_x, int start_y, int move_n, int n) {
		int ny = start_y;
		ny+=move_n;
		if(ny<n) {
			if(map[start_x][ny]==1) {
				
				return 0;
			}
			else {
				return ny;
			}
		}
		else {
			return 0;
		}
		
	}
	private static int move_up(int[][] map, int start_x,int start_y,int move_n,int n) {
		
		int nx = start_x;
		nx-=move_n;
		if(0<=nx) {
			if(map[nx][start_y]==1) {
				
				return 0;
			}
			else {
				return nx;
			}
		}
		else {
			return 0;
		}
	}
}
