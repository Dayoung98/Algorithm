import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,M,K;
	static int parents[];
	static int money[];
	
	static void make() {
		for(int i=1;i<N+1;i++) parents[i] = i;
	}
	
	static int findSet(int a) {
		if(parents[a] == a) return a;
		
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a,int b) {
		//노드끼리 합칠 때 가장 최소비용인 루트로 합치기
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false;
		
		if(money[aRoot]>money[bRoot]) {
			//비루트로 통힐해주기
			parents[aRoot] = bRoot;
			for(int i=1;i<N+1;i++) {
				if(parents[i] == aRoot) parents[i] = bRoot;
			}
		}
		else {
			parents[bRoot] = aRoot;
			for(int i=1;i<N+1;i++) {
				if(parents[i] == bRoot) parents[i] = aRoot;
			}
		}

		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //학생 수
		M = Integer.parseInt(st.nextToken()); //친구관계 수
		K = Integer.parseInt(st.nextToken()); //준석이가 가지고 있는 돈
		
		parents = new int[N+1];
		money = new int[N+1]; //친구가 되는데 드는 비용
		
		make();
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<N+1;i++) money[i] = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int friend1 = Integer.parseInt(st.nextToken());
			int friend2 = Integer.parseInt(st.nextToken());
			
			union(friend1, friend2);
		}
		
		boolean isVisited[] = new boolean[N+1];
		
		for(int i=1;i<N+1;i++) isVisited[parents[i]] = true;
		
		int sum = 0;
		for(int i=1;i<N+1;i++) {
			if(isVisited[i]) sum += money[i]; 
		}
		
		if(sum<= K) System.out.println(sum);
		else System.out.println("Oh no");
	}
}
