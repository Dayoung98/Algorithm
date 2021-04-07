import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int map[][];
	static ArrayList<Node> list;
	static final int INF = 99999999;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine()); // 편의점의 개수
			map = new int[N + 2][N + 2];
			list = new ArrayList<>();

			for (int i = 0; i < N + 2; i++) {
				for (int j = 0; j < N + 2; j++)
					map[i][j] = INF;
			}

			for (int i = 0; i < N + 2; i++) {
				st = new StringTokenizer(br.readLine());
				list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}

			for (int i = 0; i < N + 2; i++) {
				for (int j = 0; j < N + 2; j++) {
					if (i == j)
						continue;

					Node current = list.get(i);
					Node next = list.get(j);

					int distance = Math.abs(current.x - next.x) + Math.abs(current.y - next.y);
					if (distance <= 1000)
						map[i][j] = 1;
				}
			} // 두 지점 사이의 거리가 1000보다 작거나 같으면 이동할 수 있는 거리임으로 map 배열 바꿔주기

			for (int k = 0; k < N + 2; k++) {// 경유지
				for (int i = 0; i < N + 2; i++) {// 출발지
					for (int j = 0; j < N + 2; j++) {// 도착지
						if (i == j || k == j)
							continue;
						if (map[i][j] > map[i][k] + map[k][j])
							map[i][j] = map[i][k] + map[k][j];
					}
				}
			}

			if (map[0][N + 1] > 0 && map[0][N + 1] < INF)
				System.out.println("happy");
			else
				System.out.println("sad");

		}
	}

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
