package BAEKJOON;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17413 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int test_case = 0; test_case < T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				String str = st.nextToken();
				for (int i = str.length() - 1; i >= 0; i--) {
					sb.append(str.charAt(i));
				}
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
