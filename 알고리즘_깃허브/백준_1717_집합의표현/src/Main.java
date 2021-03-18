import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int parents[];
	
	static void make() {
		for(int i=0;i<=N;i++) parents[i] = i;
	}
	
	static int findSet(int a) {
		
		if(parents[a] == a) return a;
		
		return parents[a] = findSet(parents[a]);
	}
	static boolean union(int a,int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parents = new int[N+1];
		make();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			//합집합은 9
			//두 원소가 같은 집합에 포합되어 있는지는 1
			
			int n = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(n == 0) union(a, b);
			else {
				if(findSet(a) == findSet(b)) System.out.println("YES");
				else System.out.println("NO");
			}
		}
	}
}
