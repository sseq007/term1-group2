package BAEKJOON;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1592 {
	// 백준: 1592
	// 1부터 N까지 적혀있는 원형 자리
	// 1번 사람 시작 => 한 사람이 공을 M번 받으면 끝
	// 공을 받은 횟수
	//	* 홀수: 시계방향 L번째
	//	* 짝수: 반시계 방향 L번째
	// 입력: N, M, L
	// 출력: 총을 던진 횟수
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		// 사람을 담을 배열
		int[] arr = new int[N];
		int i = 0;
		int count = 0;
		
		while(true) {
			// 처음 시작하는 사람이 공을 던지기 떄문에
			// arr[i] += 1을 해줌
			arr[i] += 1;
			
			if(arr[i] == M) break;
			count++;
			
			// arr[i]가 홀수: 시계방향 
			if(arr[i] %  2 == 1) {
				// 다른 사람 인덱스
				i = (i + L) % N;
			// arr[i]가 짝수: 반시계방향
			} else {
				i = (N + i - L) % N;
			}
		}
		System.out.println(count);
	}

}
