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
		Refri first = refri[0]; //�ʱⰪ ����
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
			return this.high-o.high;  //���� �µ� ���� ����
		}	
		
	}
	
	static List<Refri> getRefi(Refri [] refri){
		List<Refri> list = new ArrayList<>();
		Arrays.sort(refri); //�� �־���� �µ� �迭 �����ϱ�
		list.add(refri[0]); //�ʱⰪ ����
		
		for(int i=0;i<refri.length;i++) {
			if(refri[i].row > list.get(list.size()-1).high) {
//				count++;
				list.add(refri[i]);
			}
		}
		return list;
		
	}
}
