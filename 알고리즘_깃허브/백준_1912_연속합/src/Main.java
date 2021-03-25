import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int [N];
		int d[] = new int[N];
		int result = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.fill(d, Integer.MIN_VALUE);
		d[0] = arr[0];
		result = d[0];
		
		for(int i=1;i<N;i++) {
			d[i] = Math.max(d[i-1]+arr[i], arr[i]);
			result = Math.max(result, d[i]);
		}
		
		System.out.println(result);
	}
}
