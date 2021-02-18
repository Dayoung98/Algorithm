import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

//	static int count;
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Refri [] refri = new Refri[N];
		
		for(int i=0;i<N;i++) {
			refri[i] = new Refri(sc.nextInt(),sc.nextInt());
		}
		
		/*Arrays.sort(refri);
		Refri first = refri[0]; //초기값 저장
		int i=1;
		while(i<N) {
			if(refri[i].row>first.high) {
				first = refri[i];
				count++;
			}
			i++
		}*/
		
		List<Refri> list = getRefi(refri);
		System.out.println(list.size());
	}
	
	static class Refri implements Comparable<Refri>{
		int row;
		int high;
		public Refri(int row, int high) {
			super();
			this.row = row;
			this.high = high;
		}
		
		@Override
		public int compareTo(Refri o) {
			// TODO Auto-generated method stub
			return this.high-o.high;  //낮은 온도 기준 정렬
		}	
		
	}
	
	static List<Refri> getRefi(Refri [] refri){
		List<Refri> list = new ArrayList<>();
		Arrays.sort(refri); //값 넣어놓은 온도 배열 정렬하기
		list.add(refri[0]); //초기값 저장
		
		for(int i=0;i<refri.length;i++) {
			if(refri[i].row > list.get(list.size()-1).high) {
//				count++;
				list.add(refri[i]);
			}
		}
		return list;
		
	}
}
