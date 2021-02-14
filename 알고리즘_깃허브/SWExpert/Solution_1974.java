import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1974 {
//스도쿠 검증
	static int T;
	static int sudoku[][];
	static boolean isTrue[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			sudoku = new int[9][9];
			for(int i=0;i<9;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<9;j++)
					sudoku[i][j] = Integer.parseInt(st.nextToken());
			}
			
			int sum = 90;
			int sum2 = 45;
			int i,j;
			for(i=0;i<9;i++) {
				if(sum  != 90 || sum2!=45)
					break;
				sum = 0;
				for(j=0;j<9;j++) {
					sum = sum + sudoku[i][j] + sudoku[j][i];
					if((i%3 ==0) && (j%3==0)) 
						sum2= getSquare(i,j);
				}
			}
			
			System.out.println("#"+(t+1)+" "+ ((i==9)?1:0));

		}
	}
	
	private static int getSquare(int i, int j) {
		int sum = 0;
		for(int m=i;m<i+3;m++) {
			for(int n=j;n<j+3;n++)
				sum += sudoku[m][n];
		}
		return sum;
	}


}
