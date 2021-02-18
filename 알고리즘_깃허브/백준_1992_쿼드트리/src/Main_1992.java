import java.util.Arrays;
import java.util.Scanner;

public class Main_1992 {

	static int map[][];
	static int N;
	static int res;
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			String str = sc.next();
			for(int j=0;j<N;j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		getMap(0,0,N);
		
	}
	
	static boolean isTrue(int row,int col,int N) {
		int result = map[row][col];
		for(int i=row;i<row+N;i++) {
			for(int j=col;j<col+N;j++) {
				if(map[i][j]!=result)
					return false;
			}
		}
		res = result;
		return true;
	}
	static void getMap(int row,int col,int N) {
		if(isTrue(row, col, N))
			System.out.print(res);
		else {
			System.out.print("(");
			int n = N/2;
			for(int i=0;i<2;i++)
				for(int j=0;j<2;j++)
					getMap(row+n*i,col+n*j,n);
			System.out.print(")");
		}
	}
}
