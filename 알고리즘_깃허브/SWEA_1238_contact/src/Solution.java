import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N, V;
	static List<Integer> list[];
	static boolean isVisited[];
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 0; t < 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());

			list = new ArrayList[101];
			isVisited = new boolean[101];
			for (int i = 1; i < 101; i++)
				list[i] = new ArrayList<>();

			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				list[from].add(to);
			}
			max = 0;
			bfs();
			System.out.println("#"+(t+1)+" "+max);

		}
	}

	static void bfs() {
		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[] { V, 1 }); // 현재 시작 노드 넣어줌
		int cnt = 0;

		while (!q.isEmpty()) {
			int arr[] = q.poll();
			int start = arr[0];

			int size = list[start].size();
			for (int i = 0; i < size; i++) {
				int next = list[start].get(i);

				if (!isVisited[next]) {
					isVisited[next] = true;
					q.offer(new int[] { next, arr[1] + 1 });
				}
			}

			// max 값 구하기
			if (arr[1] > cnt) {// 지금부터 마지막에 도착한 애면
				max = arr[0];
				cnt = arr[1];
			}
			else if (arr[1] == cnt) {
				max = Math.max(max, arr[0]);
			}
		}
	}
}
