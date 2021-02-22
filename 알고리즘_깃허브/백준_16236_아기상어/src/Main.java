import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int time=0;
	static int sharkSize = 2;
	static int map[][];
	static int shark[];
	static ArrayList<Node> list = new ArrayList<>();
	static Node fish[];
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9)
					shark = new int[] {i,j}; //아기 상어 값
				if(map[i][j]>=1 && map[i][j]<=6)
					list.add(new Node(i,j,map[i][j])); //물고기 좌표랑 사이즈 setting
			}
		} //지도 입력
		
		fish = new Node[list.size()];
		for(int i=0;i<list.size();i++)
			fish[i] = new Node(list.get(i).x,list.get(i).y,list.get(i).size);

		Arrays.sort(fish);

		if(list.size() == 0)
			System.out.println(0);
		
		//bfs로 찾기
	}
	
	static void bfs() {
		
	}
	
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int size;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		public Node(int x, int y, int size) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
		}
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.size-o.size;
		}
		
	/*	@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", size=" + size + "]";
		}*/
	
	}
}
