import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759 {

	/*암호 만들기*/
	static int L,C;
	static int cnt;
	static char arr[],arr2[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[C];
		arr2 = new char[C];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		comb(0,0);
		System.out.println(cnt);
//		System.out.println(Arrays.toString(arr));
	}
	
	static void comb(int cnt,int start) {
		if(cnt == L) {
			cnt++;
			//Arrays.sort(arr2);
			for(int i=0;i<L;i++)
				System.out.print(arr2[i]);
			System.out.println();
			return;
		}
		
		for(int i=start;i<C;i++) {
			arr2[cnt] = arr[i];
			comb(cnt+1,i+1);
		}
	}
}
