import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int dx[] = {-1,-1,-1,0,1,1,1,0};
	static int dy[] = {-1,0,1,1,1,0,-1,-1};
	static char map[][];
	static int result = 0;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st;
			map = new char[N][N];
			result = 0;
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++)
					map[i][j] = st.nextToken().charAt(0);
			}
/*			for(int i=0;i<N;i++)
				System.out.println(Arrays.toString(map[i]));*/

			int sum = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j] == 'W')
						sum = find(i,j);
					result = Math.max(sum, result);
				}
			}
			
			System.out.println("#"+t+" "+result);
		}
	}
	
	static int find(int row,int col) {
		int sum = 0;
		for(int d=0;d<8;d++) {
			int nx = row+dx[d];
			int ny = col+dy[d];
			
			if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
			
			if(map[nx][ny] == 'W') sum++;
		}
		
		if(sum ==0) sum = 1;
		return sum;
	}

}
