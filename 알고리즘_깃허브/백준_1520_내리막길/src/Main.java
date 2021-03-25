import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int map[][];
	static int dp[][];
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		dp = new int[M][N];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		if(map[0][0] > map[0][1]) dp[0][0]++;
		if(map[0][0] > map[1][0]) dp[0][0]++;
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				for(int d=0;d<4;d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					
					if(nx<0 || nx>=M || ny<0 || ny>=N) continue;
					if(map[i][j] >= map[nx][ny]) continue;
					
					dp[i][j] +=dp[nx][ny];
				}
			}
		}
		
		for(int i=0;i<M;i++) System.out.println(Arrays.toString(dp[i]));
	}
}
