import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			
			int arr[] = new int[N];
			int d[] = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
					
			for(int i=0;i<N;i++) {
				d[i] =1;
				for(int j=0;j<i;j++) {
					if(arr[j]<arr[i] && d[i]<d[j]+1) {
						d[i] = d[j]+1;
					}
				}
				max = Math.max(max, d[i]);
			}
			System.out.println("#"+(t+1)+" "+max);
		}
	}
}
