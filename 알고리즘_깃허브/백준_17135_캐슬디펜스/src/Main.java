import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N,M,D;
	//static int map[][];
	//static ArrayList<int []> archer = new ArrayList<>();
	static int result = 0;
	static int archer[] = new int[3];
	static ArrayList<int []> enemy = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken()); //공격 제한 거리
		
		//map = new int[N+1][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				//map[i][j] = Integer.parseInt(st.nextToken());
				if(Integer.parseInt(st.nextToken()) == 1)
					enemy.add(new int[] {i,j}); //적 위치 삽입
			}
		}
	
		
		/*for(int i=0;i<N;i++) {
			int p[] = enemy.get(i);
			System.out.println(p[0]+" "+p[1]);
		}*/
	
		comb(0,0);
		System.out.println(result);
		
	}
	
	static void comb(int cnt,int start) {
		if(cnt == 3) {
			//궁수자리 배치하고 이 자리에서 죽일 수 있는 최대 적의 수 구하기
			System.out.println(Arrays.toString(archer));
			int killNum = 0;
			ArrayList<int []> enemylist = new ArrayList<>();
			for(int i=0;i<enemy.size();i++) {
				enemylist.add(enemy.get(i));
			}
			while(!enemylist.isEmpty()) {
				//적이 없어 질 때 까지 
				ArrayList<Integer> kill = new ArrayList<>(); //죽일 적 저장할 arrayList
				for(int i=0;i<3;i++) {
					int nearest =Integer.MAX_VALUE;
					int x=0,y=0;
					for(int j=0 ,size = enemylist.size();j<size;j++) {
						//일단 distance 구하기
						int idx[] = enemylist.get(j);
						//System.out.println("i : "+i);
						System.out.println("궁수 위치 ("+N+","+archer[i]+")");
						int distance = Math.abs((N)-idx[0]) +  Math.abs(archer[i]-idx[1]);
						System.out.println("거리 :"+distance);
						if(distance<=D && nearest>=distance) {
							//공격 제한 거리보다 짧아야 하고 제일 가까운 적인지 check 해야함	
							//만약 같은 거리면 제일 왼쪽에 있는 적 선택하기
							nearest = distance;
							if(nearest == distance) {
								x = (x<idx[0])?x:idx[0]; //왼쪽에 있는거 선택
								y = (x<idx[0])?y:j;
								continue;
							}
							x = idx[0];
							y = j; //적 좌표 저장하기
							
						}
						System.out.println("제일 가까운 거리 :"+nearest);
					}
					if(!kill.contains(y))
						kill.add(y); //죽일 적 안겹치면 죽일 적 추가
				}
				killNum += kill.size();
				//적들 없애주기
				for(int i=0;i<kill.size();i++) {
					enemylist.set(kill.get(i), new int[] {N-1,0}); //죽일 적들은 N-1 으로 setting해주면 내려가면서 없어지니까
				}
				
				//죽일 적들 저장했으니까 적들 한칸 씩 밑으로 내려주기
				for(int i=0;i<enemylist.size();i++) {
					int idx[] = enemylist.get(i);
					enemylist.set(i, new int[] {(idx[0]+1),idx[1]});
					if((idx[0]+1) ==N) {
						//성까지 갔으니까 없어져야함
						enemylist.remove(i);
					}
				}
			}
			result = (result<killNum)?killNum:result;
			return ;
		}
		
		
		for(int c=start;c<M;c++) {
			archer[cnt] = c; //궁수 자리 배치
			comb(cnt+1,c+1);
		}
	}
}
