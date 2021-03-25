import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int d[] = new int[N+1];
		
		d[1] = 0;
		for(int i=2;i<=N;i++) {
			for(int j=0;j<3;j++) {
				d[i] = d[i-1]+1; //1을뺴는 경우
				if(i%2 ==0)	d[i] = Math.min(d[i], d[i/2]+1); //2로 나누어 떨어지는 경우
				if(i%3 == 0) d[i] = Math.min(d[i], d[i/3]+1); //3으로 나누어 떨어지는 경우
			}
		}
		
		System.out.println(d[N]);
	}
}
