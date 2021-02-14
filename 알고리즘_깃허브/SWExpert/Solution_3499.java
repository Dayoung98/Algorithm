import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_3499 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			Queue<String> q1 = new LinkedList<>();
			Queue<String> q2 = new LinkedList<>();
			
			int N = sc.nextInt();
			
			for(int i=0;i<N;i++)
				q2.offer(sc.next());
			
			
			//System.out.println(N);
			int num = (N%2)==0?N/2:(N/2+1);
			//System.out.println(num);
			for(int i=0;i<num;i++) {
				//System.out.println(q2.peek());
				q1.offer(q2.poll());
			}
			
			System.out.print("#"+(t+1)+" ");
			for(int i=0;i<N;i++) {
				if(i%2 == 0)
					System.out.print(q1.poll()+" ");
				else
					System.out.print(q2.poll()+" ");
			}
			System.out.println();
			/*q1.clear();
			q2.clear();*/
		}
	}
}
