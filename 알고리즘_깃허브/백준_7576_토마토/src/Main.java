import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
//https://www.acmicpc.net/problem/7576
	static int N,M;
	static int map[][];
	static boolean isVisited[][];
	static int time;
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	static Queue<Node> q = new LinkedList<>();
	static ArrayList<Node> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		isVisited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) list.add(new Node(i,j)); //토마토 위치 저장할 ArrayList
			}
		} 
		
		//1은 익은 토마토 0은 익지않은 토마도 -1을 토마토가 들어있지않은 칸
		//토마토는 한꺼번에 익는다
		//토마토 칸 하나당 bfs?
		
		//list마다 계속 옆으로 움직이면서 map[1][1]로 채워주고 그 1짜리 또 가고 ,,,이런식으로?
		q.offer(new Node(list.get(0).row,list.get(0).col));
		bfs();
		
	}
	
	static void bfs(int row,int col) {
	
		
		for(int d=0;d<4;d++) {
			int nx = row + dx[d];
			int ny = row + dy[d];
			
			if(nx<0 || nx>=N || ny<0 || ny>M  || isVisited[nx][ny] || map[nx][ny] != -1) continue; //지나갈 수 없는 길
			
			isVisited[nx][ny] = true;
			q.offer(new Node(nx,ny));
		}
		time++;
	}
	
	static class Node{
		int row;
		int col;
		public Node(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
}
