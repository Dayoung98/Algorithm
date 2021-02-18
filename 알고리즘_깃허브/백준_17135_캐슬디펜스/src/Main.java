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
		D = Integer.parseInt(st.nextToken()); //���� ���� �Ÿ�
		
		//map = new int[N+1][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				//map[i][j] = Integer.parseInt(st.nextToken());
				if(Integer.parseInt(st.nextToken()) == 1)
					enemy.add(new int[] {i,j}); //�� ��ġ ����
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
			//�ü��ڸ� ��ġ�ϰ� �� �ڸ����� ���� �� �ִ� �ִ� ���� �� ���ϱ�
			System.out.println(Arrays.toString(archer));
			int killNum = 0;
			ArrayList<int []> enemylist = new ArrayList<>();
			for(int i=0;i<enemy.size();i++) {
				enemylist.add(enemy.get(i));
			}
			while(!enemylist.isEmpty()) {
				//���� ���� �� �� ���� 
				ArrayList<Integer> kill = new ArrayList<>(); //���� �� ������ arrayList
				for(int i=0;i<3;i++) {
					int nearest =Integer.MAX_VALUE;
					int x=0,y=0;
					for(int j=0 ,size = enemylist.size();j<size;j++) {
						//�ϴ� distance ���ϱ�
						int idx[] = enemylist.get(j);
						//System.out.println("i : "+i);
						System.out.println("�ü� ��ġ ("+N+","+archer[i]+")");
						int distance = Math.abs((N)-idx[0]) +  Math.abs(archer[i]-idx[1]);
						System.out.println("�Ÿ� :"+distance);
						if(distance<=D && nearest>=distance) {
							//���� ���� �Ÿ����� ª�ƾ� �ϰ� ���� ����� ������ check �ؾ���	
							//���� ���� �Ÿ��� ���� ���ʿ� �ִ� �� �����ϱ�
							nearest = distance;
							if(nearest == distance) {
								x = (x<idx[0])?x:idx[0]; //���ʿ� �ִ°� ����
								y = (x<idx[0])?y:j;
								continue;
							}
							x = idx[0];
							y = j; //�� ��ǥ �����ϱ�
							
						}
						System.out.println("���� ����� �Ÿ� :"+nearest);
					}
					if(!kill.contains(y))
						kill.add(y); //���� �� �Ȱ�ġ�� ���� �� �߰�
				}
				killNum += kill.size();
				//���� �����ֱ�
				for(int i=0;i<kill.size();i++) {
					enemylist.set(kill.get(i), new int[] {N-1,0}); //���� ������ N-1 ���� setting���ָ� �������鼭 �������ϱ�
				}
				
				//���� ���� ���������ϱ� ���� ��ĭ �� ������ �����ֱ�
				for(int i=0;i<enemylist.size();i++) {
					int idx[] = enemylist.get(i);
					enemylist.set(i, new int[] {(idx[0]+1),idx[1]});
					if((idx[0]+1) ==N) {
						//������ �����ϱ� ����������
						enemylist.remove(i);
					}
				}
			}
			result = (result<killNum)?killNum:result;
			return ;
		}
		
		
		for(int c=start;c<M;c++) {
			archer[cnt] = c; //�ü� �ڸ� ��ġ
			comb(cnt+1,c+1);
		}
	}
}
