import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int map[][];
	static boolean isVisited[][];
	static int result = Integer.MAX_VALUE;
	static Queue<Node> q = new LinkedList<>();
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		isVisited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j=0;j<M;j++) map[i][j] = str.charAt(j)-'0';
		}
		
		q.offer(new Node(0,0,1));
		bfs();
		System.out.println(result);
	}
	
	static void bfs() {
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int d=0;d<4;d++) {
				int nx = node.x + dx[d];
				int ny = node.y + dy[d];
				
				if(nx<0 || nx>=N || ny<0 || ny>=M || isVisited[nx][ny] || map[nx][ny]==0) continue;
				if(nx == N-1 && ny == M-1) {
					int len = node.weight+1;
					result = Math.min(len, result);
				}
				isVisited[nx][ny] = true;
				q.offer(new Node(nx,ny,node.weight+1));
			}

		}
	}
	
	static class Node{
		int x;
		int y;
		int weight;
		public Node(int x, int y, int weight) {
			super();
			this.x = x;
			this.y = y;
			this.weight = weight;
		}
	}
}
