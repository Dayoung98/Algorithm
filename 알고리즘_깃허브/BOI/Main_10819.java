import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10819 {

	static int N;
	static int max = 0;
	static int arr[];
	static int res[];
	static boolean isSelected[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		res = new int[N];
		isSelected = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		perm(0);
		System.out.println(max);
	}
	
	static void perm(int cnt) {
		if(cnt == N) {
			int sum = 0;
			for(int i=0;i<N-1;i++)
				sum += Math.abs(res[i]-res[i+1]);
			
			if(sum>max)
				max = sum;
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(isSelected[i])
				continue;
			res[cnt] = arr[i];
			isSelected[i] = true;
			perm(cnt+1);
			isSelected[i] = false;
		}
	}
}
