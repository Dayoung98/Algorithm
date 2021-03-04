import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int N = str.length(); //N
		int R=0,C=0;
		
		for(int i=1;i<=Math.sqrt(N);i++) {
			if(N%i==0) R = i;
		}
		C = N / R;
		char arr[][] = new char[R][C];
		//아래로 채움
		int idx=0;

		for(int i=0;i<C;i++) {
			for(int j=0;j<R;j++)
				arr[j][i] = str.charAt(idx++);
		}
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++)
				System.out.print(arr[i][j]);
		}
		
	}
}
