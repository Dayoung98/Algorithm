import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //사람 수
		int M = sc.nextInt(); //M번 받을 시 종료
		int L = sc.nextInt(); //L만큼 돔

		int people[] = new int [N+1];
		int start = 1 , sum = 0;
		while(true) {
			
			people[start] +=1;
			if(people[start] == M)
				break;
			if(people[start]%2 == 0) {
				//반시계 방향으로
				start = (start-L)<=0?N-Math.abs(start-L):start-L;
			}
			else {
				//시계방향으로
				start = (start+L)>N?(start+L)%N:start+L;
			}
			
			sum++;
		}
		
		System.out.println(sum);
	}

}
