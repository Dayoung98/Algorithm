import java.util.Scanner;

// BOJ 2615 : ����
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
		// �ַ��
		solve();
		// ���
		System.out.println(player);
		if (player != 0) {
			System.out.println(x + " " + y);
		}

	}

	static void solve() {
		// ��� ����(����ȭ, 19,19 15;

		for (int i = 1; i <= 19; i++) {
			for (int j = 1; j <= 19; j++) {
				// ���̰ų� �������̸� ���� �Ǵ�
				// ��������� ����(������������)
				if (map[i][j] == 0) {
					continue;
				}
				// �ַ��
				// �Ʒ�, �����ʾƷ�, ������, ������ ��
				int cnt = 1;
				int k = 1;
				// �Ʒ�
				if (map[i][j] != map[i - 1][j]) { // �������� ���� �ʴٸ� ���ɼ�
					while (map[i][j] == map[i + k][j]) {
						k++;
						cnt++;
					}
				}
				// ���� �Ǵ�
				if (cnt == 5) {
					player = map[i][j];
					x = i;
					y = j;
					return;
				}
				// �����ʾƷ�
				cnt = 1;
				k = 1;
				if (map[i][j] != map[i - 1][j - 1]) { // �������� ���� �ʴٸ� ���ɼ�
					while (map[i][j] == map[i + k][j + k]) {
						k++;
						cnt++;
					}
				}
				// ���� �Ǵ�
				if (cnt == 5) {
					player = map[i][j];
					x = i;
					y = j;
					return;
				}
				// ������
				cnt = 1;
				k = 1;
				if (map[i][j] != map[i][j - 1]) { // �������� ���� �ʴٸ� ���ɼ�
					while (map[i][j] == map[i][j + k]) {
						k++;
						cnt++;
					}
				}
				// ���� �Ǵ�
				if (cnt == 5) {
					player = map[i][j];
					x = i;
					y = j;
					return;
				}
				// ������ �� �밢��
				cnt = 1;
				k = 1;
				if (map[i][j] != map[i + 1][j - 1]) { // �������� ���� �ʴٸ� ���ɼ�
					while (map[i][j] == map[i - k][j + k]) {
						k++;
						cnt++;
					}
				}
				// ���� �Ǵ�
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