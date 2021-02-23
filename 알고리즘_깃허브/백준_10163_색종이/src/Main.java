import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int map[][] = new int[101][101];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Queue<Node> q = new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine()); //색종이 몇장인지
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			q.offer(new Node(x,y,width,height));
//			q.offer(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			
			for(int row = x;row<x+width;row++) {
				for(int col = y;col<y+height;col++) map[row][col] = (i+1);
			}
		}//일단 색종이 입력
		
		for(int i=0;i<N;i++) {
			int sum = 0;
			Node node = q.poll();
			
			for(int row=node.x;row<(node.x+node.width);row++) {
				for(int col = node.y;col<(node.y+node.height);col++) {
					if(map[row][col] == (i+1)) sum++;
				}
			}
			
			System.out.println(sum);
		}
			
		//가장 왼쪽아래에 있는 좌표와 너비 높이를 차례로 입력받는다.
	}
	
	static class Node{
		int x;
		int y;
		int width;
		int height;
		public Node(int x, int y, int width, int height) {
			super();
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
		}
	}
}
