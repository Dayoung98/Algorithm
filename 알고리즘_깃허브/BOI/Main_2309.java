import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2309 {

	static int arr[] = new int[9];
	static int arr2[] = new int[7];
	static int result[] = new int[7];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0;i<9;i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		combination(0, 0);
		Arrays.sort(result);
		for(int i=0;i<7;i++)
			System.out.println(result[i]);
	}
	
	static void combination(int cnt,int start) {
		if(cnt == 7) {
			int sum = 0;
			for(int i=0;i<7;i++) {
				sum+= arr2[i];
			}
			if(sum == 100) {
				for(int i=0;i<7;i++)
					result[i] = arr2[i];
			}
			return;
		}
		
		for(int i=start;i<9;i++) {
			arr2[cnt] = arr[i];
			combination(cnt+1, i+1);
		}
	}
}
