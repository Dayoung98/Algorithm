import java.util.Scanner;

public class Main_3040 {

	static int arr[] = new int[9];
	static int res[] = new int[7];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<9;i++) {
			arr[i] = sc.nextInt();
		}
		comb(0,0);
	}
	
	static void comb(int cnt,int start) {
		if(cnt == 7) {
			int sum = 0;
			for(int i=0;i<7;i++)
				sum += res[i];
			if(sum == 100) {
				for(int i=0;i<7;i++)
					System.out.println(res[i]);
			}
			return;
		}
		
		for(int i=start;i<9;i++) {
			res[cnt] = arr[i];
			comb(cnt+1, i+1);
		}
	}
}
