package etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇_이동거리 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());


		// 우, 하, 좌, 상
		int[] dc = { 1, 0, -1, 0 };
		int[] dr = { 0, 1, 0, -1 };
		for (int test_case = 1; test_case < T + 1; test_case++) {
			int N = Integer.parseInt(br.readLine());
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
					int tmpI;
					int tmpJ;

					if (arr[i][j] == 'A') {
						tmpI = i;
						tmpJ = j;
						while (true) {
							tmpJ += 1;
							tmpI += 0;
							flag = tmpJ < arr[i].length;
							if (flag == true && arr[tmpI][tmpJ] == 'S') {
								count += 1;
							} else
								break;
						}
					} else if (arr[i][j] == 'B') {
						for (int k = 0; k < 4; k++) {
							// 우, 좌
							tmpI = i;
							tmpJ = j;
							if (k == 0 || k == 2) {
								while (true) {
									tmpJ += dc[k];
									tmpI += dr[k];
									flag = tmpJ < arr[i].length && tmpJ >= 0;
									if (flag == true && arr[tmpI][tmpJ] == 'S')
										count += 1;
									else
										break;
								}

							}
						}
					} else if (arr[i][j] == 'C') {
						for (int k = 0; k < 4; k++) {
							tmpI = i;
							tmpJ = j;
							while (true) {
								tmpJ += dc[k];
								tmpI += dr[k];
								flag = tmpJ < arr[i].length && tmpJ >= 0 && tmpI < arr.length && tmpI >= 0;
								if (flag == true && arr[tmpI][tmpJ] == 'S')
									count += 1;
								else
									break;
							}
						}
					}
				}
			}
			sb.append("#" + test_case + " " + count + "\n");
		}
		System.out.println(sb);
	}
}
