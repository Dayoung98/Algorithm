import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		BigInteger d[] = new BigInteger[N+1];
		if(N>=1) d[1] = new BigInteger("1");
		if(N>=2) d[2] = new BigInteger("3");

		for(int i=3;i<=N;i++) {
			d[i] = d[i-1].add(d[i-2]).add(d[i-2]);
		}
		
		System.out.println(d[N].remainder(new BigInteger("10007")));
	}
}
