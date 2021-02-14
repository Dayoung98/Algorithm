import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9229 {
	/*스팟마트에는 N개의 과자 봉지가 있으며, 각 과자 봉지는 ai그램의 무게를 가진다.

	배가 많이 고픈 한빈이는 최대한 양이 많은 (무게가 많이 나가는) 과자 봉지를 고르고 싶으나,

	과자 두 봉지의 무게가 M 그램을 초과하면 무거워서 과자를 들고 다닐 수 없다.

	한빈이가 들고 다닐수 있는 과자들의 최대 무게 합을 출력하라. 한빈이는 과자를 “정확히” 두 봉지 사야 함에 유의하라.*/
	static int T; 
	static int N,M;
	static int number[],num[];
	static int sum, max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine()); //tc
		
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			sum = -1;
			
			N = Integer.parseInt(st.nextToken());// 과자 종류
			M = Integer.parseInt(st.nextToken()); //각 무게의 합 제한
			number = new int[N];
			num = new int[2];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				number[i] = Integer.parseInt(st.nextToken());
			}

			Comb(0, 0);
			System.out.println("#"+(t+1)+" "+sum);
		}
		
	}
	
	static void Comb(int cnt,int start) {
		if(cnt == 2) {
			int maxSum = 0;
			maxSum = num[0]+num[1];
			if(maxSum<=M && maxSum>sum) 
				sum = maxSum;
			return;
		}
		
		for(int i=start;i<N;i++) {
			num[cnt] = number[i];
			Comb(cnt+1,i+1);
		}
	}
}
