import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char c[] = new char[N];
		String str = sc.next();
		
		for(int i=0;i<N;i++)
			c[i] = str.charAt(i);
		
		int result = 0;
		for(int i=0;i<N;i++) {
			if(c[i]=='S') result ++;
			if(c[i] =='L') {
				i = i+1;
				result++;
			}
		}
		
		//ÄÅÈ¦´õ¿¡ ÄÅÀ» ²ÈÀ» ¼ö ÀÖ´Â ÃÖ´ë »ç¶÷ÀÇ ¼ö 
		if((result+1)>N) System.out.println(N);
		else
			System.out.println(result+1);
		
	}
}
