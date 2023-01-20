import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빌딩 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
		int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

		for (int i = 1; i < T + 1; i++) {
			int N = Integer.parseInt(br.readLine());
			char[][] arr = new char[N][N];
			int[][] buildingCount = new int[N][N];

			for (int j = 0; j < arr.length; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < arr[j].length; k++) {
					arr[j][k] = st.nextToken().charAt(0);
				}
			}

			for (int j = 0; j < arr.length; j++) {
				for (int k = 0; k < arr[j].length; k++) {
					int nr = 0;
					int nc = 0;
					int tmp = 0;
					if (arr[j][k] == 'B') {
						for (int l = 0; l < 8; l++) {
							int building = 0;
							nr = j + dr[l];
							nc = k + dc[l];
							if (nr >= 0 && nr < arr.length && nc >= 0 && nc < arr.length) {
								if (arr[nr][nc] == 'G') {
									buildingCount[j][k] = 2;
									tmp = 1;
									continue;
								}
								
								 for(int tmp1 = 0; tmp1 < arr.length; tmp1++) {
									 if(tmp == 0){
									 if(arr[tmp1][k] == 'B') building += 1;
									 if(arr[j][tmp1] == 'B') building += 1;
									 buildingCount[j][k] = building - 1;									 }
								 }

							}

						}
					}
				}
			}
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < buildingCount.length; j++) {
				for (int k = 0; k < buildingCount[j].length; k++) {
					if(buildingCount[j][k] >max) max = buildingCount[j][k];
				}
			}
			sb.append("#" + i + " " + max + "\n");
		}
		System.out.println(sb);
	}
}
