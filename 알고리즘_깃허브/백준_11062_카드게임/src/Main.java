import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine()); //카드의 개수
			
			int card[] = new int[N];
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<N;i++) card[i] = Integer.parseInt(st.nextToken());
		}
	}
}
