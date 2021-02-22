import java.util.Scanner;

// BOJ 2615 : 오목
public class Main {

	static int player = 0;
	static int x, y;
	static int[][] map = new int[19 + 2][19 + 2];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 19; i++) {
			for (int j = 1; j <= 19; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		// 솔루션
		solve();
		// 출력
		System.out.println(player);
		if (player != 0) {
			System.out.println(x + " " + y);
		}

	}

	static void solve() {
		// 모든 정점(최적화, 19,19 15;

		for (int i = 1; i <= 19; i++) {
			for (int j = 1; j <= 19; j++) {
				// 흰돌이거나 검은돌이면 오목 판단
				// 비워있으면 무시(유망도가없다)
				if (map[i][j] == 0) {
					continue;
				}
				// 솔루션
				// 아래, 오른쪽아래, 오른쪽, 오른쪽 위
				int cnt = 1;
				int k = 1;
				// 아래
				if (map[i][j] != map[i - 1][j]) { // 기존돌과 같지 않다면 가능성
					while (map[i][j] == map[i + k][j]) {
						k++;
						cnt++;
					}
				}
				// 오목 판단
				if (cnt == 5) {
					player = map[i][j];
					x = i;
					y = j;
					return;
				}
				// 오른쪽아래
				cnt = 1;
				k = 1;
				if (map[i][j] != map[i - 1][j - 1]) { // 기존돌과 같지 않다면 가능성
					while (map[i][j] == map[i + k][j + k]) {
						k++;
						cnt++;
					}
				}
				// 오목 판단
				if (cnt == 5) {
					player = map[i][j];
					x = i;
					y = j;
					return;
				}
				// 오른쪽
				cnt = 1;
				k = 1;
				if (map[i][j] != map[i][j - 1]) { // 기존돌과 같지 않다면 가능성
					while (map[i][j] == map[i][j + k]) {
						k++;
						cnt++;
					}
				}
				// 오목 판단
				if (cnt == 5) {
					player = map[i][j];
					x = i;
					y = j;
					return;
				}
				// 오른쪽 위 대각선
				cnt = 1;
				k = 1;
				if (map[i][j] != map[i + 1][j - 1]) { // 기존돌과 같지 않다면 가능성
					while (map[i][j] == map[i - k][j + k]) {
						k++;
						cnt++;
					}
				}
				// 오목 판단
				if (cnt == 5) {
					player = map[i][j];
					x = i;
					y = j;
					return;
				}
			}
		}
		return;
	}

}