package etc;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class 점프사방 {
	// 19시 30분~
	// 앞자리: 방향
	// 뒷자리: 점프 칸 수
	// 점프 후 마지막 좌표에 적힌 숫자에 100을 곱한 금액을 상금으로 받음
	// 입력: 첫 번째 줄 T
	// 	    두 번째 줄 - 배열의 크기: Y, X, N(참가자의 수)
	// 		숫자판의 정보
	//		참가자들의 시작위치(행, 열), 횟수 - 참가자의 수 만큼
	// 		함정의 수, 함정의 좌표
	// 출력: 참가자들의 상금
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		// 우, 하, 좌, 상
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		
		// 상금

		for(int test_case = 1; test_case < T + 1; test_case++) {
			int total = 0;
			st = new StringTokenizer(br.readLine());
			
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int [X][Y];
			// 참가자들의 시작 위치, 횟수를 저장할 배열
			int[][] challenger = new int[N][3];
			// Y * X 숫자판 입력
			for(int i = 0; i < arr.length; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < arr[i].length; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 참자가들의 정보 입력
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < challenger[i].length; j++) {
					challenger[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 함정의 수, 함정의 좌표
			st = new StringTokenizer(br.readLine());
			int hole = Integer.parseInt(st.nextToken());
			
			// 함정의 좌표
			int[][] holeArr = new int[hole][2];
			
			for(int i = 0; i < hole; i++) {
				holeArr[i][0] = Integer.parseInt(st.nextToken());
				holeArr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < holeArr.length; i++) {
				arr[holeArr[i][0] - 1][holeArr[i][1] - 1] = 0;
			}
			
			for(int i = 0; i < challenger.length; i++) {
				total -= 1000;
				// 처음 시작 위치
				int tmpI = challenger[i][0] - 1;
				int tmpJ = challenger[i][1] - 1;
				boolean flag = false;
				// 참여자 정보 입력 중 마지막 입력한 횟수만큼 진행
				for(int j = 0; j < challenger[i][2]; j++) {
					// 배열의 앞자리(방향)
					if(arr[tmpI][tmpJ] == 0) break;
					int arrDirec = arr[tmpI][tmpJ] / 10;
					// 배열의 뒷자리(점프칸수) 
					int arrJump = arr[tmpI][tmpJ] % 10;
					
//					System.out.println("arrDirec: " + (arrDirec - 1));
//					System.out.println(dr[arrDirec - 1]);
					
					tmpI += dr[arrDirec - 1] * arrJump;
					tmpJ += dc[arrDirec - 1] * arrJump;
					
					// 함정에 빠지거나, 경계를 벗어나면 끝
					if(tmpI < 0 || tmpI >= X || tmpJ < 0 || tmpJ >= Y) {
						flag = false;
						break;
					}
					if(arr[tmpI][tmpJ] == 0) {
						flag = false;
						break;
					}
					
					flag = true;
				}
				if(flag == true) {
					total += 100 * arr[tmpI][tmpJ]; 
				}
			}
			System.out.println("#" + test_case + " " + total);
		}
	}
}
