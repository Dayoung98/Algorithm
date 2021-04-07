import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	static Node[] nodes, lines;
	static int[] parents;

	static class Node implements Comparable<Node> {
		int x, y;
		long p;

		private Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.p, o.p);
		}
	}

	static int find(int a) {
		if (parents[a] < 0)
			return a;
		return parents[a] = find(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			double ans = 0;
			int n = Integer.parseInt(br.readLine());
			parents = new int[n];
			nodes = new Node[n];
			lines = new Node[n * n];
			String[] tmpX = br.readLine().split(" ");
			String[] tmpY = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				nodes[i] = new Node(Integer.parseInt(tmpX[i]), Integer.parseInt(tmpY[i]));
			}
			double e = Double.parseDouble(br.readLine());

			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					lines[cnt] = new Node(i, j);
					lines[cnt++].p = (long) (nodes[i].x - nodes[j].x) * (nodes[i].x - nodes[j].x)
							+ (long) (nodes[i].y - nodes[j].y) * (nodes[i].y - nodes[j].y);
				}
			}
			Arrays.sort(lines);
			Arrays.fill(parents, -1);

			for (int i = 0; i < lines.length; i++) {
				Node cur = lines[i];
				if (cur.p == 0)
					continue;
				if (union(cur.x, cur.y)) {
					ans += cur.p;
				}
			}
			ans *= e;
			System.out.println("#" + (t + 1) + " " + Math.round(ans));
		}
	}
}