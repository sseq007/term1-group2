package SWEA;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
/*
 * 규영이와 인영이의 카드게임
 * 1~18까지의 카드
 * 한 라운드에 한 장의 카드씩 꺼내고 비교해서 점수 계산
 * 높은 수: + (int)두 카드의 적힌 수의 합 점
 * 낮은 수: + 0점
 * 규영이가 내는 카드 순서를 고정하면 인영이가 카드를 내는 순서에 따라 규영이의 승패가 결정됨 - 9!의 가지 수
 * 규영이와 이기는 경우와 지는 경우가 총 몇 가지인지
 * 
 * 입력
 * - T: 테스트 케이스 수
 * 
 * 출력
 * - 인영이가 카드를 내는 경우에 따라 규영이가 이기는 횟수와 지는 횟수
 */
public class SWEA6808 {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int T;
	static int[] gyu; // 규영이의 카드
	static int[] in;  // 인영이의 카드
	static boolean[] v;
	static int gyuWin;
	static int gyuLose;
	static int same;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input/SWEA6808.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case < T + 1; test_case++) {
			gyuWin = 0;
			gyuLose = 0;
			same = 0;

			gyu = new int[9];
			in = new int[9];
			v = new boolean[19];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 9; i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
				v[gyu[i]] = true;
			}
			
			func(0);
			
			sb.append("#" + test_case + " " + gyuWin + " " + gyuLose + "\n");
		}
		System.out.println(sb);
	}
	static public void func(int k) {
		if(k == 9) {
			int gyuScore = 0;
			int inScore = 0;
			
			for(int i = 0; i < 9; i++) {
				if(gyu[i] < in[i]) {
					inScore += (gyu[i] + in[i]);
				// 규영이가 이기는 경우
				} 
				if(gyu[i] > in[i]){
					gyuScore += (gyu[i] + in[i]);
				}
			}
			if(gyuScore > inScore) gyuWin++;
			if(gyuScore < inScore) gyuLose++;
			return;
		}
		
		for(int i = 1; i < 19; i++) {
			if(v[i]) continue;
			v[i] = true;
			in[k] = i;
			func(k + 1);
			v[i] = false;
		}
	}
}