import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[N+1][3];
		int d[][] = new int[N+1][3];
		
		//첫번째를 R로 칠한 경우 , G로 칠한 경우, B로 칠한 경우 3가지의 경우를 고려해야한다.
		d[0][0] = 0;
		d[0][1] = 0;
		d[0][2] = 0;
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) map[i][j] = Integer.parseInt(st.nextToken());
			
			d[i][0] = Math.min(d[i-1][1], d[i-1][2]) + map[i][0];
			d[i][1] = Math.min(d[i-1][0], d[i-1][2]) + map[i][1];
			d[i][2] = Math.min(d[i-1][0], d[i-1][1]) + map[i][2];
		}
		
		Arrays.sort(d[N]);
		System.out.println(d[N][0]);
	}
}
