import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //물건의 개수
		int K = Integer.parseInt(st.nextToken()); // 가방의 무게
		
		int [] weights = new int[N+1];
		int [] profits = new int[N+1];
		int [][] D = new int[N+1][K+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			weights[i] = Integer.parseInt(st.nextToken());
			profits[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=N;i++) { //첫번째 물건 부터 고려해서
			for(int k=1;k<=K;k++) {//무게는 1부터 고려
				if(weights[i]<=k) {
					D[i][k] = Math.max(D[i-1][k-weights[i]]+profits[i], D[i-1][k]);
				}
				else {
					D[i][k] = D[i-1][k];
				}
			}
		}
		
		System.out.println(D[N][K]);
	}
}
