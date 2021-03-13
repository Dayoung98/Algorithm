import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	static int T;
	static int N,K;
	static int map[][];
	static boolean isVisited[][];
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	static int res;
	static Stack<Node> stack;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		for(int t=0;t<T;t++) {
			res = 0;
			stack = new Stack<>();
				
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			isVisited = new boolean[N][N];
			
			int max = 0;
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]> max) {
						stack.clear();
						stack.push(new Node(i,j));
						max = map[i][j];
					}
					else if(map[i][j] == max) stack.push(new Node(i,j));
				}
			}//등산로 입력
			
			
			while(!stack.isEmpty()) {
				Node node = stack.pop();
				isVisited[node.x][node.y] = true;
				dfs(node.x,node.y,0,1);
				isVisited[node.x][node.y] = false;
				
			}
			
			System.out.println("#"+(t+1)+" "+res);
		}
	}

	static void dfs(int row,int col,int num,int len) {
		
		res = Math.max(res, len);
		
		for(int d=0;d<4;d++) {
			int nx = row + dx[d];
			int ny = col + dy[d];
			
			if(nx<0 || nx>=N || ny<0 || ny>=N || isVisited[nx][ny]) continue;
			
			//현재 입력받은 위치 보다 갈 곳의 위치가 높거나 같다면 줄여주기
			if(map[nx][ny]>= map[row][col]) {
				if(num ==0) {
					for (int i = 1; i <= K; i++) {
						int number = map[nx][ny];
						int land = map[nx][ny] - i;

						if (map[row][col] > land) {
							isVisited[nx][ny] = true;
							map[nx][ny] = land;
							dfs(nx, ny, ++num, ++len);
							map[nx][ny] = number;
							isVisited[nx][ny] = false;
							
						}
					}
				}
				
			}
			else {
				isVisited[nx][ny] = true;
				dfs(nx,ny,num,++len);
				isVisited[nx][ny] = false;
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
