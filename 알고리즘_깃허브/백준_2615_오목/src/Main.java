import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int map[][];
	static int result[] = new int[3];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		map = new int[19][19];
		for (int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean flag = check();
		if (flag) {
			System.out.println(result[0]);
			System.out.println((result[1] + 1) + " " + (result[2] + 1));
		} else
			System.out.println(0);
	}

	static boolean check() {

		int count = 0;

		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (map[i][j] == 0)
					continue;
				// 바둑돌이 놓여져 있으면

				int win = map[i][j];
				// 위
				int row = i;
				while (true) {
					if (row < 0 || map[row][j] != win)
						break;
					row--;
					count++;
				}
				if (count == 5) {
					result[0] = win;
					result[1] = i;
					result[2] = j;
					return true;
				}

				// 아래
				count = 0;
				row = i;
				while (true) {
					if (row >= 19 || map[row][j] != win)
						break;
					count++;
					row++;
				}
				if (count == 5) {
					result[0] = win;
					result[1] = i;
					result[2] = j;
					return true;
				}

				// 오른쪽 대각선
				count = 0;
				row = i;
				int col = j;
				while (true) {
					if (row >= 19 || col >= 19 || map[row][col] != win)
						break;
					row++;
					col++;
					count++;
				}
				if (count == 5) {
					result[0] = win;
					result[1] = i;
					result[2] = j;
					return true;
				}

				// 왼쪽 대각선
				count = 0;
				row = i;
				col = j;
				while (true) {
					if (row >= 19 || col < 0 || map[row][col] != win)
						break;
					row++;
					col--;
					count++;
				}

				if (count == 5) {
					result[0] = win;
					result[1] = i;
					result[2] = j;
					return true;
				}
			}
		}
		return false;
	}
}