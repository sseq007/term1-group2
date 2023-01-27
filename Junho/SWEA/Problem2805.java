package 알고리즘스터디.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//농작물 수확하기
public class Problem2805 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
	
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int n = Integer.parseInt(br.readLine());
			int sum=0;
			int[][] farm = new int[n][n];
			
			//farm 데이터 저장
			for (int i = 0; i < farm.length; i++) {
				String data = br.readLine();
				for (int j = 0; j < farm.length; j++) {
					farm[i][j]=data.charAt(j)-'0';
				}
			}
			//중간값
			int mid= n/2;
			int start=0,end=0;//시작,끝
			
			//상단 합계
			for(int i=0;i<=mid;i++) {
				for(int j=mid-start;j<=mid+end;j++) {
					sum+=farm[i][j];
					
				}
				start+=1;
				end+=1;
			}
			start-=1;
			end-=1;
			
			//하단 합계
			for(int i=mid+1;i<n;i++) {
				start-=1;
				end-=1;
				for(int j=mid-start;j<=mid+end;j++) {
					sum+=farm[i][j];
					
				}
				
			}
			
			System.out.println("#"+tc+" "+sum);
		}
		
	}
}
