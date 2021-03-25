import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		long num0 = 0;
		long num1 = 1;
		long result = 0;
		if(N == 1) System.out.println(num1);
		else {
			for(int i=2;i<=N;i++) {
				result = num0 + num1;
				if(i%2 ==0) num0 = result;
				else num1 = result;
			}
			System.out.println(result);
		}
	}
}
