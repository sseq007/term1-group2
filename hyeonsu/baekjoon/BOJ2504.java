package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
연산 스택 : * + *
숫자 스택 : 2 3 3 2
 */
public class BOJ2504 {
    static final boolean PLUS = false;
    static final boolean MULTI = true;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static String input;
    static int ans = 0;
    static int tmp = -1;
    static boolean flag = PLUS;

    static Stack<Character> s = new Stack<>();
    static Stack<Integer> plus = new Stack<>();
    static Stack<Integer> multi = new Stack<>();

    public static void main(String[] args) throws IOException {
        input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // ')'거나 ']' 일 때 스택이 비었거나 서로 다를 경우 잘못된 문자열
            if (c == ')' || c == ']') {
                if (s.isEmpty()) {
                    ans = 0;
                    break;
                }
                if (c == ')') {
                    if (s.peek() != '(') {
                        ans = 0;
                        break;
                    } else {

                    }
                }
                if (c == ']') {
                    if (s.peek() != '[') {
                        ans = 0;
                        break;
                    }
                }
            }
            //'('
        }
    }
}
