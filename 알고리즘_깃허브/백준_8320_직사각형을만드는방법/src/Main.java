import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = N;
		int idx =4;
		
		if(N>3) {
			
		}
	/*	while(true) {
			if(idx>N) break;
			
			if(idx%2 ==1) result++; //Ȧ���� +1 ���ֱ� ��¥�� ������
			else {
				int num = idx;
				result++;
				while(num%2 ==0) {
					result++;
					num = num/2;
				}
			}
		}*/
		System.out.println(result);
	}
}
