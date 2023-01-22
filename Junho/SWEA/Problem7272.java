package 알고리즘스터디.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem7272 {

	static String[] alp = {"CEFGHIJKLMNSTUVWXYZ","ADOPQR","B"};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			 
			String data1= st.nextToken();
			String data2= st.nextToken();
			
			String result="SAME";
			//문자열 길이가 다르면
			if(data1.length()!=data2.length()) {
				result="DIFF";
			}
			else {
				//문자열 비교
				for(int i=0;i<data1.length();i++) {
					String check1 = data1.substring(i,i+1);
					String check2  =data2.substring(i,i+1);
					for(int j =0;j<alp.length;j++) {
						if(alp[j].contains(check1)!=alp[j].contains(check2)) {
							result="DIFF";
						}
					}
					
				}
				
			}
			System.out.println("#"+tc+" "+result);
		}
	}

}
