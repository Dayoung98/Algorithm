import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int F;
	static ArrayList<Node> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		
		for(int t=0;t<T;t++) {
			
			F = Integer.parseInt(br.readLine());
			
			for(int f=0;f<F;f++) {
				st = new StringTokenizer(br.readLine());
				
				String name1 = st.nextToken();
				String name2 = st.nextToken();
			}
		}
	}
	

	static class Node{
		String name;
		int cnt;
		public Node(String name, int cnt) {
			super();
			this.name = name;
			this.cnt = cnt;
		}
	}
}
