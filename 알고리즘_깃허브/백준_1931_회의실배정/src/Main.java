import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //ȸ���� �ִ� ����
		Meeting m[] = new Meeting[N];
		
		for(int i=0;i<N;i++) {
			m[i] = new Meeting(sc.nextInt(),sc.nextInt());
		}
		
		List<Meeting> list = getSchedule(m);
		System.out.println(list.size());
	}
	
	static class Meeting implements Comparable<Meeting>{
		int start;
		int end;

		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			// TODO Auto-generated method stub
			int diff = end - o.end;
			
			if(diff != 0) {
				//���� �ð��� �ٸ���
				return diff;
			}
			return start-o.start; //����ð��� ���� ��� ���۽ð��� ���� ������ ����
		}
	}
	
	static List<Meeting> getSchedule(Meeting[] m){
		List <Meeting> sche = new ArrayList<>();
		Arrays.sort(m); //ȸ�ǽ� ���� �ð� ������ ����
		sche.add(m[0]); //ù��° ȸ�� Ȯ��
		
		for(int j=1;j<m.length;j++) {
			// Ȯ���� �� ȸ���� ����ð��� ���� ȸ�ǽ��ۺ��� ���ų� ũ�ٸ� ȸ�� Ȯ��
			if(sche.get(sche.size()-1).end <= m[j].start) {
				sche.add(m[j]);
			}
		}
		return sche;
	}
}
