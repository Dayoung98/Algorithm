import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,M,H;
	static int map[][][];
	static boolean isVisited[][][];
	static int dx[]= {0,0,0,0,-1,1};
	static int dy[]= {0,0,-1,1,0,0};
	static int dh[] = {-1,1,0,0,0,0};
	static Queue<Node> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][N][M];
		isVisited = new boolean[H][N][M];
		
		for(int h=0;h<H;h++) {
			for(int n=0;n<N;n++) {
				st = new StringTokenizer(br.readLine());
				for(int m=0;m<M;m++) {
					map[h][n][m] = Integer.parseInt(st.nextToken());
					if(map[h][n][m] == 1) { 
						q.offer(new Node(h,n,m));
						isVisited[h][n][m] = true;
					}
				}
			}
		}
		
		bfs();
		
		int max = 0;
		for(int h=0;h<H;h++) {
			for(int n=0;n<N;n++) {
				for(int m=0;m<M;m++) {
					if(map[h][n][m] == 0) {
						System.out.println(-1);
						return;
					}
					max = Math.max(map[h][n][m], max);
				}
			}
		}
		
		System.out.println(max-1);
	}
	static void bfs() {
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int d=0;d<6;d++) {
				int nh = node.H + dh[d];
				int nx = node.N + dx[d];
				int ny = node.M + dy[d];
				
				if(nx<0 || nx>=N || ny<0 || ny>=M || nh<0 || nh>=H  ||isVisited[nh][nx][ny]) continue;
				if(map[nh][nx][ny] !=0) continue;
				
				map[nh][nx][ny] = map[node.H][node.N][node.M]+1;
				isVisited[nh][nx][ny] = true;
				q.add(new Node(nh,nx,ny));
			}
		}
	}
	
	static class Node{
		int H;
		int N;
		int M;
		public Node(int h, int n, int m) {
			super();
			H = h;
			N = n;
			M = m;
		}
	}
}
