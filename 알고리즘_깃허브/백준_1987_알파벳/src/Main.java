import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R,C;
	static char[][] map;
	static boolean isVisited[];
	static int maxLen = Integer.MIN_VALUE;
	static int len = 0;
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		//A는 97 알파벳은 26개
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for(int i=0;i<R;i++) 
			map[i] = br.readLine().toCharArray();
		
/*		for(int i=0;i<R;i++)
			System.out.println(Arrays.toString(map[i]));*/
		/*for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				getLength(i,j);
				System.out.println("("+i+","+j+") 위치에서의 max :"+maxLen);
			}
		}
		*/
		//getLength(0, 0);
		isVisited = new boolean[26];
		isVisited[map[0][0]-'A'] = true;
		dfs(0,0);
		System.out.println(maxLen);
	}
	
	private static boolean dfs(int row,int col) {
		//시작지점은 (0,0)
		//System.out.println("row:"+row+" col:"+col);
		//기저조건??
		for(int d=0;d<4;d++) {
			int nx = row + dx[d];
			int ny = col + dy[d];
			//System.out.println("nx :"+nx+" ny:"+ny);
			if(nx<0 || nx>=R || ny<0 || ny>=C || isVisited[map[nx][ny]-'A']) continue; //범위 벗어남
			
			isVisited[map[nx][ny]-'A'] = true;
			//System.out.println(map[nx][ny]);
			dfs(nx,ny);
			isVisited[map[nx][ny]-'A'] = false; //다음에 올 사람 위해서 false로 바꿔주기
		}
		len = 0;
		for(int i=0;i<26;i++)
			if(isVisited[i]) len++;
		maxLen = (maxLen<len)?len:maxLen;
		return false; //방향을 다 타고 들어갔지만 재귀를 타고 들어가지 못함
	}

/*	private static void getLength(int row,int col) {
		Queue<Node> q = new LinkedList<>(); //bfs 돌릴 큐
		isVisited = new boolean[26]; //방문했는지 안했는지
		
		q.offer(new Node(row,col)); //현재 값 넣어주기
		isVisited[map[row][col]-'A'] = true;
		int num = 1; //말이 지나는 칸은 좌측 상단의 값도 포함!
		
		while(!q.isEmpty()) {
			row = q.peek().x;
			col = q.peek().y;
			q.poll();
			for(int d=0;d<4;d++) {
				//사방 탐색
				int nx = row + dx[d];
				int ny = col + dy[d];
				
				if(nx<0 || nx>=R || ny<0 || ny>=C) continue; //범위 벗어나면 튀튀
				if(!isVisited[map[nx][ny]-'A']) {
					//현재 칸에 있는 알파벳이 지나치지 않은 곳이라면
					num++;
					isVisited[map[nx][ny]-'A'] = true; //방문 처리 해주고
					System.out.print(map[nx][ny]+" ");
					q.offer(new Node(nx,ny));
				}
				
			}
		}
		maxLen = maxLen<num?num:maxLen;
	}

	
	private static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}*/
}
