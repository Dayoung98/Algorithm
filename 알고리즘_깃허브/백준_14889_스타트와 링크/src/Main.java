import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int map[][];
	static boolean isVisited[];
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		isVisited = new boolean[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		//무조건 N/2명?
		dfs(0,0);
		System.out.println(result);
	}
	
	static void dfs(int idx,int cnt) {
		if(result == 0) return;
		if(cnt == (N/2)) { //계산
			calc();
			return;
		}
		
		for(int i=idx;i<N;i++) {
			if(!isVisited[i]) {
				isVisited[i] = true;
				dfs(i,cnt+1);
				isVisited[i] = false;
			}
			
		}
		
		
	}
	
	static void calc() {
		int start[] = new int[N/2];
		int link [] = new int[N/2];
		int start_idx=0;
		int link_idx=0;
		int start_sum=0;
		int link_sum = 0;
		
		for(int i=0;i<N;i++) {
			if(isVisited[i]) start[start_idx++] = i;
			else link[link_idx++] =i;
		}
		
		for(int i=0;i<N/2;i++) {
			for(int j=i+1;j<N/2;j++) {
				if(i == j) continue;
				
				int start_x = start[i];
				int start_y = start[j];
				
				start_sum +=( map[start_x][start_y] + map[start_y][start_x]);
				
				start_x = link[i];
				start_y = link[j];
				
				link_sum +=(map[start_x][start_y]+map[start_y][start_x]);
			}
		}
		
		result = Math.min(result, Math.abs(start_sum-link_sum));
	}
}
