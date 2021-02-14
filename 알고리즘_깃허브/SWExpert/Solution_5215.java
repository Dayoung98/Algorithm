import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_5215{
 
	/*static int T;
	static int N,L;
	static int flavor[],cal[];
	static boolean isSelected[];
	static int maxScore=0;*/
	static int N,L;
	static int res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine()); //테스트 케이스 갯수
		StringTokenizer st;
		for(int t=1;t<=T;t++) {
			maxScore = 0;
			
			st = new StringTokenizer(br.readLine());	
			N = Integer.parseInt(st.nextToken()); //재료의 수
			L = Integer.parseInt(st.nextToken()); //제한 칼로리
			flavor = new int[N];
			cal= new int[N];
			isSelected = new boolean[N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				flavor[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			
			Subset(0);
			System.out.println("#"+t+" "+maxScore);
		}*/
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		res = 0 ; //초ㅣ댓값
		int N,L;//가짓수, 칼로리 제한값
		int[] s;
		int[] k;
		
		for(int t=1;t<=TC;t++) {
			res = 0;
			N = sc.nextInt();
			L = sc.nextInt();
			s = new int[N];
			k = new int[N];
			
			//method에서 안끝나고 또 밑으로 내려가고 한다 => 재귀
			
			for(int i=0;i<N;i++) {
				s[i] = sc.nextInt();
				k[i] = sc.nextInt();
			}
			//dfs();
		}

	}

	//매번 반복하면서 바뀌는 값 매개변수 전달
	private static void dfs(int idx,int sSum,intkSum) {
		//종료
		if(idx == N) {
			//최대값 구하기 todo simulation
			if(kSum<=L)
				res = Math.max(res, sSum);
			return;
		}
		//실행
		
		//재귀
		dfs(idx+1,sSum+s[idx],kSum+k[idx]); //먹은 경우
		dfs(idx+1,sSum,kSum); //안 먹은 경우
	}

	/*static void Subset(int cnt) {
		if(cnt == N) {
			int sumCal = 0;
			int sumFla = 0;
			for(int i=0;i<N;i++) {
				if(isSelected[i]) {
					sumCal += cal[i];
					sumFla += flavor[i];
				}
			}
			if(sumCal<=L && sumFla>maxScore)
				maxScore = sumFla;
			return;
		}
	
			isSelected[cnt] = true;
			Subset(cnt+1);
			isSelected[cnt] = false;
			Subset(cnt+1);
	}*/
}
