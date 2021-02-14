import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1225 {
	/*offer - Queue에 삽입
	peek() - 맨 앞 element를 반환 ( 삭제 x )
	poll() - 맨 앞 element를 반환하고 삭제*/
	private static int T;
	private static int minusNumber=1;
	private static Queue<Integer> queue;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		queue = new LinkedList<Integer>();
		
		for(int i=0;i<10;i++) {
			T = sc.nextInt(); //테스트 케이스 번호 입력
			
			for(int j=0;j<8;j++) {
				queue.offer(sc.nextInt());
			} //queue에 값 입력

			while(true) {
				 /*
				 -첫 번째 숫자를 1 감소한 뒤, 맨 뒤로 보낸다. 

				 다음 첫 번째 수는 2 감소한 뒤 맨 뒤로, 그 다음 첫 번째 수는 3을 감소하고 맨 뒤로, 그 다음 수는 4, 그 다음 수는 5를 감소한다.

				 이와 같은 작업을 한 사이클이라 한다.

				 - 숫자가 감소할 때 0보다 작아지는 경우 0으로 유지되며, 프로그램은 종료된다. 이 때의 8자리의 숫자 값이 암호가 된다.*/
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
