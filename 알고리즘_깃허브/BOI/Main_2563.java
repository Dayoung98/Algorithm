import java.util.Scanner;

public class Main_2563 {

	static int N; //색종이의 수
	static int totalSum=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int arr[][] = new int[101][101];
		for(int t=0;t<N;t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int i=0;i<10;i++) {
				for(int j=0;j<10;j++)
					arr[x+i][y+j] = 1;
			}
		}//색종이 x,y좌표 입력
		
		for(int i=0;i<101;i++)
			for(int j=0;j<101;j++)
				totalSum += arr[i][j]==1?1:0;
		
		System.out.println(totalSum);
	}
	
}
