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
			idx = map[0][0]; //왼쪽 상단의 값 초기화
			//모든 정점에서 잘 퍼져 나가는지
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					//비슷한 작업 반복작업
					//재귀!
					
					//이 정점을 기준으로 상하좌우?
					solve(j,i,1,map[i][j]); //모든 정점에 따라 이 작업을 해라..	
				}
			}
			
			
			System.out.println("#"+t+" "+idx+" "+max);
			//방에 있는 번호 와 갯수
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
			} //배열 입력
			
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
		//기저조건
		if(i-1<0 || i+1>=N || j-1<0 || j+1<=N) {
			//몇번 움직였는지 더해주고 
			//max보다 크면 max바꿔주고 넣어주기?
			if(max<cnt) 
				max = cnt;
	
			//어디숫자가 그건지 더해주기
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

	private static int dx[] = {0,0,-1,1}; //상하좌우
	private static int dy[] = {-1,1,0,0};
	private static void solve(int x,int y,int cnt,int start) {
		//재귀하면 매개변수로 변화되는 값을 전달해야한다.
		//일반적으로 알고 있는 좌표 사용 i,j    r,c
		
		
		//종료조건
		
		//실행(사방으로 이동해보기)
		int nx,ny; //이동할 새로운 좌표
		for(int d=0;d<4;d++) {
			nx = x+dx[d];
			ny = y+dy[d];
			//nx,ny가 배열의 첨자가 될 것이기 때문에 범위 체크가 필요하다.
			if(nx<0 || nx>=N || ny<0 || ny>=N) {
				//버림 갈 수 없으니까 , 가능성이 없으니까 (프루닝)
				continue;
			}
			//4방위 이동 현재위치와 이동 이동의 방번호 차이가 정확히 1인 경우만 이동
			if(map[ny][nx] == map[y][x]+1 ) {
				solve(nx, ny, cnt+1,start);
			}
		}
		
		
		//재귀호출
		//마무리 작업 최대값과 최대값의 시작방 값 구하기
		if(cnt>=max) {
			if(cnt == max) {
				//idx가 누가 더 작나
				idx = Math.min(idx, start);
			}
			else {
				max = cnt;
				idx = start;
			}
			
		}
	}
}
