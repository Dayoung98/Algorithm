import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2443 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<i;j++)
				System.out.print(" ");
			for(int j=0;j<(N*2-1)-(i*2);j++)
				System.out.print("*");
			/*for(int j=0;j<i;j++)
				System.out.print(" ");*/
			System.out.println();
		}
		
	}
}
