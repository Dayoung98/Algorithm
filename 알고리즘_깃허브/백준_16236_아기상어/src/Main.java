import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N; // 공간의 크기
	static int time = 0;
	static int sharkSize = 2; // 현재 아기 상어의 크기
	static int sharkUp = 0; // 상어 크기 만큼 먹었을 때 크기 UP 해주기
	static int map[][];
	static boolean isVisited[][];
	static int shark[]; // 아기 상어 위치 저장할 배열
	static ArrayList<Node> list = new ArrayList<>();
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };
	static Queue<Node> q = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		map = new int[N][N];
		isVisited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9)
					shark = new int[] { i, j }; // 아기상어 위치 입력
				if (map[i][j] >= 1 && map[i][j] <= 6)
					list.add(new Node(i, j, map[i][j])); // 물고기들 위치와 size setting

			}
		} // 배열 입력

		// 이거를 반복하기
		// 더이상 움직일 수 없을 때 까지
		while (true) {
			int num = 0;
			for (int i = 0; i < list.size(); i++) {
				if (sharkSize > list.get(i).size)
					num++;
			}

			if (num == 0 || list.size() ==0)break;
			//사방향 탐색했을 때 길 막혔으면 
			int direction=0;
			for(int d=0;d<4;d++) {
				int nx = shark[0]+dx[d];
				int ny = shark[1]+dy[d];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
				if(map[nx][ny] <= sharkSize) direction++; //길 지나갈 수 있음
			}
			
			if(direction == 0)break;

			Node getMin = new Node(0, 0,Integer.MAX_VALUE);
			int idx = 0;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).size >= sharkSize) continue;

				isVisited = new boolean[N][N];
				q.offer(new Node(list.get(i).x, list.get(i).y, 0));
				int size = Integer.MAX_VALUE;

				while (!q.isEmpty()) {
					Node node = q.poll();

					for (int d = 0; d < 4; d++) {
						int nx = node.x + dx[d];
						int ny = node.y + dy[d];

						if (nx < 0 || nx >= N || ny < 0 || ny >= N || isVisited[nx][ny])
							continue;
						if (map[nx][ny] == 9) {
							size = (size>node.size+1)?node.size+1:size;
							break;
						}
						if (map[nx][ny] > sharkSize)
							continue;

						isVisited[nx][ny] = true;
						q.offer(new Node(nx, ny, node.size + 1));
					}

				}
				q.clear();
				// 최단 거리 구했음
				if (getMin.size > size) { //내가 현재 구한 거리가 최소값보다 작으면 갱신
					getMin = new Node(list.get(i).x, list.get(i).y, size);
					idx = i;
				} else if (getMin.size == size) { //최소값이 같으면
					if (getMin.x > list.get(i).x) {//더 위에 있는거
						getMin = new Node(list.get(i).x, list.get(i).y, size);
						idx = i;
					} else if (getMin.x == list.get(i).x && getMin.y > list.get(i).y) { //더 왼쪽에 있는거
						getMin = new Node(list.get(i).x, list.get(i).y, size);
						idx = i;
					}
				}
			}
			if(getMin.size == Integer.MAX_VALUE) getMin.size = 0;
			if(getMin.size != 0) {
				time += getMin.size;
				map[getMin.x][getMin.y] = 0;
				map[shark[0]][shark[1]] =0;
				map[getMin.x][getMin.y] = 9;
				shark[0] = getMin.x;
				shark[1] = getMin.y;
				sharkUp++;
			}
			list.remove(idx); // 리스트에 있는 물고기 하나 지워주고

			if (sharkSize == sharkUp) { // 먹은 개수랑 사이즈랑 똑같아 지면 크기 키워주기
				sharkSize++;
				sharkUp = 0;
			}
			
		}
		// 현재 리스트 중에서 제일 가꺼운거 자리 구하기
		System.out.println(time);
	}


	static class Node {
		int x;
		int y;
		int size;

		public Node(int x, int y, int size) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
		}
	}
}