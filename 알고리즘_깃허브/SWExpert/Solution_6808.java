import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6808 {

	static int T;
	static int arr[] = new int[9];
	static int card[] = new int[9];
	static int arr2[] = new int[9];
	static boolean isSelected[] = new boolean[9];
	static int win =0, lose=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			st  = new StringTokenizer(br.readLine());
			win =0;
			lose = 0;
			boolean CARD[] = new boolean[18];
			for(int i=0;i<9;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				CARD[arr[i]-1] = true;
			}//규영이의 카드 배열
			
			
			int idx =0;
			for(int i=0;i<18;i++) {
				if(!CARD[i])
					arr2[idx++] =i+1; 
			}
			
			/*System.out.println("인영이의 카드");
			System.out.println(Arrays.toString(arr2));*/
			perm(0);
			
			System.out.println("#"+(t+1)+" "+win+" "+lose);
		}
	}
	
	static void perm(int cnt) {
		if(cnt == 9) {
			/*System.out.println("인영이의 카드 배열");
			System.out.println(Arrays.toString(card));
			System.out.println("규영이의 카드 배열");
			System.out.println(Arrays.toString(arr));*/
			int Kuyoung=0,Inyoung=0;
			for(int i=0;i<9;i++) {
				if(arr[i]>card[i])
					Kuyoung += arr[i]+card[i];
				else
					Inyoung += arr[i]+card[i];
			}
			
			if(Kuyoung>Inyoung)
				win++;
			if(Inyoung>Kuyoung)
				lose++;
		}
		
		for(int i=0;i<9;i++) {
			if(isSelected[i]) continue;
			card[cnt] = arr2[i];
			isSelected[i] = true;
			perm(cnt+1);
			isSelected[i] = false;
		}
		
		
	}
}
