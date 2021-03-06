import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int N;
	static char map[][];
	static boolean isVisited[][];
	static Queue<Node> q = new LinkedList<>();
	static ArrayList<Integer> list = new ArrayList<>();
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		isVisited = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!isVisited[i][j] && map[i][j]=='1') {
					q.offer(new Node(i,j));
					bfs(i,j);
				}
			}
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for(int i=0;i<list.size();i++) {
			if(list.get(i) == 0) System.out.println("1");
			else System.out.println(list.get(i));
		}
		
	}
	
	static void bfs(int row,int col) {
		int count =0;
		while(!q.isEmpty()) {
			Node n = q.poll();
			for(int d=0;d<4;d++) {
				int nx = n.row + dx[d];
				int ny = n.col + dy[d];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N || isVisited[nx][ny] || map[nx][ny]=='0') continue;
				
				isVisited[nx][ny] = true;
				q.offer(new Node(nx,ny));
				count++;
			}
		}
		list.add(count);
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
