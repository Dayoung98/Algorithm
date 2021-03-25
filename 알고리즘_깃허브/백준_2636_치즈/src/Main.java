import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

	static int N,M;
	static int map[][];
	static int temp[][];
	static boolean isVisited[][];
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	static Queue<Node> q = new LinkedList<>();
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		temp = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		while(true) {
			//치즈가 다 녹을 때 까지 계속하기.
			isVisited = new boolean[N][M];
			
			result ++;
			temp = Arrays.copyOf(map, map.length);
			for(int i=1;i<N-1;i++) {
				for(int j=1;j<M-1;j++) {
					if(map[i][j] == 1) cheese(i,j);
				}
			}//녹을 치즈 구하기
			
			while(!q.isEmpty()) {
				Node node = q.poll();
				map[node.x][node.y] = 0;
			}//0으로 만들어주기
			
			// 다 0 이면
			int cnt = 0;
			for(int i=1;i<N-1;i++) {
				for(int j=1;j<M-1;j++) {
					if(map[i][j] == 0) cnt++;
				}
			}
			
			if(cnt == (N-1)*(M-1)) {
				System.out.println(result);
				//temp의  칸의 개수
				int num = 0;
				for(int i=1;i<N-1;i++) {
					for(int j=1;j<M-1;j++) {
						if(temp[i][j] == 1) num++;
					}
				}
				System.out.println(num);
				break;
			}
			
		}
				
	}
	
	static void cheese(int row,int col) {
		//녹는 치즈
		//사방향 중ㅇ에 하나라도 0이있으면 녹음
		for(int d=0;d<4;d++) {
			int nx = row + dx[d];
			int ny = col + dy[d];
			
			if(nx<0 || nx>N || ny<0 || ny>M) continue;
			
			if(map[nx][ny] == 0) {
				isVisited[nx][ny] = true;
				q.offer(new Node(nx,ny));
				break;
			}
		}
	}
	
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
