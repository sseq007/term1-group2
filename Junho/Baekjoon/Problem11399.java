package 알고리즘스터디.Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11399 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n =  Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int[] p = new int[n];
		
		for (int i = 0; i < p.length; i++) {
			p[i]=Integer.parseInt(st.nextToken());
		}
		
		//오름차순 정렬
		Arrays.sort(p);
		int result=0;
		int val=0;
		for (int i = 0; i < p.length; i++) {
			val+=p[i];
			result+=val;
		}
		System.out.println(result);
		
	}

}
