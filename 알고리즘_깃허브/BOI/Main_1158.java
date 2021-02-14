import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1158 {

/*	1������ N������ N���� ����� ���� �̷�鼭 �ɾ��ְ�, ���� ���� K(�� N)�� �־�����.
	���� ������� K��° ����� �����Ѵ�. �� ����� ���ŵǸ� ���� ������ �̷���� ���� ���� �� ������ ����� ������. 
	�� ������ N���� ����� ��� ���ŵ� ������ ��ӵȴ�. ������ ������� ���ŵǴ� ������ (N, K)-�似Ǫ�� �����̶�� �Ѵ�.
	���� ��� (7, 3)-�似Ǫ�� ������ <3, 6, 2, 7, 5, 1, 4>�̴�.*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //N���� ���
		int K = sc.nextInt(); //K��° ��� ����
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
