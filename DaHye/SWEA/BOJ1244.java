package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1244 {
	/*
	스위치 켜고 끄기
	'1': 스위치 켜져 있음, '0': 스위치 꺼져 있음
	남학생: 스위치 번호 == 자기가 받은 수의 배수 -> 스위치의 상태를 바꿈
	여학생: 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서 
		  가장 많은 스위치를 포함하는 구간을 찾아서, 그 구간에 속한 스위치의 상태를 모두 바꿈
		  이 때, 구간에 속한 스위치의 개수는 항상 홀수 개
	입력
	- N: 스위치의 개수(100 이하의 양의 정수)
	- arr: 스위치의 상태
	- test_case: 학생 수
	- student: 학생 수(남: 1, 여: 2) + num: 스위치의 상태를 바꾸는 수
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 스위치의 상태 입력받음
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		int test_case = Integer.parseInt(br.readLine());
		
		for(int T = 0; T < test_case; T++) {
			st = new StringTokenizer(br.readLine());
			
			// 여학생인지, 남학생인지
			int student = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			num--;
			func(arr, student, num);
		}
		
		// 출력 형식 잘 확인할 것
		for(int i = 0; i < arr.length; i++) {
			if(i != 0 && i % 20 == 0) sb.append("\n");
			sb.append(arr[i] + " ");
		}
		System.out.print(sb);
	}
	
	public static void func(int[] arr, int student, int num) {
		if(student == 1) {
			for(int i = 0; i < arr.length; i++) {
				if((i + 1) % (num + 1) == 0) {
					arr[i] = Math.abs(arr[i] - 1);
				}
			}
		} else if(student == 2) {
			arr[num] = Math.abs(arr[num] - 1);
			for(int i = 0; i <= Math.min(arr.length - 1 - num, num); i++) {
				if(arr[num + i] == arr[num - i]) {
					arr[num + i] = Math.abs(arr[num + i] - 1);
					arr[num - i] = Math.abs(arr[num - i] - 1);
				}
				else break;
			}
		}
	}
}
