package baekjoon;

import java.util.*;

public class BOJ1174 {
    static final int N = 1000000;

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        long i = 0;
        while (true) {
            if (list.size() == n) break;
            String num = String.valueOf(i);
            solve(num, 1, num.length());
            i++;
        }
        Collections.sort(list);
        System.out.println("=====" + list.size() + "=====");
        for (int a : list) {
            System.out.println(a);
        }
        System.out.println(n > list.size() || n == 0 ? -1 : list.get(n - 1));
    }

    private static void solve(String num, int k, int len) {
        if (k == len) {
            list.add(Integer.parseInt(num));
            return;
        }

        if (num.charAt(k - 1) - '0' <= num.charAt(k) - '0') return;

        solve(num, k + 1, len);
    }
}
