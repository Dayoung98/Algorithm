import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//ù°�ٿ� ���� ���� ������ ���� ������ ����ϰ� �ִ� ��û��
		int people1=0;
		int max = 0;
		//��° �ٿ� ������ ���� ���� ������ ���� ��û��
		int maxSum = Integer.MIN_VALUE;
		int people2=0;
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt(); //������ũ�� ����
		int N = sc.nextInt(); //��û���� ��
		
		int cake[] = new int[L];
		for(int i=0;i<N;i++) {
			int P = sc.nextInt();
			int K = sc.nextInt();
			int sum = 0;
			if((K-P)>max) {
				max = (K-P);
				people1 = i+1;
			}//���� ���� ������ ���� ������ ����Ǵ� ���
			for(int j=P-1;j<K;j++) {
				if(cake[j]==0) {
					cake[j] = (i+1);
					sum++;
				} //��������� ���� ��û�� ��ȣ �־��ֱ�
			}
			if(sum > maxSum) {
				people2 = (i+1);
				maxSum = sum;
			}
		}
		System.out.println(people1);
		System.out.println(people2);
	}
}
