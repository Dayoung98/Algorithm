import java.util.Scanner;

public class Solution_2001 {
	
	private static int N; //배열크기
	private static int M; //파리채 크기
	private static int T; //TestCase
	
	private static int arr[][];
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			arr = new int[N][N];
			int sum = 0;
			int MAX = 0;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					arr[i][j] = sc.nextInt();
				}
			}//배열 입력
			
			
			//최대그거 구하기
			for(int i=0;i<=(N-M);i++) {
				for(int j=0;j<=(N-M);j++) {
					sum = getSum(i,j);
					if(MAX<sum)
						MAX = sum;
				}
			}
			
			System.out.println("#"+t+" "+MAX);
		}
	}
	
	public static int getSum(int i,int j) {
		int sum = 0;
		for(int m=0;m<M;m++) {
			for(int n=0;n<M;n++) {
				sum +=arr[i+m][j+n];
			}
		}
		return sum;
	}

}
