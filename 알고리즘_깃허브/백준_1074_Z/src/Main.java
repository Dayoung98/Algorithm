import java.util.Scanner;

public class Main {

	static int N,r,c;
	static int result;
	static boolean breakPoint = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		
	}
	
	static boolean getNumber(int row,int col,int N) {
		for(int i=row;i<row+N;i++) {
			for(int j=col;j<col+N;j++) {
				if(r==i && c == j) {
					breakPoint = true;
					return true;
				}
				result++;
			}
		}
		return true;
	}
	
	static void getMap(int row,int col,int N) {
		if(getNumber(row,col,N)) {
			
		}
		int n = N/2;
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				getMap(row+n*i,col+n*j,n);
			}
		}
	}
}
