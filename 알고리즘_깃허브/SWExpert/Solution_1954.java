import java.util.Scanner;

public class Solution_1954 {

	private static int N;
	private static int T;
	private static int arr[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			arr = new int[N][N];

			int number = 1;

			int row = 0, col = 0;
			int dir = 1;

			while (number <= N * N) {
				if (dir == 1) {// ©Л
					while (true) {
						if (col >= N || arr[row][col] != 0) {
							col = col - 1;
							row = row + 1;
							dir = 2;
							break;
						}
						arr[row][col] = number++;
						col = col + 1;

					}
				} else if (dir == 2) {// го
					while (true) {
						if (row >= N || arr[row][col] != 0) {
							row = row - 1;
							col = col - 1;
							dir = 3;
							break;
						}
						arr[row][col] = number++;
						row = row + 1;

					}
				} else if (dir == 3) {// аб
					while (true) {
						if (col < 0 || arr[row][col] != 0) {
							col = col + 1;
							row = row - 1;
							dir = 4;
							break;
						}
						arr[row][col] = number++;
						col = col - 1;
					}
				} else {
					while (true) {// ╩С
						if (row < 0 || arr[row][col] != 0) {
							row = row + 1;
							col = col + 1;
							dir = 1;
							break;
						}
						arr[row][col] = number++;
						row = row - 1;
					}
				}
			}
			System.out.println("#" + t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					System.out.print(arr[i][j] + " ");
				System.out.println();
			}
		}

	}// tc

}
