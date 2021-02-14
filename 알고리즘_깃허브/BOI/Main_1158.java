import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1158 {

/*	1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다.
	이제 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 
	이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다.
	예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //N명의 사람
		int K = sc.nextInt(); //K번째 사람 제거
		sc.close();
		int idx = K-1;
		
		ArrayList<Integer> list = new ArrayList<>();
		Queue<Integer> res = new LinkedList<>();
		for(int i=0;i<N;i++)
			list.add(i+1);
		
		while(true) {
			res.offer(list.get(idx));
			list.remove(idx);
			
			if(list.isEmpty())
				break;
			idx = idx+K-1;
			
			if(idx>=list.size())
				idx = idx % list.size();
		}
		if(res.size() == 1)
			System.out.println("<"+res.poll()+">");
		else {
			System.out.print("<"+res.poll()+",");
			while(res.size()>1)
				System.out.print(" "+res.poll()+",");
			System.out.println(" "+res.poll()+">");
		}
		
	}
}
