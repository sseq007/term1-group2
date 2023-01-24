package 알고리즘스터디.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//영식이와 친구들
public class Problem1592 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		int[] ball = new int[n];
		//처음 공 받은 사람 1 증가
		ball[0]=1;
		int result=0;
		int idx =0;
		loop:
		while(true) {
			//만약 idx 위치의 값이 m이면 break 탈출
			if(ball[idx]==m) {
				break;
			}
			//idx 위치의 값이 짝수일때
			if(ball[idx]%2==0) {
					idx-=l;
				}
			//idx 위치의 값이 홀수일때
			else {
				idx+=l;
			}
			//idx가 0보다 작아지면
			if(idx<0) idx+=n;
			//idx가 n보다 커지면
			else if(idx>=n) idx-=n;
			
			ball[idx]+=1;
			result+=1;
		}
		System.out.println(result);
	}
}
