package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class locateCar {
	int x;
	int y;
	char dir;
}

public class SWEA1873 {
	/*
	 * 입력: 맵의 상태, 사용자가 넣을 입력 정수: 테스트케이스 T 정수: H(맵의 높이 - 행), W(맵의 너비 - 열) 문자 배열: map
	 * 2차원 문자 배열 - H x W(맵의 정보) 정수: N(사용자가 넣을 입력의 개수) 문자열: input - 입력의 종류 출력: 모든 입력 처리 후 맵의 상태
	 * 조건: 전차는 단 한개만 존재
	 */

	// 전차가 바라보고 있는 방향
	// N: 북, E:동, S: 남, W: 서

	static locateCar locCar;
	static char[][] map;
	
	// 상, 우, 하, 좌
	static char[] dirCh = { '^', '>', 'v', '<' };
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int H;
	static int W;

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("./DaHye/Input/SWEA1873_2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case < T + 1; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];

			// map에 대한 정보 입력
			for (int i = 0; i < H; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < W; j++)
					map[i][j] = tmp.charAt(j);
			}

			int N = Integer.parseInt(br.readLine());
			String input = br.readLine();

			locCar = LocateCar();
			
			for(int i = 0; i < input.length(); i++) {
				operateFunc(input.charAt(i));
			}
			
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++)
					System.out.print(map[i][j]);
				System.out.println();
			}
		}

	}

	// 전차의 위치를 설정하는 함수
	public static locateCar LocateCar() {
		locateCar locCar = new locateCar();

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v') {
					locCar.x = i;
					locCar.y = j;
					locCar.dir = map[i][j];
				}
			}
		}
		return locCar;
	}

	// 전차가 바라보는 방향을 숫자로 저장해주는 함수
	public static int intDirCar(locateCar locCar) {
		int dir = 0;
		// 0: 북
		if (locCar.dir == '^')
			dir = 0;
		// 1: 동
		else if (locCar.dir == '>')
			dir = 1;
		// 2: 남
		else if (locCar.dir == 'v')
			dir = 2;
		// 3: 서
		else if (locCar.dir == '<')
			dir = 3;
		return dir;
	}

	// 문자 동작 함수
	public static char[][] operateFunc(char c) {
		if (c != 'S') {
			if (c == 'U')
				locCar.dir = dirCh[0];
			else if (c == 'R')
				locCar.dir = dirCh[1];
			else if (c == 'D')
				locCar.dir = dirCh[2];
			else if (c == 'L')
				locCar.dir = dirCh[3];
			map[locCar.x][locCar.y] = locCar.dir;
			moveGroundCar();
		} else if (c == 'S') {
			shootBomb();
		}
		return map;
	}

	// 평지라면 해당 칸으로 이동하는 함수 - 전차가 옮겨지고 난 이후의 map 반환
	public static void moveGroundCar() {
		int nr = locCar.x + dr[intDirCar(locCar)];
		int nc = locCar.y + dc[intDirCar(locCar)];
		if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] != '#' && map[nr][nc] != '-' && map[nr][nc] != '*') {
			map[locCar.x][locCar.y] = '.';

			locCar.x = nr;
			locCar.y = nc;
			map[nr][nc] = locCar.dir;
		}
	}

	// 폭탄을 쏜 경우
	public static void shootBomb() {
		int dirCar = intDirCar(locCar);
		for (int i = 1; i < Math.max(H, W); i++) {
			int nr = locCar.x + i * dr[dirCar];
			int nc = locCar.y + i * dc[dirCar];

			if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
				if (map[nr][nc] == '#')
					break;
				else if (map[nr][nc] == '*') {
					map[nr][nc] = '.';
					break;
				}
			}

		}
	}
}
