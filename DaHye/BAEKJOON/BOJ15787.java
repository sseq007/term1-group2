import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ15787 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 기차의 수
		int N = Integer.parseInt(st.nextToken());
		Integer[][] train = new Integer[N][20];
		
		// null 값 방지
		for(int i = 0; i < train.length; i++) {
			Arrays.fill(train[i], 0);
		}
		
		// 명령의 수
		int M = Integer.parseInt(st.nextToken());
		
		// 명령을 수행할 때 기차의 변화를 저장하기 위한 변수
		Deque<Integer> trainTmp = new LinkedList<>();
		
		// 기록 목록을 확인하기 위해 기차의 상태를 문자열로 저장하기 위한 변수
		String[] trainString = new String[N];
		// count 되면 안되는 문자열
		String noneString = "00000000000000000000";
		// 기록된 기차의 수
		int count = 0;
		
		for(int cmd_case = 0; cmd_case < M; cmd_case++) {
			ArrayList<Integer> cmd = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				cmd.add(Integer.parseInt(st.nextToken()));
			}
			
			int num = cmd.get(0);
			int i = cmd.get(1);
			int x = 0;
			if(cmd.size() == 3)x = cmd.get(2);

			// 기차마다 명령 적용
			trainTmp = new LinkedList<>(Arrays.asList(train[i]));
			// i번째 기차에 x 번째 좌석에 사람 태우기
			// 이미 사람이 타있으면 아무것도 하지 않음
			if(num == 1) {
				train[i - 1][x - 1] = 1;
			// i번째 기차에 x번째 좌석에 앉은 사람 하차
			// 아무도 그 자리에 앉아있지 않으면 아무 것도 하지 않음
			} else if(num == 2) {
				train[i - 1][x - 1] = 0;
			// i번째 기차에 앉아있는 사람들이 모두 한 칸씩 뒤로 감
			} else if(num == 3) {
				// 배열을 deque로
				trainTmp.addFirst(0);
				// Integer[]는 Add cast 생겨서 만들어줬음
				for(int k = 0; k < trainTmp.toArray().length - 1; k++) {
					train[i - 1][k] = (Integer) trainTmp.toArray()[k];
				}
			// i번째 기차에 있는 승객들을 한칸씩 앞으로
			// poll
			} else if(num == 4) {
				trainTmp.pollFirst();
				// Integer[]는 Add cast 생겨서 만들어줬음
				for(int k = 0; k < trainTmp.toArray().length; k++) {
					if(trainTmp.toArray()[k] != null) train[i - 1][k] = (Integer) trainTmp.toArray()[k];
				}
			}

		}
		
		
		for(int i = 0; i < train.length; i++) {
			StringBuilder tmp = new StringBuilder();
			for(int j = 0; j < train[i].length; j++) tmp.append(train[i][j]);
			trainString[i] = tmp.toString();
			if(trainString[i].equals(noneString)) continue;
			for(int j = 0; j <= i; j++) {
//				System.out.println(">>");

				if(j == i) {
					count++;
				} else {
					if(trainString[i].equals(trainString[j])) break;
				}
			}

		}
		
		System.out.println(count);

	}
}