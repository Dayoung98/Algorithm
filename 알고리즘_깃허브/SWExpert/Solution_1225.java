import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1225 {
	/*offer - Queue�� ����
	peek() - �� �� element�� ��ȯ ( ���� x )
	poll() - �� �� element�� ��ȯ�ϰ� ����*/
	private static int T;
	private static int minusNumber=1;
	private static Queue<Integer> queue;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		queue = new LinkedList<Integer>();
		
		for(int i=0;i<10;i++) {
			T = sc.nextInt(); //�׽�Ʈ ���̽� ��ȣ �Է�
			
			for(int j=0;j<8;j++) {
				queue.offer(sc.nextInt());
			} //queue�� �� �Է�

			while(true) {
				 /*
				 -ù ��° ���ڸ� 1 ������ ��, �� �ڷ� ������. 

				 ���� ù ��° ���� 2 ������ �� �� �ڷ�, �� ���� ù ��° ���� 3�� �����ϰ� �� �ڷ�, �� ���� ���� 4, �� ���� ���� 5�� �����Ѵ�.

				 �̿� ���� �۾��� �� ����Ŭ�̶� �Ѵ�.

				 - ���ڰ� ������ �� 0���� �۾����� ��� 0���� �����Ǹ�, ���α׷��� ����ȴ�. �� ���� 8�ڸ��� ���� ���� ��ȣ�� �ȴ�.*/
				if((queue.peek()-minusNumber)<=0) {
					queue.offer(0);
					queue.poll();
					minusNumber = 1;
					break;
				}

				queue.offer(queue.poll()-minusNumber);
				minusNumber++;
				if(minusNumber == 6)
					minusNumber = 1;
			}

			System.out.print("#"+T+" ");
			for(int j=0;j<8;j++)
				System.out.print(queue.poll()+" ");
			System.out.println();
			queue.clear();

		}
		
	}
}
