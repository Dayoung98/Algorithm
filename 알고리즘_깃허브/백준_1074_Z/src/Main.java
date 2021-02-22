//import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N,r,c;
	static boolean isTrue;
	//static int map[][];
	static int idx;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = Integer.parseInt(String.valueOf(Math.round(Math.pow(2, sc.nextInt()))));
		//반올림한 값을 string값으로 변환 후 Integer로 변환
		r = sc.nextInt();
		c = sc.nextInt();
		//map = new int[N][N];
		
		//몇 사분면인지 알면 그 사분면 부터 시작하기-> 그리고 그만큼 idx 더 해준 뒤 시작하면 됨

		/*if(r<N/2 && c<N/2) { getMap(0,0,N); }
		else if(r<N/2 && c>=N/2) {
			idx = (N/2)*(N/2);
			getMap(0,N/2,N);	
		}
		else if(r>=N/2 && c<N/2) { 
			idx = 2*(N/2)*(N/2);
			getMap(N/2,0,N);	
		}
		else if(r>=N/2 && c>=N/2) {
			idx = 3*(N/2)*(N/2);
			getMap(N/2,N/2,N);	
		}*/
		getMap(0,0,N);
/*		for(int i=0;i<N;i++)
			System.out.println(Arrays.toString(map[i]));*/
		
	}
	
	static void getMap(int row,int col,int N) {
		if(isTrue) return;
		if(N == 1) {
			System.out.println("row = "+row+", col ="+col);
			if(row == r && col == c) {
				System.out.println(idx);
				isTrue = true;
			}
			//map[row][col] = idx;
			idx++;
			return;
		}
		
		N = N/2;

		if(r<N && c<N) {
			System.out.println("1사분면");
			getMap(row,col,N);
		}
		else if(r<N && c>=N) {
			System.out.println("2사분면");
			idx += N*N;
			getMap(row,col+N,N);
		}
		else if(r>=N && c<N) {
			System.out.println("3사분면");
			idx += 2*N*N;
			getMap(row+N,col,N);
		}
		else if(r>=N && c>=N) {
			System.out.println("4사분면");
			idx += 3*N*N;
			getMap(row+N,col+N,N);
		}
	}
	
}
