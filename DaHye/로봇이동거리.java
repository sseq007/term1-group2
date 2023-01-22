import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇이동거리 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());

		// 우, 하, 좌, 상
		int[] dc = {1, 0, -1, 0};
		int[] dr = {0, 1, 0, -1};
//		for(int test_case = 1; test_case < T + 1; test_case++) {
		char[][] arr = new char[N][N];
		int count = 0;
		// 배열 입력
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = st.nextToken().charAt(0);
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				// 배열 범위 안에 있는지 확인하는 flag1
				boolean flag = false;
				int tmpI = i;
				int tmpJ = j;

				if (arr[tmpI][tmpJ] == 'A') {
					while(true) {
						tmpJ += 1;
						tmpI += 0;
						System.out.println("tmpI" + tmpI + " : " + "tmpJ" + tmpJ);
						if(tmpJ < arr[i].length) flag = true;
						if(flag == true && arr[tmpI][tmpJ] == 'S') {
							count +=1;
						}
						else continue;
					}
				} 
//				else if (arr[i][j] == 'B') {
//					for(int k = 0; k < 4; k++) {
//						// 우
//						if(k == 0) {
//							tmpJ += dc[0];
//							tmpI += dr[0];
//							flag = tmpJ < arr[i].length;
//							if(flag == false || arr[tmpI][tmpJ] != 'S') continue;
//							else count += 1;
//						} 
//						// 좌
//						else if(k == 2) {
//							tmpJ += dc[2];
//							tmpI += dc[2];
//							
//							flag = tmpJ < 0;
//							if(flag == false || arr[tmpI][tmpJ] != 'S') continue;
//							else count += 1;
//						}
//					}
//				} else if(arr[i][j] == 'C') {

//				}
				System.out.println(count);
//				System.out.println(tmpI + " " + tmpJ);
			}
		}
	}
}
