import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 비밀번호 {
	// SWEA: 1234
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("./Dahye/Input/비밀번호_input.txt"));
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = null;
		
		for (int test_case = 1; test_case < 11; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			sb = new StringBuffer(st.nextToken());
			
			while(true) {
				boolean flag = false;
				for (int i = 0; i < sb.length() - 1; i++) {
					if(sb.charAt(i) == sb.charAt(i + 1)) {
						sb.delete(i, i + 2);
						break;
					}
					if(i == sb.length() - 2 && sb.charAt(i) != sb.charAt(i + 1)) {
						flag = true;
					}
				} 
				if(flag == true) break;
			}
			System.out.println("#" + test_case + " " + sb);
		}
	}

}
