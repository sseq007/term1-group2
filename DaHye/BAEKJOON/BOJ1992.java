package BAEKJOON;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 쿼드트리
 * 0, 1이 섞여있으면 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래 나누어서 압축
 * 압축 결과를 차례로 괄호 안에 묶어서 표현
 */
public class BOJ1992 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		
		for(int i = 0; i < arr.length; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < arr[i].length; j++) {
				// 문자, 숫자 실수하지 말 것
				arr[i][j] = tmp.charAt(j) - '0';
			}
		}

		func(0, 0, N);
	}
	
	static public void func(int startI, int startJ, int size) {
		int sum = 0;
		
		for(int i = startI; i < startI + size; i++) {
			for(int j = startJ; j < startJ + size; j++) {
				sum += arr[i][j];
			}
		}
		if(sum == size * size) {
			System.out.print("1");
		} else if(sum == 0) {
			System.out.print("0");
		} else {
			System.out.print("(");
			func(startI, startJ, size / 2);
			func(startI, startJ + size / 2, size / 2);
			func(startI + size / 2, startJ, size / 2);
			func(startI + size / 2, startJ + size / 2,  size / 2);
			System.out.print(")");
		}
	}
}
