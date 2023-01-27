	
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 비밀편지 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        String[] alpNum = {"000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010"};
        char[] chr = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        
        String input = br.readLine();
        String[] inputToNum = new String[N];
        // 문자가 없는 암호를 갖는 inpuToNum의 index
        int idx = 0;
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < input.length(); i++) {
            // 0, 1, 2, 3, 4, 5, 11
            sb.append(input.charAt(i));
            if(i % 6 == 5) {
                inputToNum[i / 6] = sb.toString();
                sb = new StringBuilder();
            }
        }
        
        sb = new StringBuilder();
        for (int i = 0; i < inputToNum.length; i++) {
            for (int j = 0; j < alpNum.length; j++) {
                int sameChr = 0;
  
            	for(int k = 0; k < 6; k++) {
            		if(inputToNum[i].charAt(k) != alpNum[j].charAt(k)) {
            			sameChr++;
            		}
//            		System.out.println(inputToNum[i] + " " + alpNum[j] + " " + sameChr);
            	}
            	if(sameChr == 0 || sameChr == 1) {
            		sb.append(chr[j]);
            		break;
            	}
            	// alpNum배열에서 inputToNum[i]와 같은 것이 없는 경우
            	if(j == 7) {
            		idx += 1;
            	}
            }
            if(idx != 0) {
            	sb = new StringBuilder();
            	sb.append(i + 1);
            	break;
            }
        }
        System.out.println(sb);
    }

}