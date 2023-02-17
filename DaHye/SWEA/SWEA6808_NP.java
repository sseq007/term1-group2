package SWEA;
import java.io.BufferedReader;
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
public class SWEA6808_NP {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int T;
	static HashSet<Integer> cardSet;
	static int[] gyu; // 규영이의 카드
	static int[] in;  // 인영이의 카드
	static int gyuWin;
	static int gyuLose;
	static int same;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case < T + 1; test_case++) {
			gyuWin = 0;
			gyuLose = 0;
			same = 0;
			cardSet = new HashSet<>();
			// cardSet에 1부터 18까지
			for(int i = 1; i < 19; i++) cardSet.add(i);

			gyu = new int[9];
			in = new int[9];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 9; i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
				cardSet.remove(gyu[i]);
			}
			Integer[] copyArr = new Integer[9];
			
			for(int i = 0; i < 9; i++) {
				copyArr[i] = (int) cardSet.toArray()[i];
			}
			
			Arrays.sort(copyArr);
			
			do {
				game(gyu, copyArr);
			} while(np(copyArr));
			
			sb.append("#" + test_case + " " + gyuWin + " " + gyuLose + "\n");
		}
		System.out.println(sb);
	}
	
	static public void game(int[] gyuCard, Integer[] copyArr) {
		int gyuScore = 0;
		int inScore = 0;
		
		for(int i = 0; i < 9; i++) {
			// 인영이가 이기는 경우
			if(gyuCard[i] < copyArr[i]) {
				inScore += (gyuCard[i] + copyArr[i]);
				if(inScore > 171) break;
			// 규영이가 이기는 경우
			} 
			if(gyuCard[i] > copyArr[i]){
				gyuScore += (gyuCard[i] + copyArr[i]);
				if(gyuScore > 171) break;
			}
		}
		if(gyuScore == inScore) same++;
		if(gyuScore > inScore) gyuWin++;
		if(gyuScore < inScore) gyuLose++;
	}
	
	private static boolean np(Integer[] input) {
		int n = input.length;
		
		// step1. 뒤쪽부터 꼭대기를 찾는다. (꼭대기 바로 앞이 교환할 자리)
		int i = n - 1;
		
		while(i > 0 && input[i - 1] >= input[i]) --i;
		// 입력 숫자가 가장 큰 수야!
		if(i == 0) return false;
		
		// step2. 꼭대기 바로 앞(i - 1) 자리에 교환할 값을 뒤쪽부터 찾는다.
		int j = n - 1;
		while(input[i - 1] >= input[j]) --j;
		
		// step3. 꼭대기 마로 앞 (i - 1) 자리와 그 자리값보다 한 단계 큰 자리(j) 수와 교환
		swap(input, i - 1, j);
		
		// step4. 꼭대기부터 맨 뒤까지 오름차순으로 정렬
		int k = n - 1;
		while(i < k) {
			swap(input, i++, k--);
		}
		return true;
	}
	
	private static void swap(Integer[] input, int i, int j) {
			int tmp = input[i];
			input[i] = input[j];
			input[j] = tmp;
	}
}