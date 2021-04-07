import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 벼의 개수
		int arr[] = new int[N];
		boolean isVisited[] = new boolean[N];
		int dp[] = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int left = 0;
		int right = N - 1;
		int k = 1;
		int result = 0;
		// System.out.println(Arrays.toString(arr));

	}

}
