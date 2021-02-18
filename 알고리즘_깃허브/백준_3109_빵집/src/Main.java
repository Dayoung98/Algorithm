import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R,C, cnt = 0;
	static char[][] map;
	static boolean[][] visited; 
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][];
		visited = new boolean[R][C]; 
		
		for(int i=0;i<R;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		makePipe();
		System.out.println(cnt);
	}
	private static void makePipe() {
		//������� �õ�
		
		//3���� �õ��ϴ� �༮�� ���̿켱 Ž������ ���
		for(int i=0;i<R;i++) {
			//��ü �ึ�� Ž���ϴ� ��??
			visited[i][0] = true;
			dfs(i,0);
		}
		
	}
	
	static int[] dir = {-1,0,1};
	
	private static boolean dfs(int r,int c) {
		//����ؼ� ���� ���� �ٲ�� ���̴ϱ� �Ű������� ���� �� �ޱ�
		
		if(c == C-1) {
			//���� ����
			cnt++;
			return true; //����
		}
		
		int nr,nc = c+1; //nc�� ������ ���� ���� ���ϱ� �ϳ��� �����ϵ���
		for(int d=0;d<3;d++) {
			nr = r + dir[d]; //���ο� ���� ���� ���� ��Ÿ����ŭ ���Ѱ�
			if(nr<0 || nr>=R || map[nr][nc]=='x' || visited[nr][nc]) {
				//���ο� �� Ž���� ��ġ�� ���� ���� �Ĵٺ��� �Ŵϱ�
				//Ȥ�� ��ֹ��� ��� Ž���� �Ұ���
				//Ȥ�� �湮�� ����� �ִ���
				continue;
			}
			
			visited[nr][nc] = true;
			if(dfs(nr,nc)) return true; //������ ���ôµ� ���� �ִ� -> �׷��� �ڿ� �ֵ��� �� Ž������ �ʰ� true��ȯ
			//visited[nr][nc] = false;
			//�����ߴ� ���� �ǵ����� �ʱ� : ���� �������� ������ ���纸�� �������� ���� ��Ȳ�̰� �ᱹ ���� ��Ȳ
		}
		
		//�� ������ ��� �õ������� ��͸� Ÿ�� ���� ����
		return false;
	}

}
