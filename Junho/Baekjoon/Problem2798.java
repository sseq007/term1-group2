package 알고리즘스터디.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//불랙잭
public class Problem2798 {

	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] card = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			card[i]=Integer.parseInt(st.nextToken());
		}
		int max_sum=0;
		
		//카드 3장 뽑을 수 있는 모든 경우의 수 
		for(int i=0;i<n-2;i++) {
			for(int j=i+1;j<n-1;j++) {
				for(int k=j+1;k<n;k++) {
					int val=card[i]+card[j]+card[k];
					//카드 세장의 합이 m을 넘지 않으면 
					if(val<=m) {
						max_sum=Math.max(max_sum, val);
					}
				}
			}
		}
		System.out.println(max_sum);
		
	}
}
