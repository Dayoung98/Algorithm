import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = N;
		int idx =4;
		
		if(N>3) {
			
		}
	/*	while(true) {
			if(idx>N) break;
			
			if(idx%2 ==1) result++; //홀수면 +1 해주기 어짜피 못나눔
			else {
				int num = idx;
				result++;
				while(num%2 ==0) {
					result++;
					num = num/2;
				}
			}
		}*/
		System.out.println(result);
	}
}
