package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 음계
 */
public class BOJ2920 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int[] arr = new int[8];
		boolean flag = true;
		for(int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int start = arr[0] - arr[1];
		for(int i = 0; i < arr.length - 1; i++) {
			if((arr[i] - arr[i + 1]) != start) {
				flag = false;
				break;
			}
		}
		
		if(flag == true) {
			if(start == 1) System.out.println("descending");
			else System.out.println("ascending");
		} else {
			System.out.println("mixed");
		}
	}
}
