package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3040 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] arr = new int[9];
	static int[] sel = new int[7];
	
	public static void main(String[] args) throws Exception {
		
		for(int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(br.readLine());
		func(0, 0);
	}
	
	static public void func(int k, int idx) {
		if(k == 7) {
			int sum = 0;
			for(int i = 0; i < sel.length; i++) {
				sum += sel[i];
				if(i == sel.length - 1 && sum == 100) {
					for(int j = 0; j < sel.length; j++) {
						System.out.println(sel[j]);
					}
				}
			}
			return;
		}
		
		for(int i = idx; i < arr.length; i++) {
			sel[k] = arr[i];
			func(k + 1, i + 1);
		}
	}
}
