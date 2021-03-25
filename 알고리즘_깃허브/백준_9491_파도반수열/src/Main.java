import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			long P[] = new long[N + 1];
			if (N >= 1)
				P[1] = 1;
			if (N >= 2)
				P[2] = 1;
			if (N >= 3)
				P[3] = 1;
			if (N >= 4)
				P[4] = 2;
			if (N >= 5)
				P[5] = 2;

			for (int i = 6; i <= N; i++) {
				P[i] = (P[i - 1] + P[i - 5]);
			}

			System.out.println(P[N]);
		}

	}
}
