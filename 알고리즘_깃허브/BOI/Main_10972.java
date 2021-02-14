import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10972 {

	private static int N,num;
	private static int arr[];
	private static boolean isSelected[];
	private static int arr2[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		arr2 = new int[N];
		isSelected = new boolean[N];
		num = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
//			sb.append(st.nextToken());
		} //이 순열의 다음에 오는 순열 출력
//		System.out.println(sb);
		/*perm(0);*/
		for(int i=N-1;i>=0;i--) {
			int temp = arr[i];
		}
	}
	
	private static void perm(int cnt) {
		if(cnt == N) {
			if(num == 1) {
				for(int i=0;i<N;i++)
					System.out.print(arr2[i]+" ");
				System.out.println();
			}
			num++;
			return;
		}
		
		if(num >1)
			return;
		for(int i=(arr[0]-1);i<N;i++) {
			if(isSelected[i])
				continue;
			arr2[cnt] = arr[i];
			isSelected[i] = true;
			perm(cnt+1);
			isSelected[i] = false;
		}
	}
}
