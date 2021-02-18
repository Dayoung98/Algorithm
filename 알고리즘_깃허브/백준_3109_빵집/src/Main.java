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
		//윗행부터 시도
		
		//3방향 시도하는 녀석을 깊이우선 탐색으로 사용
		for(int i=0;i<R;i++) {
			//전체 행마다 탐색하는 애??
			visited[i][0] = true;
			dfs(i,0);
		}
		
	}
	
	static int[] dir = {-1,0,1};
	
	private static boolean dfs(int r,int c) {
		//계속해서 현재 값이 바뀌는 것이니까 매개변수로 현재 값 받기
		
		if(c == C-1) {
			//기저 조건
			cnt++;
			return true; //성공
		}
		
		int nr,nc = c+1; //nc는 무조건 옆에 열로 가니까 하나씩 증가하도록
		for(int d=0;d<3;d++) {
			nr = r + dir[d]; //새로운 값은 현재 값에 델타값만큼 더한것
			if(nr<0 || nr>=R || map[nr][nc]=='x' || visited[nr][nc]) {
				//새로운 행 탐색의 위치가 없는 행을 쳐다보는 거니까
				//혹은 장애물인 경우 탐색이 불가능
				//혹은 방문한 기록이 있는지
				continue;
			}
			
			visited[nr][nc] = true;
			if(dfs(nr,nc)) return true; //끝까지 가봤는데 길이 있다 -> 그러면 뒤에 애들이 더 탐색하지 않게 true반환
			//visited[nr][nc] = false;
			//실패했던 흔적 되돌리지 않기 : 뒤의 선택지의 방향은 현재보다 유리하지 않은 상황이고 결국 같은 상황
		}
		
		//세 방향을 모두 시도했지만 재귀를 타고 들어가지 못함
		return false;
	}

}
