import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static int F;
	static int parents[];
	static int cnt[];
	static HashMap<String, Integer> map;

	static void make() {
		parents = new int[F*2];
		cnt = new int[F*2];
		
		for(int i=0;i<F*2;i++)
			parents[i] = i;
		Arrays.fill(cnt, 1);
	}

	static int findSet(int a) {
		if (parents[a] == a)
			return a;

		return parents[a] = findSet(parents[a]);
	}

	static int union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);

		if (aRoot == bRoot)
			return cnt[aRoot];

		if (aRoot > bRoot) {
			parents[bRoot] = aRoot;
			cnt[aRoot] += cnt[bRoot];
			return cnt[aRoot];
		} else {
			parents[aRoot] = bRoot;
			cnt[bRoot] += cnt[aRoot];
			return cnt[bRoot];
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) { // 테스트 케이스

			F = Integer.parseInt(br.readLine()); // 친구관계
			map = new HashMap<>();
			make();
			
			int idx = 0;
			
			for (int f = 0; f < F; f++) {
				st = new StringTokenizer(br.readLine());

				String name1 = st.nextToken();
				String name2 = st.nextToken();
				
				// 키가 맵에 존재하면 pass//존재하지 않으면 넣어주기
				if (!map.containsKey(name1)) {
					map.put(name1, idx++);
				}
				if (!map.containsKey(name2)) {
					map.put(name2, idx++);
				}

				System.out.println(union(map.get(name1), map.get(name2)));
				// cnt배열은
			}
		}
	}

	static class Node {
		String name;
		int cnt;

		public Node(String name, int cnt) {
			super();
			this.name = name;
			this.cnt = cnt;
		}
	}
}
