import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M,V;
	static List<Integer>[] list;
	static boolean isVisited[];
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		
		for(int i=1;i<N+1;i++) list[i] = new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list[from].add(to);
			list[to].add(from);
		}
		
		for(int i=1;i<N+1;i++) Collections.sort(list[i]);
		
		isVisited = new boolean[N+1];
		sb = new StringBuilder();
		sb.append(V+" ");
		dfs(V);
		System.out.println(sb);
		
		isVisited = new boolean[N+1];
		sb = new StringBuilder();
		sb.append(V+" ");
		bfs(V);
		System.out.println(sb);
		
	}
	
	static void dfs(int v) {
		isVisited[v] = true;
		
		int size = list[v].size();
		for(int i=0;i<size;i++) {
			int num = list[v].get(i);
	
			if(!isVisited[num]) {
				sb.append(num+" ");
				isVisited[num] = true;
				dfs(num);
				
			}
		}
	}
	
	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		isVisited[v] = true;
		
		while(!q.isEmpty()) {
			int num = q.poll();
			
			int size = list[num].size();
			for(int i=0;i<size;i++) {
				int number = list[num].get(i);
				if(!isVisited[number]) {
					sb.append(number+" ");
					isVisited[number] = true;
					q.offer(number);
				}
			}
		}
	}

}
