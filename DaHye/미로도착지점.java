import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미로도착지점 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 테스트 케이스 개수
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case < T + 1; test_case++) {
			st = new StringTokenizer(br.readLine(), " ");

			// 방향 정의
			// 상, 우, 하, 좌
			int[] dr = { -1, 0, 1, 0 };
			int[] dc = { 0, 1, 0, -1 };

			int size = Integer.parseInt(st.nextToken());
			int[][] arr = new int[size][size];

			// 출발점의 좌표
			int setX = Integer.parseInt(st.nextToken()) - 1;
			int setY = Integer.parseInt(st.nextToken()) - 1;

			int jumper = Integer.parseInt(st.nextToken());

			// 점퍼의 좌표
			st = new StringTokenizer(br.readLine());

			// 점퍼가 있는 곳은 1로
			for (int i = 0; i < jumper; i++) {
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				arr[a][b] = 1;
			}

			br = new BufferedReader(new InputStreamReader(System.in));
			// 이동지시 개수
			int moveCnt = Integer.parseInt(br.readLine());

			// 이동지시에 대한 입력(이동지시 개수 * 2 회 만큼 진행)
			st = new StringTokenizer(br.readLine(), " ");

			// 이동지시에 대해 저장할 배열
			int[] moveArr = new int[moveCnt * 2];

			// 이동지시 입력 -> 배열
			for (int i = 0; i < moveArr.length; i++) {
				moveArr[i] = Integer.parseInt(st.nextToken());
			}

			// 이동지시 (방향, 이동칸수) 중에서 방향을 담고 있음
//			System.out.println(setX + " " + setY + " ");
			for (int i = 0; i < moveArr.length; i += 2) {
//				System.out.println("i>>" + i + " movearr[i]: " + moveArr[i] + ": " + moveArr[i + 1]);
				// 시작점에서 위로
				for (int j = 0; j < moveArr[i + 1]; j++) {

					setX += dr[moveArr[i] - 1];
					setY += dc[moveArr[i] - 1];
//					System.out.println(" >> " + (setX) + " : " + setY);
					if (setX < 0 || setY < 0 || setX >= size || setY >= size || arr[setX][setY] == 1) {
						setX = 0;
						setY = 0;
						break;
					}
				}
			}

			if (setX == 0 && setY == 0) {
				System.out.println("#" + test_case + " " + setX + " " + setY);
			} else {
				System.out.println("#" + test_case + " "  + (setX + 1) + " " + (setY + 1));
			}
		}
	}

}

//3
//8 5 3 4
//1 8 5 5 1 2 6 7
//5
//1 3 2 1 3 1 4 1 1 2
