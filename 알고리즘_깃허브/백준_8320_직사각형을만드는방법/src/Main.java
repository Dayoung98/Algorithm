import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = 0;
		int sum = 0;
		
		/*for(int i=1;i<=N;i++) {
			//얘가 정사각형 뽑는 숫자
			sum = 0;
			for(int j=1;j<=i;j++) {
				if(i % j == 0) sum++;
			}
			result += (sum%2 ==0)?sum/2 : (sum+1)/2;
		}*/
		
		//루트 앤까지만 돌라고? J = ROOT[I]
		for(int i=1;i<=N;i++) {
			//sum = 0;
			for(int j=1;j<=Math.sqrt(i);j++)
				if(i % j ==0) sum++;
		}
		
		System.out.println(sum);
//		System.out.println(result);
	}
}
//루트로 돌리니까 시간이 훨씬 짧아진다 개쩔어