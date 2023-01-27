package etc;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소금쟁이합계 {
	/*
	 * 22.01.20 | 19:06~19:54
	 * 소금쟁이: 3 -> 2 -> 1
	 * 연못 밖으로 나가거나, 앞에서 뛰던 소금쟁이가 마물고 있는 위치와 충돌하면 소금쟁이 죽음
	 * 출력: 연못 내에 살아있는 소금쟁이 수
	 * 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		// 상, 하, 좌, 우
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		for(int test_case = 1; test_case < T + 1; test_case++) {
			st = new StringTokenizer(br.readLine());
			// 연못의 크기
			int N = Integer.parseInt(st.nextToken());
			// 소금쟁이의 수
			int bugs = Integer.parseInt(st.nextToken());
			int[][] pond = new int[N][N];
			
			// 소금쟁이 수
			for(int i = 0; i < bugs; i++) {
				// 시작위치(행, 렬) + 방향(상: 1, 하: 2, 좌: 3, 우: 4)
				st = new StringTokenizer(br.readLine());
				int initI = Integer.parseInt(st.nextToken());
				int initJ = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				boolean flag;
				if(pond[initI][initJ] == 1) {
					continue;
				}
				// 점프 3 -> 2 -> 1
				for (int j = 3; j > 0; j--) {
					initI += dr[dir - 1] * j;
					initJ += dc[dir - 1] * j;
					
					flag = initI >= 0 && initI < N && initJ >= 0 && initJ < N;
					if(flag == false) continue;
					if(pond[initI][initJ] == 1) {
						continue;
					} else if(pond[initI][initJ] == 0) {
						if(j == 1) pond[initI][initJ] += 1;
					} 
				}
//				System.out.println("initI: " + initI +", initJ: " + initJ);
			}
			
			int totalBugs = 0;
			for (int i = 0; i < pond.length; i++) {
				for (int j = 0; j < pond[i].length; j++) {
					if(pond[i][j] == 1) totalBugs += 1;
				}
			}
			sb.append("#" + test_case + " " + totalBugs + "\n");
		}
		System.out.println(sb);
	}
}
