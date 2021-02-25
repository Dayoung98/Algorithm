import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	/*만약 두 딱지의 별의 개수가 다르다면, 별이 많은 쪽의 딱지가 이긴다.
	별의 개수가 같고 동그라미의 개수가 다르다면, 동그라미가 많은 쪽의 딱지가 이긴다.
	별, 동그라미의 개수가 각각 같고 네모의 개수가 다르다면, 네모가 많은 쪽의 딱지가 이긴다.
	별, 동그라미, 네모의 개수가 각각 같고 세모의 개수가 다르다면, 세모가 많은 쪽의 딱지가 이긴다.
	별, 동그라미, 네모, 세모의 개수가 각각 모두 같다면 무승부이다.*/
	//별 ->4  동그라미->3   네모->2   세모->1
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); //전체 라운드 수
		int A[],B[];
		for(int n=0;n<N;n++) {
			A = new int[4];
			B = new int[4];
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());  //딱지에 나온 그림의 개수
			for(int i=0;i<a;i++) A[Integer.parseInt(st.nextToken())-1]++;
			
			st = new StringTokenizer(br.readLine());
			int b= Integer.parseInt(st.nextToken());
			for(int i=0;i<b;i++) B[Integer.parseInt(st.nextToken())-1]++;
			
			for(int i=3;i>=0;) {
				if(i == 0 && A[i]==B[i]) {
					System.out.println('D');
					break;
				}
				if(A[i] == B[i]) {
					i--;
					continue;
				}
				if(A[i]>B[i]) {
					System.out.println('A');
					break;
				}
				else if(A[i]<B[i]) {
					System.out.println('B');
					break;
				}
			}
		}
	}
}
