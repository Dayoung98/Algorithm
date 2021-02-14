import java.util.Arrays;
import java.util.Scanner;

public class Solution_2805 {

	private static int T;
	private static int N;
	private static int field[][];
	private static int field2[][];
	private static int sum=0;
	private static int num=0,num2=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
/*		N = 5;
		field = new int[5][5];
		
		for(int i=N/2;i>0;i--) {
			//if N ==5  i== 2
			for(int j=i;j<(N-i);j++) {
				field[num][j] = 1;
			}	
			num++;
		}
		
		for(int i=0;i<N;i++)
			field[N/2][i] = 1;
		
		for(int i=N/2;i>=0;i--) {
			for(int j = N-(i+1);j>=i;j--) {
				field[i+(N/2)][j] = 1;
			}
		}
		for(int i=0;i<N;i++)
			System.out.println(Arrays.toString(field[i]));*/
		
		T = sc.nextInt();
		
		for(int t=1;t<=T;t++) {
			N = sc.nextInt();
			field = new int[N][N];
			field2 = new int[N][N];
			num = 0;
			num2 = N-1;
			sum = 0;
			
			for(int i=N/2;i>0;i--) {
				//if N ==5  i== 2
				for(int j=i;j<(N-i);j++) {
					field2[num][j] = 1;
				}	
				num++;
			}
			
			for(int i=0;i<N;i++)
				field2[N/2][i] = 1;
			
			for(int i=N/2;i>=0;i--) {
				for(int j = N-(i+1);j>=i;j--) {
					field2[i+(N/2)][j] = 1;
				}
			}
			
//			for(int i=0;i<N;i++)
//				System.out.println(Arrays.toString(field2[i]));
			
			
			for(int i=0;i<N;i++) {
				String str = sc.next();
				for(int j=0;j<N;j++) {
					field[i][j] = str.charAt(j)-'0';
				}
			}


			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(field2[i][j] == 1) {
						sum += field[i][j];
					}
				}
			}
			
			System.out.println("#"+t+" "+sum);
			
			/*int sum2 = 0;

			
			for(int i=N/2;i>0;i--) {
				for(int j=i;j<(N-i);j++) {
					sum+=field[num][j];
					//System.out.print(field[num][j]+" ");
					sum2++;
				}
				num++;
			}//상단부
			
			System.out.println();
			for(int i=0;i<N;i++) {
				sum+= field[N/2][i];
				//System.out.print(field[N/2][i]+" ");
				sum2++;
			}//중단부
			System.out.println();
			
			for(int i=N/2;i>=0;i--) {
				for(int j = N-(i+1);j>=i;j--) {
					sum+= field[num2][j];
					System.out.println("i :"+i+" J :"+j);
					System.out.println("field["+num2+"]["+j+"] :"+field[num2][j]);
					sum2++;
				}
				num--;
			}//하단부
			
			System.out.println("\n횟수 :"+sum2);
			System.out.println("#"+t+" "+sum);*/
		}
	}
}
