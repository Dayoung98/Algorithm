import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Solution {
	// 상0 하1 좌2 우3
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static char[][] map;
	static int h;
	static int w;
	public static void print() {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트 케이스 T
		int T = Integer.parseInt(br.readLine());
		for (int times = 1; times <= T; times++) {
			String[] str1 = br.readLine().split(" ");
			// 높이 height -> 행
			h = Integer.parseInt(str1[0]);
			// 넓이 weight ->열
			w = Integer.parseInt(str1[1]);

			// 전차 자리 기억
			int x = 0, y = 0;

			// map 초기화
			map = new char[h][w];
			for (int i = 0; i < h; i++) {
				String str2 = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = str2.charAt(j);
					if (map[i][j] == '<' || map[i][j] == '>' || map[i][j] == 'v' || map[i][j] == '^') {
						y = i;
						x = j;
					}

				}
			}

			// 입력 개수 n
			int n = Integer.parseInt(br.readLine());
			String cases = br.readLine();
			// 전차 이동 및 파괴시작
			for (int i = 0; i < n; i++) {
				// Shoot일때
				if (cases.charAt(i) == 'S') {
					if (map[y][x] == '<') {
						for (int k = x - 1; k > -1; k--) {
							if (map[y][k] == '*') {
								map[y][k] = '.';
								break;
							}
							if (map[y][k] == '#') {
								break;
							}
						}
					} else if (map[y][x] == '>') {
						for (int k = x; k < w; k++) {
							if (map[y][k] == '*') {
								map[y][k] = '.';
								break;
							}
							if (map[y][k] == '#') {
								break;
							}
						}
					} else if (map[y][x] == 'v') {
						for (int k = y; k < h; k++) {
							if (map[k][x] == '*') {
								map[k][x] = '.';
								break;
							}
							if (map[k][x] == '#') {
								break;
							}
						}
					} else if (map[y][x] == '^') {
						for (int k = y; k > -1; k--) {
							if (map[k][x] == '*') {
								map[k][x] = '.';
								break;
							}
							if (map[k][x] == '#') {
								break;
							}
						}
					}
				}
				// 이동할때
				// 상0 하1 좌2 우3
				if (cases.charAt(i) == 'R') {
					//map안에 있을때
					
					if(x+dx[3]>=0 && x+dx[3]<w && y+dy[3]>=0 && y+dy[3]<h) {
						if(map[y+dy[3]][x+dx[3]]!='-'&& map[y+dy[3]][x+dx[3]]!='#'&& map[y+dy[3]][x+dx[3]]!='*') {
							map[y][x]='.';
							x=x+dx[3];
							y=y+dy[3];
						}
					}
					map[y][x]='>';
				}
				if (cases.charAt(i) == 'L') {
					if(x+dx[2]>=0 && x+dx[2]<w && y+dy[2]>=0 && y+dy[2]<h) {
						if(map[y+dy[2]][x+dx[2]]!='-'&&map[y+dy[2]][x+dx[2]]!='#'&&map[y+dy[2]][x+dx[2]]!='*') {
							map[y][x]='.';
							x=x+dx[2];
							y=y+dy[2];
						}
					}
					map[y][x]='<';
				}
				if (cases.charAt(i) == 'U') {
					if(x+dx[0]>=0 && x+dx[0]<w && y+dy[0]>=0 && y+dy[0]<h) {
						if(map[y+dy[0]][x+dx[0]]!='-'&&map[y+dy[0]][x+dx[0]]!='#'&&map[y+dy[0]][x+dx[0]]!='*') {
							map[y][x]='.';
							x=x+dx[0];
							y=y+dy[0];
						}
					}
					map[y][x]='^';
				}
				if (cases.charAt(i) == 'D') {
					
					if(x+dx[1]>=0 && x+dx[1]<w && y+dy[1]>=0 && y+dy[1]<h) {
						if(map[y+dy[1]][x+dx[1]]!='-'&&map[y+dy[1]][x+dx[1]]!='#'&&map[y+dy[1]][x+dx[1]]!='*') {
							map[y][x]='.';
							x=x+dx[1];
							y=y+dy[1];
						}
					}
					map[y][x]='v';
				}
			}
			//이후 값 출력
			System.out.print("#"+times+" ");
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

		}

	}

}

