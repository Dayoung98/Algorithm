import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //��� ��
		int M = sc.nextInt(); //M�� ���� �� ����
		int L = sc.nextInt(); //L��ŭ ��

		int people[] = new int [N+1];
		int start = 1 , sum = 0;
		while(true) {
			
			people[start] +=1;
			if(people[start] == M)
				break;
			if(people[start]%2 == 0) {
				//�ݽð� ��������
				start = (start-L)<=0?N-Math.abs(start-L):start-L;
			}
			else {
				//�ð��������
				start = (start+L)>N?(start+L)%N:start+L;
			}
			
			sum++;
		}
		
		System.out.println(sum);
	}

}
