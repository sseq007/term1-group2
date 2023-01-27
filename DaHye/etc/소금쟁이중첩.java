package etc;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소금쟁이중첩 {
	/* 
	 * 소금쟁이: 3칸 -> 2칸 -> 1칸 이동
	 * 앞에서 뛰었던 영역을 또 뛰게 되었을 때 몇 번째 소금쟁이인지 출력
	 * 출력: 같은 영역을 두 번 뛰게 되었을 경우 소금쟁이의 번호
	 *      같은 자리를 뛴 소금쟁이가 하나도 없으면 0을 출력
	 * 23.01.20 | 18시 15분 ~ 19시 00분
	 */

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		// 테스트 케이스의 수 입력
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case < T + 1; test_case++) {
			st = new StringTokenizer(br.readLine());
			// 연못의 크기
			int N = Integer.parseInt(st.nextToken());
			int[][] pond = new int[N][N];
			int result = 0;
			// bug: 소금쟁이
			int bug = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < bug; i++) {
//				System.out.println("i 번째 소금쟁이: " + i);
				st = new StringTokenizer(br.readLine());
				// 소금쟁이 처음 위치
				int initI = Integer.parseInt(st.nextToken());
				int initJ = Integer.parseInt(st.nextToken());
				boolean flag;
				// 몇 번째 소금쟁이인지
				pond[initI][initJ] += 1;
				
				if(pond[initI][initJ] == 2) {
					result = i + 1;
				}
				// 방향
				int dir = Integer.parseInt(st.nextToken());
//				System.out.println("initI" + " : " + initI+ " " + "initJ" + ": " + initJ);
				// 1: 하
				if(dir == 1) {
					for(int j = 3; j > 0; j--) {
						initI += j;
						flag = (initI >= 0 && initI < N) && (initJ >=0 && initJ < N);
						if(flag == false) {
							continue;
						}
						if(pond[initI][initJ] == 0) {
							pond[initI][initJ] += 1;
						} else {
							// 소금쟁이가 있는 인덱스 출력해야 됨
							result = i + 1;
//							System.out.println("initI" + " : " + initI+ " " + "initJ" + ": " + initJ);
							break;
						}
					}
				// 2: 우
				} else if(dir == 2) {
					for(int j = 3; j > 0; j--) {
						initJ += j;
						flag = (initI >= 0 && initI < N) && (initJ >=0 && initJ < N);
						
						if(flag == false) {
							continue;
						}
						if(pond[initI][initJ] == 0) {
							pond[initI][initJ] += 1;
						} else {
							// 소금쟁이가 있는 인덱스 출력해야 됨
							result = i + 1;
//							System.out.println("initI" + " : " + initI+ " " + "initJ" + ": " + initJ);
							break;
						}
					}
				}

			}
			sb.append("#" + test_case + " " + result + "\n");
		}
		System.out.println(sb);
	}

}

