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
		T = Integer.parseInt(br.readLine()); //�׽�Ʈ ���̽� ����
		StringTokenizer st;
		for(int t=1;t<=T;t++) {
			maxScore = 0;
			
			st = new StringTokenizer(br.readLine());	
			N = Integer.parseInt(st.nextToken()); //����� ��
			L = Integer.parseInt(st.nextToken()); //���� Į�θ�
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
		res = 0 ; //�ʤӴ�
		int N,L;//������, Į�θ� ���Ѱ�
		int[] s;
		int[] k;
		
		for(int t=1;t<=TC;t++) {
			res = 0;
			N = sc.nextInt();
			L = sc.nextInt();
			s = new int[N];
			k = new int[N];
			
			//method���� �ȳ����� �� ������ �������� �Ѵ� => ���
			
			for(int i=0;i<N;i++) {
				s[i] = sc.nextInt();
				k[i] = sc.nextInt();
			}
			//dfs();
		}

	}

	//�Ź� �ݺ��ϸ鼭 �ٲ�� �� �Ű����� ����
	private static void dfs(int idx,int sSum,intkSum) {
		//����
		if(idx == N) {
			//�ִ밪 ���ϱ� todo simulation
			if(kSum<=L)
				res = Math.max(res, sSum);
			return;
		}
		//����
		
		//���
		dfs(idx+1,sSum+s[idx],kSum+k[idx]); //���� ���
		dfs(idx+1,sSum,kSum); //�� ���� ���
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
