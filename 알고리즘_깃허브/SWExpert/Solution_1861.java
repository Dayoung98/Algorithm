import java.util.Scanner;

public class Solution_1861 {
	
	static int N;
	static int map[][];
	static int max=0;
	static int idx;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
	
		for(int t=1;t<=TC;t++) {
			idx=0;
			
			N = sc.nextInt();
			map = new int[N][N];
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			max = 0;
			idx = map[0][0]; //���� ����� �� �ʱ�ȭ
			//��� �������� �� ���� ��������
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					//����� �۾� �ݺ��۾�
					//���!
					
					//�� ������ �������� �����¿�?
					solve(j,i,1,map[i][j]); //��� ������ ���� �� �۾��� �ض�..	
				}
			}
			
			
			System.out.println("#"+t+" "+idx+" "+max);
			//�濡 �ִ� ��ȣ �� ����
		}
	}
/*
	static int arr[][];
	static int N;
	static int cnt = 1;
	static int max = 0;
	static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int T = sc.nextInt();
		
		for(int t=1;t<=T;t++) {
			N = sc.nextInt();
			arr= new int[N][N];
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++)
					arr[i][j] = sc.nextInt();
			} //�迭 �Է�
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					cnt = 1;
					find(i,j,cnt);
					System.out.println("cnt :"+cnt);
					if(cnt>max) {
						max = cnt;
						
						while(!q.isEmpty())
							q.poll();
						q.offer(arr[i][j]);
					}
					else
						q.offer(arr[i][j]);
					
				}
			}
			
			System.out.println("MAX :"+max);
		}
	}
	
	static void find(int i,int j,int cnt) {
		//��������
		if(i-1<0 || i+1>=N || j-1<0 || j+1<=N) {
			//��� ���������� �����ְ� 
			//max���� ũ�� max�ٲ��ְ� �־��ֱ�?
			if(max<cnt) 
				max = cnt;
	
			//�����ڰ� �װ��� �����ֱ�
			//cnt = cnt;
			return;
		}
		
		
		if(i-1>=0 && (arr[i][j]+1) == arr[i-1][j]) {
			cnt = cnt+1;
			find(i-1,j,cnt);
		}
		else if(i+1<N && (arr[i][j]+1) == arr[i+1][j]) {
			cnt = cnt+1;
			find(i+1,j,cnt);
		}
		else if(j-1>=0 && (arr[i][j]+1) == arr[i][j-1]) {
			cnt = cnt+1;
			find(i,j-1,cnt);
		}
		else if(j+1<N && (arr[i][j]+1) == arr[i][j+1]) {
			cnt = cnt+1;
			find(i,j+1,cnt);
		}
	}*/

	private static int dx[] = {0,0,-1,1}; //�����¿�
	private static int dy[] = {-1,1,0,0};
	private static void solve(int x,int y,int cnt,int start) {
		//����ϸ� �Ű������� ��ȭ�Ǵ� ���� �����ؾ��Ѵ�.
		//�Ϲ������� �˰� �ִ� ��ǥ ��� i,j    r,c
		
		
		//��������
		
		//����(������� �̵��غ���)
		int nx,ny; //�̵��� ���ο� ��ǥ
		for(int d=0;d<4;d++) {
			nx = x+dx[d];
			ny = y+dy[d];
			//nx,ny�� �迭�� ÷�ڰ� �� ���̱� ������ ���� üũ�� �ʿ��ϴ�.
			if(nx<0 || nx>=N || ny<0 || ny>=N) {
				//���� �� �� �����ϱ� , ���ɼ��� �����ϱ� (�����)
				continue;
			}
			//4���� �̵� ������ġ�� �̵� �̵��� ���ȣ ���̰� ��Ȯ�� 1�� ��츸 �̵�
			if(map[ny][nx] == map[y][x]+1 ) {
				solve(nx, ny, cnt+1,start);
			}
		}
		
		
		//���ȣ��
		//������ �۾� �ִ밪�� �ִ밪�� ���۹� �� ���ϱ�
		if(cnt>=max) {
			if(cnt == max) {
				//idx�� ���� �� �۳�
				idx = Math.min(idx, start);
			}
			else {
				max = cnt;
				idx = start;
			}
			
		}
	}
}
