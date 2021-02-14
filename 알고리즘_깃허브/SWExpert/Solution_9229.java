import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9229 {
	/*���̸�Ʈ���� N���� ���� ������ ������, �� ���� ������ ai�׷��� ���Ը� ������.

	�谡 ���� ���� �Ѻ��̴� �ִ��� ���� ���� (���԰� ���� ������) ���� ������ ���� ������,

	���� �� ������ ���԰� M �׷��� �ʰ��ϸ� ���ſ��� ���ڸ� ��� �ٴ� �� ����.

	�Ѻ��̰� ��� �ٴҼ� �ִ� ���ڵ��� �ִ� ���� ���� ����϶�. �Ѻ��̴� ���ڸ� ����Ȯ���� �� ���� ��� �Կ� �����϶�.*/
	static int T; 
	static int N,M;
	static int number[],num[];
	static int sum, max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine()); //tc
		
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			sum = -1;
			
			N = Integer.parseInt(st.nextToken());// ���� ����
			M = Integer.parseInt(st.nextToken()); //�� ������ �� ����
			number = new int[N];
			num = new int[2];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				number[i] = Integer.parseInt(st.nextToken());
			}

			Comb(0, 0);
			System.out.println("#"+(t+1)+" "+sum);
		}
		
	}
	
	static void Comb(int cnt,int start) {
		if(cnt == 2) {
			int maxSum = 0;
			maxSum = num[0]+num[1];
			if(maxSum<=M && maxSum>sum) 
				sum = maxSum;
			return;
		}
		
		for(int i=start;i<N;i++) {
			num[cnt] = number[i];
			Comb(cnt+1,i+1);
		}
	}
}
