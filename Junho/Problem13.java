package 알고리즘스터디;

import java.util.Scanner;

//빌딩
public class Problem13 {

	//가로 세로 B의 개수
	//8방 G check
	//if G 2층 고정

	//x 방향
	static int[] dx= {-1,-1,0,1,1,1,0,-1};
	//y 방향
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	public static void main(String[] args) {
	    
	    Scanner sc = new Scanner(System.in);
	    
	    int T = sc.nextInt();
	    
	    for(int tc=1;tc<=T;tc++) {
	        int n = sc.nextInt();
	        int buliding_max=0;
	        String[][] map=new String[n][n];
	        
	        for (int i = 0; i < map.length; i++) {
	            for (int j = 0; j < map.length; j++) {
	                map[i][j]=sc.next();
	            }
	        }
	        for (int i = 0; i < map.length; i++) {
	            for (int j = 0; j < map.length; j++) {
	                if(map[i][j].equals("B")) {
	                    if(check(map,i,j,n)==false) {
	                        
	                        buliding_max=Math.max(buliding_max, 2);
	                    }
	                    else {
	                        
	                        int cnt=0;
	                        for (int a = 0; a < map.length; a++) {
	                            if(map[i][a].equals("B")) {
	                                cnt+=1;
	                            }
	                            if(map[a][j].equals("B")) {
	                                cnt+=1;
	                            }
	                        }
	                        buliding_max=Math.max(buliding_max, cnt-1);
	                        
	                    }
	                }
	            }
	        }
	        System.out.println("#"+tc+" "+buliding_max);
	    }
	}
	//8방향 체크 함수
	//8방향에 G가 있을 시 false 없을 시 true
	private static boolean check(String[][] map, int x, int y,int n) {
	    
	    for(int i=0;i<8;i++) {
	        int nx = x,ny=y;
	        nx+=dx[i];
	        ny+=dy[i];
	        if(0<=nx&&nx<n&&0<=ny&&ny<n&&map[nx][ny].equals("G")) {
	            return false;
	        }
	    }
	    return true;
	    
	}

	
}
