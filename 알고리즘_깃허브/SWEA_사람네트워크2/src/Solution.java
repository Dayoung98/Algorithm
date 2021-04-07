import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static final int INF = 9999999;
	static int N;
	static int map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i!=j && map[i][j]==0) map[i][j] = INF;
				}
			}
			
			for(int k=0;k<N;++k) {
				for(int i=0;i<N;++i) {
					if(i ==k) continue;
					for(int j=0;j<N;++j) {
						if(i==j || k==j) continue; //경유지와 목적지가 같거나 목적지와 출발지가 같은 경우
						if(map[i][j]>map[i][k]+map[k][j]) {
							map[i][j] = map[i][k] + map[k][j];
						}
					}
				}
			}
			
			System.out.println("#"+(t+1)+" "+getResult());
		}
	}
	
	static int getResult() {
		int res = Integer.MAX_VALUE;
		
		for(int i=0;i<N;i++) {
			int sum = 0;
			for(int j=0;j<N;j++) {
				sum += map[i][j];
			}
			res = Math.min(res, sum);
		}
		
		return res;
	}
}
