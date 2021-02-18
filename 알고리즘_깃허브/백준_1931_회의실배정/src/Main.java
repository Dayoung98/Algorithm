import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //회의의 최대 개수
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
				//종료 시간이 다르면
				return diff;
			}
			return start-o.start; //종료시간이 같을 경우 시작시간이 빠른 순으로 정렬
		}
	}
	
	static List<Meeting> getSchedule(Meeting[] m){
		List <Meeting> sche = new ArrayList<>();
		Arrays.sort(m); //회의실 종료 시간 순으로 정렬
		sche.add(m[0]); //첫번째 회의 확정
		
		for(int j=1;j<m.length;j++) {
			// 확정된 앞 회의의 종료시간이 다음 회의시작보다 같거나 크다면 회의 확정
			if(sche.get(sche.size()-1).end <= m[j].start) {
				sche.add(m[j]);
			}
		}
		return sche;
	}
}
