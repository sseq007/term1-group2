
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Z
/*
 * 재귀를 돌며 size를 2씩 나누어 4구역으로 나눈다
 * 규칙
 * 1사분면 -> size제곱*1
 * 2사분면 -> 0
 * 3사분면 -> size제곱*2
 * 4사분면 -> size제곱*3
 * */
public class Problem1074 {

	static int n,r,c,result;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		result=0;
		int size = (int) Math.pow(2, n);
		recur(0,0,size);
		
		System.out.println(result);
		
		
	}
	private static void recur(int x,int y,int size) {
		
		if(size ==1) {
			return;
		}
		
		//2사분면일떄
		if(r<x+size/2&&c<y+size/2) {
			recur(x, y, size/2);
		}
		
		//1사분면일떄
		if(r<x+size/2&&c>=y+size/2) {
			result+=(int)Math.pow(size/2, 2);
			recur(x, y+size/2, size/2);
		}
		//3사분면일떄
		if(r>=x+size/2&&c<y+size/2) {
			result+=(int)Math.pow(size/2, 2)*2;
			recur(x+size/2, y, size/2);
		}
		//4사분면일때
		if(r>=x+size/2&&c>=y+size/2) {
			result+=(int)Math.pow(size/2, 2)*3;
			recur(x+size/2, y+size/2, size/2);
		}
	}
	

}

